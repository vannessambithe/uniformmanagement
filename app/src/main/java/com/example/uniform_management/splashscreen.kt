package com.example.uniform_management

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class splashscreen : AppCompatActivity() {

    private lateinit var students_img: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashscreen)

        students_img = findViewById(R.id.studentsimg)
        students_img.alpha = 0
        students_img.animate().setDuration(1500).alpha( 1f).withEndAction {
            val i = Intent( this, MainActivity::class.java)
            startActivity(i)
            overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out)
        }
    }
}