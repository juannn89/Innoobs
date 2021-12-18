package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager

class NewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new)



        val btnMaps = findViewById<Button>(R.id.btnMaps)
        btnMaps.setOnClickListener{
            val intent = Intent(this@NewActivity, MapsActivity::class.java)
/*
            intent.putExtra("latitud", pois[position].latitud)
            intent.putExtra("longitud", pois[position].longitud)
*/
            startActivity(intent)

        }


        val nombreN : TextView = findViewById(R.id.tvNombre)
        val descripcionN : TextView = findViewById(R.id.tvDescripcion)
        val sitioN : ImageView = findViewById(R.id.ivPoi)
        val restaurantesN : TextView  = findViewById(R.id.contenidoRestaurantes)
        val hotelesN : TextView = findViewById(R.id.contenidoHoteles)

        val bundle : Bundle? = intent.extras
        val nombre = bundle!!.getString("nombre")
        val descripcion = bundle.getString("descripcion")
        val sitioId = bundle.getInt("sitioId")
        val restaurantes = bundle.getString("restaurantes")
        val hoteles = bundle.getString("hoteles")

        nombreN.text = nombre
        descripcionN.text = descripcion
        sitioN.setImageResource(sitioId)
        restaurantesN.text = restaurantes
        hotelesN.text = hoteles

    }
/*
    private fun onStart(pois:List<Poi>) {
        super.onStart()

        val adapter = PoiAdapter(pois)
        adapter.setOnClickListener(object : PoiAdapter.onClickListener {
            override fun onClick(position: Int) {
                //Toast.makeText(this@MainActivity, "test. $position", Toast.LENGTH_SHORT).show()
                val intent = Intent(this@NewActivity, MapsActivity::class.java)
                intent.putExtra("latitud", pois[position].latitud)
                intent.putExtra("longitud", pois[position].longitud)
                startActivity(intent)
            }

        })
    }
*/
}