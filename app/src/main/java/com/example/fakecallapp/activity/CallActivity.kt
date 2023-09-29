package com.example.fakecallapp.activity

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.fakecallapp.function.playRingtone
import com.example.fakecallapp.navigation.call_frag
import com.example.fakecallapp.service_var.service_var
import com.example.fakecallapp.ui.theme.FakeCallAppTheme

class CallActivity : ComponentActivity() {

    @RequiresApi(Build.VERSION_CODES.P)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val serviceVar = service_var(this)

        playRingtone(serviceVar.ringtoneManager)
        serviceVar.audioManager
        setContent {

            FakeCallAppTheme(darkTheme = false) {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ){

                    call_frag(context = this, serviceVar)
                }

            }

        }
    }
}