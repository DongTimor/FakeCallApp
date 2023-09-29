package com.example.fakecallapp.function

import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity
import android.content.pm.PackageManager
import android.graphics.drawable.Drawable
import android.os.Build
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.core.app.ActivityCompat
import androidx.core.content.res.ResourcesCompat
import com.example.fakecallapp.R
import com.example.fakecallapp.activity.CallActivity
import com.example.fakecallapp.activity.MainActivity
import com.example.fakecallapp.`object`.BlurImage
import com.example.fakecallapp.`object`.LegacyBlurImage
import com.example.fakecallapp.`object`.drawableToBitmap
import com.example.fakecallapp.service_var.service_var
import com.google.accompanist.drawablepainter.rememberDrawablePainter
import com.skydoves.cloudy.Cloudy

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PhoneNumberTextField(
    value : String,
    onvaluechange : (String) -> Unit,
    modifier : Modifier
){
    TextField(
        value = value,
        onValueChange = onvaluechange,
        modifier = modifier,
        textStyle = LocalTextStyle.current.copy(textAlign = TextAlign.Center)
    )
}

@SuppressLint("MissingPermission")
@Composable
fun getWallpaper(context: Activity, serviceVar: service_var, modifier: Modifier){
    val noneAvatar: Drawable? =
        ResourcesCompat.getDrawable(context.resources, R.drawable.none_background, null)
    var wallpaper : Drawable? = noneAvatar

    wallpaper = serviceVar.wallpaperManager.drawable ?: noneAvatar
    val bitmap = drawableToBitmap(wallpaper)
    if (Build.VERSION.SDK_INT < Build.VERSION_CODES.S) {
        LegacyBlurImage(bitmap = bitmap, blurRadio = 25f)
    } else {
        BlurImage(
            bitmap,
            Modifier
                .fillMaxSize()
                .blur(radiusX = 15.dp, radiusY = 15.dp)
        )
    }
//    Cloudy(radius = 25) {
//        Image(painter = rememberDrawablePainter(drawable = wallpaper), contentDescription = "wallPaper", modifier = modifier, contentScale = ContentScale.FillWidth)
//
//    }

}