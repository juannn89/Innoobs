package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ActivityMainBinding
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    var pois:List<Poi> = listOf()
    private lateinit var bindindg: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindindg = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindindg.root)

/*
        val listaString = applicationContext.assets.readFile("db.json")
        var listaType = object: TypeToken<List<Poi>>(){}.type
        var gson = Gson()
        pois = gson.fromJson(listaString, listaType)
        pois.forEach({it.sitioId=applicationContext.resIdByName(it.sitio, "drawable")})
*/

        val retrofit = Retrofit.Builder()
            .baseUrl("http://my-json-server.typicode.com/juannn89/innoobs/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api = retrofit.create(ApiService::class.java)
        api.fetchAllPois().enqueue(object : Callback<List<Poi>>{
            override fun onResponse(call: Call<List<Poi>>, response: Response<List<Poi>>) {
                onStart(response.body()!!)
                Log.d("conectado", "bien")
            }
            override fun onFailure(call: Call<List<Poi>>, t: Throwable) {
                Log.d("falla", "onFailure")
            }

        })

    }
/*
    private fun showData(pois:List<Poi>){
        val rv = bindindg.rvCartagena
        rv.apply{
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = PoiAdapter(pois)
        }
    }
*/

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

    private fun onStart(pois:List<Poi>) {
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
                intent.putExtra("restaurantes", pois[position].restaurantes)
                intent.putExtra("hoteles", pois[position].hoteles)
                startActivity(intent)
            }

        })
        pois.forEach({it.sitioId=applicationContext.resIdByName(it.sitio, "drawable")})
    }

}