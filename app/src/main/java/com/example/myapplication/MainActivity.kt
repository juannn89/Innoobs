package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.CardLayoutBinding

data class Poi(val nombre:String, val descripcion:String, val sitio:Int, val puntaje:Int)

class MainActivity : AppCompatActivity() {

    val pois = listOf(
        Poi(nombre="Torre del Reloj", descripcion= "Está ubicado entre las plazas de Independencia y de los Coches. El nombre 'Puerta del Reloj' responde al reloj con el que fue coronada la torre a principios del siglo XVIII.", sitio= R.drawable.torre_reloj, puntaje= 3),
        Poi(nombre="Castillo de San Felipe", descripcion= "Su nombre real es Fuerte de San Felipe de Barajas. Está situado sobre un cerro llamado San Lázaro y fue construido en 1657 durante la época colonial española.", sitio= R.drawable.san_felipe, puntaje= 3),
        Poi(nombre="Islas del Rosario", descripcion= "Es un pequeño archipiélago formado por unas 28 islas, que es parte de la zona insular de Cartagena de indias, con una superficie terrestre de 20 hectáreas ubicado frente a las costas del Departamento de Bolívar, a la misma latitud que la península de Barú.", sitio= R.drawable.isla_rosario, puntaje= 3),
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