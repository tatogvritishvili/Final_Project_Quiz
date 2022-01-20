package com.example.final_project.fragments

import android.app.Application
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.final_project.R
import com.example.final_project.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class SettingsFragment : Fragment(R.layout.fragment_settings) {
    private lateinit var saxeli : EditText
    private lateinit var gvari : EditText
    private lateinit var asaki : EditText
    private lateinit var qveyana : EditText
    private lateinit var shenaxva : Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        saxeli = view.findViewById(R.id.saxeli)
        gvari = view.findViewById(R.id.gvari)
        asaki = view.findViewById(R.id.asaki)
        qveyana = view.findViewById(R.id.qveyana)
        shenaxva = view.findViewById(R.id.shenaxva)

        shenaxva.setOnClickListener {
            saveData()
        }
    }
    private fun saveData(){
        val name = saxeli.text.toString().trim()
        val female = gvari.text.toString().trim()
        val age = asaki.text.toString().trim()
        val country = qveyana.text.toString().trim()

        if (name.isEmpty()){
            saxeli.error = "შეიყვანეთ სახელი"
            return
        }
        if (female.isEmpty()){
            gvari.error = "შეიყვანეთ გვარი"
            return
        }
        if (age.isEmpty()){
            asaki.error = "შეიყვანეთ ასაკი"
            return
        }
        if (country.isEmpty()){
            qveyana.error = "შეიყვანეთ ქვეყანა"
            return
        }

        val user = User(name,female,age,country)
        val ref = FirebaseDatabase.getInstance().getReference("User")

        val heroId = ref.push().key
        val hero = User(name,female,age,country)
        ref.child("heroId").setValue(hero).addOnCompleteListener {

        }
    }
}
