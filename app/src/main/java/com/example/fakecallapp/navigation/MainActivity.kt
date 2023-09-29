package com.example.fakecallapp.navigation


import android.app.AlarmManager
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.provider.Settings
import android.text.format.DateFormat.is24HourFormat
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.getString
import androidx.core.content.ContextCompat.startActivity
import com.example.fakecallapp.function.PhoneNumberTextField
import com.example.fakecallapp.R
import com.example.fakecallapp.activity.MainActivity
//import com.example.fakecallapp.function.checkPermission
import com.example.fakecallapp.function.getPhoneNumber
import com.example.fakecallapp.function.permissions
import com.example.fakecallapp.function.saveDarkNumber
import com.example.fakecallapp.function.savePhoneNumber
import com.example.fakecallapp.service_var.service_var
import com.example.fakecallapp.function.setDarkMode
import com.example.fakecallapp.function.setRingtone
import com.example.fakecallapp.function.setVibrate
import com.example.fakecallapp.service.HanderService
import java.util.Calendar

private var time: Long = 0
private var time_hour = 0
private var time_minute = 0
private var time_changed = 0
@Composable
fun main_frag(context: MainActivity, servicevar: service_var,permission: permissions, modifier: Modifier = Modifier) {


    var phoneNumber : String by remember {
        mutableStateOf(getPhoneNumber(context))
    }
    var checkDarkMode : String by remember {
        mutableStateOf(if(servicevar.darkMode){"On"}else{"Off"})
    }


    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Fake Call App")
        Image(
            painter = painterResource(id = R.drawable.none_avatar),
            contentDescription = "avatar",
            modifier = Modifier
                .size(90.dp)
                .clip(shape = CircleShape)
        )
        PhoneNumberTextField(
            value = phoneNumber,
            onvaluechange = {phoneNumber = it},
            modifier = Modifier
                .fillMaxWidth(0.6f)

        )



        Spacer(modifier = Modifier.size(25.dp))

        Column(
            modifier = Modifier
                .wrapContentSize()
                .width(IntrinsicSize.Max),

            verticalArrangement = Arrangement.SpaceBetween

        ) {
            Button(
                onClick = {
                    Toast.makeText(context,"The fake call will be come in a few seconds", Toast.LENGTH_LONG).show()
                    savePhoneNumber(context,phoneNumber)
                    val intent = Intent(context, HanderService::class.java)
                    context.startService(intent)
                    context.finish()
                },
                modifier = Modifier
                    .fillMaxWidth(),


                ) {
                Text(text = "Call")
            }
            Button(
                onClick = { setVibrate(context,servicevar.notification, servicevar.audioManager) },
                modifier = Modifier
                    .fillMaxWidth(),


                ) {
                Text(text = "Vibrate Mode")
            }
            Button(
                onClick = {
                          checkDarkMode = setDarkMode(context = context)
                          saveDarkNumber(context,checkDarkMode)
                },
                modifier = Modifier
                    .fillMaxWidth(),


                ) {
                Text(text = "DarkMode :$checkDarkMode")
            }
            Button(
                onClick = { setRingtone(context,context.getResult) },
                modifier = Modifier
                    .fillMaxWidth(),


                ) {
                Text(text = "Ringtone")
            }
            Button(
                onClick = {
                          context.finish()
                          },
                modifier = Modifier
                    .fillMaxWidth(),


                ) {
                Text(text = "Exit")
            }
        }


    }
}