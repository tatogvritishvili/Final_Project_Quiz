package com.example.final_project.fragments

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.final_project.Forgot
import com.example.final_project.R
import com.example.final_project.Registration

class HomeFragment:Fragment(R.layout.fragment_home) {
    lateinit var easy : TextView
    lateinit var normal : TextView
    lateinit var hard : TextView
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        easy = view.findViewById(R.id.easy)
        normal = view.findViewById(R.id.normal)
        hard = view.findViewById(R.id.hard)

        easy.setOnClickListener {
            val intent = Intent(activity, com.example.final_project.easy::class.java)
            startActivity(intent)
        }
        normal.setOnClickListener {
            val intent = Intent(activity, com.example.final_project.normal::class.java)
            startActivity(intent)
        }
        hard.setOnClickListener {
            val intent = Intent(activity, com.example.final_project.hard::class.java)
            startActivity(intent)
        }
    }
}