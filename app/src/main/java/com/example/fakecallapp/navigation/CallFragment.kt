package com.example.fakecallapp.navigation

import android.app.Activity
import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.fakecallapp.R
import com.example.fakecallapp.activity.MainActivity
import com.example.fakecallapp.function.playMedia
import com.example.fakecallapp.function.stopMedia
import com.example.fakecallapp.function.stopRingtone
import com.example.fakecallapp.service_var.service_var

@Composable
fun CallFragment(context:Activity, serviceVar:service_var, counting :() -> Unit, next :() -> Unit, checkClick:()->Unit,getClick: Boolean){
    var alpha by remember {
        mutableStateOf(1f)
    }

    Row(
        modifier = Modifier
            .fillMaxSize()
            .alpha(alpha)
            ,

        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.Bottom,




        ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                painter = painterResource(id = R.drawable.alarm),
                contentDescription = "alarm",
                tint = Color.White,
                modifier = Modifier
                    .size(26.dp)
            )
            Text(text = "Nhắc tôi", color = Color.White)
            Spacer(modifier = Modifier.size(30.dp))

            Button(
                onClick = {
                    stopRingtone(serviceVar.ringtoneManager)
                    stopMedia(serviceVar)
                    context.startActivity(Intent(context, MainActivity::class.java))
                    context.finish()
                },
                modifier = Modifier
                    .clip(CircleShape)
                    .background(Color.Red, shape = CircleShape)
                    .size(80.dp),


                colors = ButtonDefaults.buttonColors(Color.Transparent),

                ) {
                Icon(
                    painter = painterResource(id = R.drawable.phone1),
                    contentDescription = null,
                    modifier = Modifier.size(50.dp)
                )
            }
            Text(text = "Từ chối", color = Color.White)
            Spacer(modifier = Modifier
                .fillMaxHeight(0.2f)
                )

        }
        Spacer(modifier = Modifier.fillMaxWidth(0.3f))
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                painter = painterResource(id = R.drawable.mess),
                contentDescription = "alarm",
                tint = Color.White,
                modifier = Modifier
                    .size(26.dp)
            )

            Text(text = "Tin nhắn", color = Color.White)
            Spacer(modifier = Modifier.size(30.dp))

            Button(
                onClick = {
                    checkClick
                    playMedia(context, serviceVar, R.raw.donate)
                    counting()
//                        alpha = 0f
                    next()
                },
                modifier = Modifier
                    .clip(CircleShape)
                    .background(Color.Green, shape = CircleShape)
                    .size(80.dp),


                colors = ButtonDefaults.buttonColors(Color.Transparent),

                ) {
                Icon(
                    painter = painterResource(id = R.drawable.phone2),
                    contentDescription = null,
                    modifier = Modifier.size(50.dp)
                )
            }
            Text(text = "Chấp nhận", color = Color.White)
            Spacer(modifier = Modifier
                .fillMaxHeight(0.2f)
            )

        }


        

    }

}