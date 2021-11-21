package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.CardLayoutBinding

data class Poi(val nombre:String, val descripcion:String, val sitio:Int)

class MainActivity : AppCompatActivity() {

    val pois = listOf(
        Poi(nombre="Torre del Reloj", descripcion= "Lugar de Cartagena", sitio= R.drawable.torre_reloj),
        Poi(nombre="Torre del Reloj", descripcion= "Lugar de Cartagena", sitio= R.drawable.torre_reloj),
        Poi(nombre="Torre del Reloj", descripcion= "Lugar de Cartagena", sitio= R.drawable.torre_reloj),
        Poi(nombre="Torre del Reloj", descripcion= "Lugar de Cartagena", sitio= R.drawable.torre_reloj),
        )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        val rv = findViewById<RecyclerView>(R.id.rvCartagena)
        rv.adapter = PoiAdapter(pois)
        rv.layoutManager = LinearLayoutManager(this)
    }
}