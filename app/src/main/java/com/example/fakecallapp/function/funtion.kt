package com.example.fakecallapp.function

import android.annotation.SuppressLint
import android.app.Activity
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.media.AudioManager
import android.media.MediaPlayer
import android.media.Ringtone
import android.media.RingtoneManager
import android.net.Uri
import android.os.Build
import android.os.Handler
import android.provider.Settings
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.example.fakecallapp.activity.MainActivity
import com.example.fakecallapp.service_var.service_var


fun setVibrate(context : Context, notification : NotificationManager, audio : AudioManager){
    if (
        android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M &&
        !notification.isNotificationPolicyAccessGranted
        ){
        val intent = Intent(Settings.ACTION_NOTIFICATION_POLICY_ACCESS_SETTINGS)
        Toast.makeText(context,"Please grant Audio's Permission",Toast.LENGTH_SHORT).show()
        context.startActivity(intent)
    }else{
        if(audio.ringerMode != AudioManager.RINGER_MODE_VIBRATE){
            audio.ringerMode = AudioManager.RINGER_MODE_VIBRATE
            Toast.makeText(context, "Vibrate Mode : On", Toast.LENGTH_SHORT).show()

        }else{
            audio.ringerMode = AudioManager.RINGER_MODE_NORMAL
            Toast.makeText(context, "Vibrate Mode : Off", Toast.LENGTH_SHORT).show()

        }
    }
}


fun setDarkMode(context : MainActivity) : String{
    try {
        context.darkMode = !context.darkMode
    }catch (e : Exception){
        Toast.makeText(context,e.toString(),Toast.LENGTH_SHORT).show()
    }
    return if(context.darkMode){ "On"}else{"Off"}

}

fun getResult(context: MainActivity) : ActivityResultLauncher<Intent> {
    return context.registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ){
        if(it.resultCode == Activity.RESULT_OK){
            val value = it.data?.getParcelableExtra<Uri>(RingtoneManager.EXTRA_RINGTONE_PICKED_URI)
            if (value != null) {
                val ringtone =RingtoneManager.getRingtone(context,value)
                try {
                    RingtoneManager.setActualDefaultRingtoneUri(context,RingtoneManager.TYPE_RINGTONE,value)
                    Toast.makeText(context,ringtone.getTitle(context),Toast.LENGTH_LONG).show()

                }catch (e : Exception){Toast.makeText(context,e.toString(),Toast.LENGTH_SHORT).show()}
            }
        }

    }
}

fun setRingtone(context : MainActivity , getResult: ActivityResultLauncher<Intent>){
    if(android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M && Settings.System.canWrite(context) == false){
        Toast.makeText(context,"Please grant Ringtone 's Permission",Toast.LENGTH_SHORT).show()
        context.startActivity(Intent(Settings.ACTION_MANAGE_WRITE_SETTINGS))
    }else{
        val intent = Intent(RingtoneManager.ACTION_RINGTONE_PICKER)
        intent.putExtra(RingtoneManager.EXTRA_RINGTONE_TITLE,"Choose a Ringtone")
        intent.putExtra(RingtoneManager.EXTRA_RINGTONE_TYPE,RingtoneManager.TYPE_RINGTONE)


        getResult.launch(intent)


    }
}

@RequiresApi(Build.VERSION_CODES.P)
fun playRingtone(ringtone : Ringtone){

    ringtone.isLooping = true

    ringtone.play()

}

fun stopRingtone(ringtone: Ringtone){


    if(ringtone.isPlaying){
        ringtone.stop()
    }

}

fun savePhoneNumber(context: Activity, phoneNumber: String){
    val sharedPref = context.getSharedPreferences("mydata",Context.MODE_PRIVATE) ?: return
    with (sharedPref.edit()) {
        putString("PhoneNumber", phoneNumber)
        apply()
    }
}

fun saveDarkNumber(context: Activity, phoneNumber: String){
    val sharedPref = context.getSharedPreferences("mydata",Context.MODE_PRIVATE) ?: return
    with (sharedPref.edit()) {
        putString("DarkMode", phoneNumber)
        apply()
    }
}


fun getPhoneNumber(context: Activity) : String{
    val sharedPref = context.getSharedPreferences("mydata",Context.MODE_PRIVATE)
    val highScore = sharedPref?.getString("PhoneNumber","Unknown")
    return highScore.toString()
}

fun getDarkMode(context: Activity) : String{
    val sharedPref = context.getSharedPreferences("mydata",Context.MODE_PRIVATE)
    val highScore = sharedPref?.getString("DarkMode","Unknown")
    return highScore.toString()
}

@SuppressLint("SuspiciousIndentation")
fun playMedia(context : Activity, serviceVar: service_var, url : Int){
    stopRingtone(serviceVar.ringtoneManager)
    serviceVar.media = MediaPlayer.create(context,url)

        Handler().postDelayed({
            serviceVar.media.start()
            serviceVar.media.isLooping = true}, 1000)




}

fun stopMedia( serviceVar: service_var){
    if(serviceVar.media.isPlaying){
        serviceVar.media.stop()

    }
}

fun SecondCount(){
    val thread = Thread{

    }
}