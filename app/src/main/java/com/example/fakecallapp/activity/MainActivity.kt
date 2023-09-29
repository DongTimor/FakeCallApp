package com.example.fakecallapp.activity

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.fakecallapp.function.getDarkMode
import com.example.fakecallapp.function.getResult
import com.example.fakecallapp.function.permissions
import com.example.fakecallapp.navigation.main_frag
import com.example.fakecallapp.service_var.service_var
import com.example.fakecallapp.ui.theme.FakeCallAppTheme

class MainActivity : ComponentActivity() {

    var darkMode : Boolean by mutableStateOf(false)
    val getResult = getResult(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val serviceVar = service_var(this)
        val permission = permissions(this)
//        Toast.makeText(this, getDarkMode(this),Toast.LENGTH_SHORT).show()
        if(getDarkMode(this) != "Unknown"){
            if(getDarkMode(this) == "On"){
                darkMode = true
            }else{
                darkMode = false
            }
        }else{
            darkMode = serviceVar.darkMode

        }


        permission.checkPermission(this)
        setContent {
            FakeCallAppTheme(darkTheme = darkMode) {

                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    main_frag(this, serviceVar, permission)
                }
            }
        }
    }
}





