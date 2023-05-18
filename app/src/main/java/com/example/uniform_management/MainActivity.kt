package com.example.uniform_management

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {
    private lateinit var edt_itemname : EditText
    private lateinit var edt_itemdescrition : EditText
    private lateinit var edt_sizes : EditText
    private lateinit var btn_data : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edt_itemname = findViewById(R.id.edtitemname)
        edt_itemdescrition = findViewById(R.id.edtitemdescription)
        edt_sizes = findViewById(R.id.edtsizes)
        btn_data = findViewById(R.id.btndata)

        btn_data.setOnClickListener {
            var itemname =edt_itemname.text.toString().trim()
            var itemdescription= edt_itemdescrition.text.toString().trim()
            var sizes= edt_sizes.text.toString().trim()





            if (itemname.isEmpty()|| itemdescription.isEmpty()|| sizes.isEmpty()){

                Toast.makeText(this, "Cannot submit an empty field", Toast.LENGTH_SHORT).show()
            }else {
                var my_child = FirebaseDatabase.getInstance().reference.child("Item Names/" )
                var user_data = user(itemname, itemdescription, sizes)

                my_child.setValue(user_data).addOnCompleteListener {
                    if (it.isSuccessful){
                        Toast.makeText(this, "Data Uploaded", Toast.LENGTH_SHORT).show()
                        var gotoview = Intent(this, viewusers::class.java)
                        startActivity(gotoview)

                    }else{
                        Toast.makeText(this, "data upload failed", Toast.LENGTH_SHORT).show()
                    }
                }

            }
        }
    }}










