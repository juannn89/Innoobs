package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class NewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new)

        val nombreN : TextView = findViewById(R.id.tvNombre)
        val descripcionN : TextView = findViewById(R.id.tvDescripcion)
        val sitioN : ImageView = findViewById(R.id.ivPoi)

        val bundle : Bundle? = intent.extras
        val nombre = bundle!!.getString("nombre")
        val descripcion = bundle.getString("descripcion")
        val sitioId = bundle.getInt("sitioId")

        nombreN.text = nombre
        descripcionN.text = descripcion
        sitioN.setImageResource(sitioId)
    }
}