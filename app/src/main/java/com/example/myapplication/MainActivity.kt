package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.databinding.ActivityMainBinding
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

data class Poi(val nombre:String, val descripcion:String, val sitio:String, var sitioId:Int, val puntaje:Int)

class MainActivity : AppCompatActivity() {

    var pois:List<Poi> = listOf()
    private lateinit var bindindg: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindindg = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindindg.root)

        val listaString = applicationContext.assets.readFile("db.json")
        var listaType = object: TypeToken<List<Poi>>(){}.type
        var gson = Gson()
        pois = gson.fromJson(listaString, listaType)
        pois.forEach({it.sitioId=applicationContext.resIdByName(it.sitio, "drawable")})
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.setting_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.action_settings -> {
                val intent = Intent(this, SettingsActivity::class.java)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onStart() {
        super.onStart()
        val rv = bindindg.rvCartagena
        val adapter = PoiAdapter(pois)
        rv.adapter = adapter
        rv.layoutManager = LinearLayoutManager(this)
        rv.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        adapter.setOnClickListener(object : PoiAdapter.onClickListener{
            override fun onClick(position: Int) {
                //Toast.makeText(this@MainActivity, "test. $position", Toast.LENGTH_SHORT).show()
                val intent = Intent(this@MainActivity, NewActivity::class.java)
                intent.putExtra("nombre", pois[position].nombre)
                intent.putExtra("descripcion", pois[position].descripcion)
                intent.putExtra("sitioId", pois[position].sitioId)
                startActivity(intent)
            }

        })
    }

}