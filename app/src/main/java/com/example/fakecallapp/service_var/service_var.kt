package com.example.fakecallapp.service_var

import android.app.NotificationManager
import android.app.WallpaperManager
import android.content.Context
import android.content.SharedPreferences
import android.media.AudioManager
import android.media.MediaPlayer
import android.media.Ringtone
import android.media.RingtoneManager
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.core.content.ContextCompat.getSystemService
import androidx.core.content.getSystemService
import androidx.appcompat.app.AppCompatDelegate
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.fakecallapp.R

open class service_var(context : Context){

    open var audioManager: AudioManager = context.getSystemService(Context.AUDIO_SERVICE) as AudioManager
    open var notification: NotificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as  NotificationManager
//    open val sharedPreferences = context.getSharedPreferences("myData",Context.MODE_PRIVATE)
    open var wallpaperManager: WallpaperManager = WallpaperManager.getInstance(context)
    open var ringtoneManager =  RingtoneManager.getRingtone(context,RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE)) as Ringtone
    lateinit var media : MediaPlayer
    open var darkMode : Boolean =
        when (AppCompatDelegate.getDefaultNightMode()){
        AppCompatDelegate.MODE_NIGHT_YES -> true
        else -> false

    }


}