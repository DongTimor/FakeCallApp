package com.example.fakecallapp.navigation

import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.fakecallapp.activity.CallActivity
import com.example.fakecallapp.service_var.service_var

@Composable
fun Navigation(context : Activity, serviceVar: service_var, counting: () -> Unit,checkClick: () -> Unit,getClick:Boolean){
    val Nav = rememberNavController()
    NavHost(navController = Nav , startDestination = "CallActivity"){
        composable("CallActivity"){
            CallFragment(context,serviceVar,counting,
                next = {Nav.navigate("Calling")
                    },
                checkClick,getClick

                )
}
        composable("Calling"){
            Calling_frag(context,serviceVar)
        }
    }
}