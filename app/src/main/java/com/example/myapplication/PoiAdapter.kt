package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PoiAdapter(val pois:List<Poi>):RecyclerView.Adapter<PoiAdapter.ViewHolder>() {

    class ViewHolder(v: View):RecyclerView.ViewHolder(v){
        var nombre: TextView
        var descripcion: TextView
        var sitio: ImageView
        lateinit var puntaje: RatingBar

        init {
            nombre = v.findViewById(R.id.tvNombre)
            descripcion = v.findViewById(R.id.tvDescripcion)
            sitio = v.findViewById(R.id.ivPoi)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PoiAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.card_layout, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: PoiAdapter.ViewHolder, position: Int) {
        val p = pois[position]
        holder.nombre.text = p.nombre
        holder.descripcion.text = p.descripcion
        holder.sitio.setImageResource(p.sitio)
    }

    override fun getItemCount(): Int {
        return pois.size
    }

}