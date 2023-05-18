package com.example.uniform_management

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.Toast
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class viewusers : AppCompatActivity() {
    lateinit var  my_list_view: ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_viewusers)

        my_list_view = findViewById(R.id.mlistview)


        var users:ArrayList<user>  = ArrayList()

        var myadapter = customAdapter(applicationContext, users )


        //access the table

        var my_db = FirebaseDatabase.getInstance().reference.child("ItemNames")

        my_db.addValueEventListener(object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                //get data and display in array
                users.clear()
                for (snap in snapshot.children){
                    var person = snap.getValue(user::class.java)
                    users.add(person!!)
                }

                myadapter.notifyDataSetChanged()

            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(applicationContext, "Failed to Display Data", Toast.LENGTH_SHORT).show()

            }

        })

        my_list_view.adapter = myadapter

    }
}


