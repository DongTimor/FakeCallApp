package com.example.fakecallapp.navigation

import android.app.Activity
import android.content.Intent
import android.media.AudioManager
import android.os.Looper
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fakecallapp.R
import com.example.fakecallapp.activity.CallActivity
import com.example.fakecallapp.activity.MainActivity
import com.example.fakecallapp.function.getPhoneNumber
import com.example.fakecallapp.function.getWallpaper
import com.example.fakecallapp.function.playMedia
import com.example.fakecallapp.function.stopMedia
import com.example.fakecallapp.function.stopRingtone
import com.example.fakecallapp.service_var.service_var
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import kotlinx.coroutines.delay
import java.util.logging.Handler

@Composable
fun call_frag(context: Activity, serviceVar : service_var){
        var clickcount = false
        var count : String by remember {
                mutableStateOf("Việt Nam")
        }


        fun counting() = {
                var s = 0
                count = "00:00"
                val handler = android.os.Handler(Looper.getMainLooper())

                val thread = Thread{
                        while (true){
                                s++
                                handler.post {
//                            Toast.makeText(context,i.toString(),Toast.LENGTH_SHORT).show()
                                        when(s){
                                                in 0..9 ->{count = "00:0$s"}
                                                in 10..60 ->{count = "00:$s"}
                                                in 61..599 ->{
                                                        if((s-(s/60)*60) < 10){
                                                                count = "0"+(s/60)+":0"+(s-(s/60)*60)
                                                        }else{
                                                                count = "0"+(s/60)+":"+(s-(s/60)*60)
                                                        }
                                                }
                                                in 600..3599 ->{
                                                        if((s-(s/60)*60) < 10){
                                                                count = (s/60).toString()+":0"+(s-(s/60)*60)
                                                        }else{
                                                                count = (s/60).toString()+":"+(s-(s/60)*60)
                                                        }
                                                }
                                                in 3600..35999->{
                                                        if((s-(s/3600)*3600)/60<10){
                                                                if(((s-(s/3600)*3600)-((s-(s/3600)*3600)/60)*60)<10){
                                                                        count = "0"+s/3600+":0"+(s-(s/3600)*3600)/60+":0"+((s-(s/3600)*3600)-((s-(s/3600)*3600)/60)*60)

                                                                }else{
                                                                        count = "0"+s/3600+":0"+(s-(s/3600)*3600)/60+":"+((s-(s/3600)*3600)-((s-(s/3600)*3600)/60)*60)

                                                                }

                                                        }else{
                                                                if(((s-(s/3600)*3600)-((s-(s/3600)*3600)/60)*60)<10){
                                                                        count = "0"+s/3600+":"+(s-(s/3600)*3600)/60+":0"+((s-(s/3600)*3600)-((s-(s/3600)*3600)/60)*60)

                                                                }else{
                                                                        count = "0"+s/3600+":"+(s-(s/3600)*3600)/60+":"+((s-(s/3600)*3600)-((s-(s/3600)*3600)/60)*60)

                                                                }
                                                        }

                                                }
                                                else->{
                                                        if((s-(s/3600)*3600)/60<10){
                                                                if(((s-(s/3600)*3600)-((s-(s/3600)*3600)/60)*60)<10){
                                                                        count = ""+s/3600+":0"+(s-(s/3600)*3600)/60+":0"+((s-(s/3600)*3600)-((s-(s/3600)*3600)/60)*60)

                                                                }else{
                                                                        count = ""+s/3600+":0"+(s-(s/3600)*3600)/60+":"+((s-(s/3600)*3600)-((s-(s/3600)*3600)/60)*60)

                                                                }

                                                        }else{
                                                                if(((s-(s/3600)*3600)-((s-(s/3600)*3600)/60)*60)<10){
                                                                        count = ""+s/3600+":"+(s-(s/3600)*3600)/60+":0"+((s-(s/3600)*3600)-((s-(s/3600)*3600)/60)*60)

                                                                }else{
                                                                        count = ""+s/3600+":"+(s-(s/3600)*3600)/60+":"+((s-(s/3600)*3600)-((s-(s/3600)*3600)/60)*60)

                                                                }
                                                        }

                                                }


                                        }
                                }
                                Thread.sleep(1000)

                        }
                        }

                thread.start()
        }
        fun checkClick() = {
                clickcount = true
        }
        fun getClick():Boolean{
                return clickcount
        }
        Box(modifier = Modifier) {

                getWallpaper(
                        context = context,
                        serviceVar = serviceVar,
                        modifier = Modifier
                                .fillMaxSize()

                )

                Column(
                        verticalArrangement = Arrangement.Top,
                        modifier = Modifier
                                .fillMaxSize()

                ) {
                        Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center,
                                modifier = Modifier
                                        .fillMaxWidth()
//                                        .background(Color.Cyan)
                        ) {
                                Spacer(modifier = Modifier.fillMaxHeight(0.1f))
                                Text(
                                        text = getPhoneNumber(context), modifier = Modifier,
                                        fontSize = 30.sp,
                                        color = Color.White
                                )
                                Text(
                                        text = count,
                                        color = Color.White
                                )
                        }
//        Spacer(modifier = Modifier.fillMaxHeight(0.3f))
                        Navigation(context = context, serviceVar = serviceVar, counting(), checkClick(), getClick())
                }


        }
}