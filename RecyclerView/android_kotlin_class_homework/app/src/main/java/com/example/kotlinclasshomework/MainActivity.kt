package com.example.kotlinclasshomework

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinclasshomework.adapter.EventAdapter
import com.example.kotlinclasshomework.event.EventGenerator

class MainActivity: AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val eventsRecycler: RecyclerView = findViewById(R.id.eventsRecycler)
        val eventsAdapter = EventAdapter()

        eventsRecycler.layoutManager = LinearLayoutManager(this)
        eventsRecycler.adapter = eventsAdapter

        val eventGenerator = EventGenerator()
        eventsAdapter.data = eventGenerator.generateEvents(100)


    }
}