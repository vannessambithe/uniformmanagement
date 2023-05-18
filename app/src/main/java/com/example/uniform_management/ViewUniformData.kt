package com.example.uniform_management

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class ViewUniformData : AppCompatActivity() {

    private lateinit var mood1 : TextView
    private lateinit var mood2 : TextView
    private lateinit var mood3 : TextView


    //initilaise your listview
    lateinit var mood_list: ListView

    //array list
    lateinit var mood: ArrayList<user>

    //declare adapter
    lateinit var adapter: customAdapter





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_uniform_data)


      mood_list = findViewById(R.id.mylist_people)

        mood = ArrayList()

        adapter = customAdapter(this, mood)

        val WhatHappenedTodaySITUATIONEMOTION = intent.getStringExtra("happenedsituation")
        val HowDoYouFeelTodayEMOTIONEXPERIENCE = intent.getStringExtra("feelemotion")
        val HowDoYouFeelTodayWASABLETOACHIEVEMENT = intent.getStringExtra("happenedsituation")


        var ref = FirebaseDatabase.getInstance().getReference().child("Moods")

        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                mood.clear()

                //loop to insert and display
                for (snap in snapshot.children){
                    var usermood = snap.getValue(user::class.java)
                    mood.add(usermood!!)
                }
                adapter.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {

                Toast.makeText(applicationContext, "Database Inaccessible", Toast.LENGTH_SHORT).show()
            }
        })

        mood_list.adapter = adapter



    }








    }
