package com.example.intents

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import android.provider.AlarmClock.*
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun lanzarActivity(v: View){

        val myIntent = Intent(this,MainActivity2::class.java).apply {
            putExtra("dato","Alexander Huarcaya")
        }

        startActivity(myIntent)

    }

    fun crearAlarma(v:View){

        val message="A Programar con LAChirana Plat"
        val hora=20
        val minuto=19

        val intent=Intent(AlarmClock.ACTION_SET_ALARM).apply {
            putExtra(EXTRA_MESSAGE,message)
            putExtra(EXTRA_HOUR,hora)
            putExtra(EXTRA_MINUTES,minuto)
        }

        if(intent.resolveActivity(packageManager) != null){
            startActivity(intent)
        }

    }

    fun alarmas(v:View){
        val intent=Intent(AlarmClock.ACTION_SHOW_ALARMS)
        startActivity(intent)
    }

    fun sendMessage(v:View){
        val intent=Intent(Intent.ACTION_SEND).apply {
            putExtra(EXTRA_MESSAGE, "saludos a todos")
            type="text/plain"
        }

        startActivity(intent)
    }

    fun mapas(v:View){

        val intent=Intent(Intent.ACTION_VIEW).apply {
            data= Uri.parse("geo:0,0?q=Qatar")
        }

        startActivity(intent)

    }// APIS = interfaces de programacion de aplicaciones== Maps

    fun calling(v:View){
        val i=Intent(Intent.ACTION_DIAL).apply {
            data=Uri.parse("tel:+51977364751")
        }

        startActivity(i)
    }

    fun seeWeb(v:View){
        val url=Uri.parse("https://developer.android.com/guide/components/intents-filters?hl=es-419")
        val i=Intent(Intent.ACTION_VIEW,url)
        startActivity(i)
    }

    fun launchFace(v:View){
        val inFace=packageManager.getLaunchIntentForPackage("com.facebook.katana")
        startActivity(inFace)
    }

}