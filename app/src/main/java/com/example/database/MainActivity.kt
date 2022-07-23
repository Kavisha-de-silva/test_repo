package com.example.database

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.firebase.FirebaseExceptionMapper
import com.google.firebase.database.*
import java.lang.ref.PhantomReference

class MainActivity : AppCompatActivity() {


    lateinit var databaseReference: DatabaseReference

    lateinit var Fname : TextView
    lateinit var Lname: TextView
    lateinit var Ucontact:TextView
    lateinit var  button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        databaseReference = FirebaseDatabase.getInstance("https://nibm211f-default-rtdb.firebaseio.com/").reference
        Fname = findViewById(R.id.txt_fName)
        Lname = findViewById(R.id.txt_Lname)
        Ucontact = findViewById(R.id.txt_contact)
        button = findViewById(R.id.btn_register)



        button.setOnClickListener{

            val user = User(Fname.text.toString(),Lname.text.toString(),Ucontact.text.toString())
            databaseReference.child("user").child(Ucontact.text.toString()).setValue(user)
        }



    }
}