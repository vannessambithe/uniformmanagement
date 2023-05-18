package com.example.uniform_management

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.util.Timer
import java.util.TimerTask

class splashscreen : AppCompatActivity() {

    private lateinit var timer: Timer


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashscreen)

        timer= Timer()
        timer.schedule(object : TimerTask(){
            override fun run(){
                val intent = Intent(this@splashscreen,log::class.java)
                startActivity(intent)
                finish()
            }
        }, 3000)







    }
}