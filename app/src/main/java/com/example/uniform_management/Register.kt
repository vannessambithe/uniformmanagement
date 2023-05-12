package com.example.uniform_management

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.uniform_management.databinding.ActivityLogBinding
import com.example.uniform_management.databinding.ActivityRegisterBinding
import com.google.firebase.auth.FirebaseAuth

class Register : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding
    private lateinit var edt_emailout: EditText
    private lateinit var edt_passout: EditText
    private lateinit var btn_log: Button
    private lateinit var btn_reg: Button
    private lateinit var auth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRegisterBinding.inflate(layoutInflater)

        setContentView(binding.root)

        edt_emailout = findViewById(R.id.edtemailout)
        edt_passout = findViewById(R.id.edtpassout)
        btn_log = findViewById(R.id.btnlog)
        btn_reg = findViewById(R.id.btnreg)

        auth = FirebaseAuth.getInstance()
        binding.btnreg.setOnClickListener {
            var email = edt_emailout.text.toString().trim()
            var password = edt_passout.text.toString().trim()


            if ( email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "one of the fields is empty :(", Toast.LENGTH_SHORT).show()
            } else {
                //create a user in firebase
                auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this) {
                    if (it.isSuccessful){
                        Toast.makeText(this, "user created successfully", Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(this, "Failed to create Account", Toast.LENGTH_SHORT).show()
                        Log.d("TAG", "error-->",it.exception)
                    }

                }

            }


        }
            binding.btnlog.setOnClickListener {
                var gotolog = Intent( this, log::class.java)
                startActivity(gotolog)
                finish()
            } }
    }
