package com.example.uniform_management

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.uniform_management.databinding.ActivityLogBinding
import com.example.uniform_management.databinding.ActivityRegisterBinding
import com.google.firebase.auth.FirebaseAuth

class log : AppCompatActivity() {

    private lateinit var edt_emailin: EditText
    private lateinit var edt_passin: EditText
    private lateinit var btn_login: Button
    private lateinit var btn_register: Button
    private lateinit var  auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContentView(R.layout.activity_log)

        edt_emailin = findViewById(R.id.edtemailin)
        edt_passin = findViewById(R.id.edtpassin)
        btn_login = findViewById(R.id.btnlogin)
        btn_register = findViewById(R.id.btnregister)
        auth = FirebaseAuth.getInstance()


        btn_login.setOnClickListener {
            var email = edt_emailin.toString().trim()
            var password = edt_passin.toString().trim()

            if (email.isEmpty()|| password.isEmpty()){
                Toast.makeText(this, "one of the fields is empty", Toast.LENGTH_SHORT).show()
            }else{
                auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this){
                    if (it.isSuccessful){
                        Toast.makeText(this, "Login Success", Toast.LENGTH_SHORT).show()

                        var gotomain = Intent(this, MainActivity::class.java)
                        startActivity(gotomain)
                        finish()


                    }else{
                        Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show()
                    }
                }

            }



        }
        btn_register.setOnClickListener {
            var gotoreg = Intent(this, Register::class.java)
            startActivity(gotoreg)
        }


    }
}