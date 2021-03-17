package com.example.firbasetest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.firbasetest.databinding.ActivityMainBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var studentDbref: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        studentDbref = Firebase.database.getReference("Students")

        binding.btnInsert.setOnClickListener {
            insertStudentData()
        }
    }

    private fun insertStudentData(){
        var name = binding.etName.text.toString()
        var rollno = binding.etRollNumber.text.toString()

        val students = Students(name,rollno)
        studentDbref.push().setValue(students)
        Toast.makeText(this,"Data Inserted",Toast.LENGTH_SHORT).show()
    }
}