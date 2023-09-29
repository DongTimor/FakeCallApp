package com.example.fakecallapp.navigation

import android.app.Activity
import android.content.Intent
import android.icu.text.AlphabeticIndex.Bucket.LabelType
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fakecallapp.R
import com.example.fakecallapp.activity.MainActivity
import com.example.fakecallapp.function.stopMedia
import com.example.fakecallapp.function.stopRingtone
import com.example.fakecallapp.service_var.service_var
import com.skydoves.cloudy.Cloudy

@Composable
fun Calling_frag(context:Activity,serviceVar:service_var){
//    delete()
    Column(Modifier.fillMaxSize(),horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.SpaceEvenly) {
        Spacer(modifier = Modifier.fillMaxHeight(0.1f))
        Row(Modifier.fillMaxWidth(0.8f), horizontalArrangement = Arrangement.SpaceAround, verticalAlignment = Alignment.CenterVertically) {

            Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {

                    Button(
                        onClick = { /*TODO*/ },
                        modifier = Modifier
                            .clip(CircleShape)
                            .background(Color.White.copy(alpha = 0.15f), shape = CircleShape)
                            .size(80.dp),


                        colors = ButtonDefaults.buttonColors(Color.Transparent),

                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.mic_off),
                            contentDescription = null,
                            modifier = Modifier.size(30.dp)
                        )
                    }
                    Spacer(modifier = Modifier.size(6.dp))
                    Text(
                        text = "tắt tiếng",
                        modifier = Modifier,
                        color = Color.White,
                        fontSize = 15.sp

                    )
                Spacer(modifier = Modifier.size(20.dp))
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .clip(CircleShape)
                        .background(Color.White.copy(alpha = 0.15f), shape = CircleShape)
                        .size(80.dp),


                    colors = ButtonDefaults.buttonColors(Color.Transparent),


                    ) {
                    Icon(
                        painter = painterResource(id = R.drawable.add),
                        contentDescription = null,
                        modifier = Modifier.size(30.dp)
                    )
                }
                Spacer(modifier = Modifier.size(6.dp))
                Text(
                    text = "thêm\ncuộc gọi",
                    color = Color.White,
                    fontSize = 15.sp,
                    modifier = Modifier.width(80.dp),
                    textAlign = TextAlign.Center


                )








            }
            Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {

                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .clip(CircleShape)
                        .background(Color.White.copy(alpha = 0.15f), shape = CircleShape)
                        .size(80.dp),


                    colors = ButtonDefaults.buttonColors(Color.Transparent),

                    ) {
                    Icon(
                        painter = painterResource(id = R.drawable.keypad),
                        contentDescription = null,
                        modifier = Modifier.size(30.dp)
                    )
                }
                Spacer(modifier = Modifier.size(6.dp))
                Text(
                    text = "bàn phím",
                    modifier = Modifier,
                    color = Color.White,
                    fontSize = 15.sp

                )
                Spacer(modifier = Modifier.size(20.dp))
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .clip(CircleShape)
                        .background(Color.White.copy(alpha = 0.15f), shape = CircleShape)
                        .size(80.dp),


                    colors = ButtonDefaults.buttonColors(Color.Transparent),

                    ) {
                    Icon(
                        painter = painterResource(id = R.drawable.face_time),
                        contentDescription = null,
                        modifier = Modifier.size(30.dp)
                    )
                }
                Spacer(modifier = Modifier.size(6.dp))
                Text(
                    text = "FaceTime\n",
                    modifier = Modifier,
                    color = Color.White,
                    fontSize = 15.sp

                )








            }
            Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {

                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .clip(CircleShape)
                        .background(Color.White.copy(alpha = 0.15f), shape = CircleShape)
                        .size(80.dp),


                    colors = ButtonDefaults.buttonColors(Color.Transparent),

                    ) {
                    Icon(
                        painter = painterResource(id = R.drawable.volumn_up),
                        contentDescription = null,
                        modifier = Modifier.size(30.dp)
                    )
                }
                Spacer(modifier = Modifier.size(6.dp))
                Text(
                    text = "loa ngoài",
                    modifier = Modifier,
                    color = Color.White,
                    fontSize = 15.sp

                )
                Spacer(modifier = Modifier.size(20.dp))
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .clip(CircleShape)
                        .background(Color.White.copy(alpha = 0.15f), shape = CircleShape)
                        .size(80.dp),


                    colors = ButtonDefaults.buttonColors(Color.Transparent),

                    ) {
                    Icon(
                        painter = painterResource(id = R.drawable.supervisor_account),
                        contentDescription = null,
                        modifier = Modifier.size(30.dp)
                    )
                }
                Spacer(modifier = Modifier.size(6.dp))
                Text(
                    text = "danh bạ\n",
                    modifier = Modifier,
                    color = Color.White,
                    fontSize = 15.sp

                )

            }

        }

        Button(
            onClick = {
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
    }
}