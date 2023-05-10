package com.example.uniform_management

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.firebase.auth.FirebaseAuth

class login : AppCompatActivity() {

    private lateinit var edtemailin: EditText
    private lateinit var edtpassin: EditText
    private lateinit var btn_in: Button
    private lateinit var btn_register: Button
    private lateinit var  auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        edtemailin = findViewById(R.id.edtemailin)
        edtpassin = findViewById(R.id.edtpassin)
        btn_in = findViewById(R.id.btnin)
        btn_register = findViewById(R.id.btnregister)
        auth = FirebaseAuth.getInstance()

    }
}