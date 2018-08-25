package com.example.alejandrocastanor.appkotlinsegundo

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.alejandrocastanor.appkotlinsegundo.Database.DBHelper
import com.example.alejandrocastanor.appkotlinsegundo.Model.Note
import kotlinx.android.synthetic.main.activity_new__note.*

class New_Note : AppCompatActivity() {

    private var database : DBHelper ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new__note)

        guardar.setOnClickListener{
            val title = titulo.text.toString()
            val body = texto.text.toString()

            var note = Note(title, body)

            database = DBHelper(this)
            database!!.insertNote(note)

            val openMainActivity = Intent(this, MainActivity::class.java)
            startActivity(openMainActivity)
        }

        salir.setOnClickListener {
            val openMainActivity = Intent(this, MainActivity::class.java)
            startActivity(openMainActivity)
        }
    }
}
