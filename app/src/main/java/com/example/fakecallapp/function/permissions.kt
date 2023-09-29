package com.example.fakecallapp.function

import android.Manifest
import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.provider.Settings
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import com.example.fakecallapp.activity.MainActivity

class permissions(context : MainActivity){
    val permissions = arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE)




    fun showPermissiomDialog(context: Activity) {
        val builder = AlertDialog.Builder(context)
        builder.setTitle("Permission require")
        builder.setMessage("Some permission need to be allowed for this ap")
        builder.setPositiveButton("Grant"){d,_ ->
            d.cancel()
            context.startActivity(Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS).apply {
                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                val uri = Uri.fromParts("pakage",context.packageName,null)
                context.intent.data = uri
            })
        }
        builder.setNegativeButton("cancel"){d,_ ->
            d.dismiss()
        }
    }

    val permissionRequestLauncher =
        context.registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()){ permissions ->
            val isGranted = permissions.entries.all{it.value}
            if(isGranted){

                Toast.makeText(context,"all of permission are granted",Toast.LENGTH_SHORT).show()
            }else{
                showPermissiomDialog(context)
            }

        }

    fun checkPermission(context: MainActivity) : Boolean{

        if(hasPermission(context)){

            return true
        }else{
            permissionRequestLauncher.launch(permissions)
            return false
        }
    }

    fun hasPermission(context: Activity) : Boolean = permissions.all{
        ActivityCompat.checkSelfPermission(context,it) == PackageManager.PERMISSION_GRANTED
    }
}
