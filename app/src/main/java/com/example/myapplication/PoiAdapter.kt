package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class PoiAdapter(val pois:List<Poi>):RecyclerView.Adapter<PoiAdapter.ViewHolder>() {

    private lateinit var mListener: onClickListener

    interface onClickListener {

        fun onClick(position: Int)
    }

    fun setOnClickListener (listener: onClickListener){
        mListener = listener
    }

    class ViewHolder(v: View, listener: onClickListener):RecyclerView.ViewHolder(v){
        var nombre: TextView
        var descripcion: TextView
        var sitio: ImageView
        lateinit var puntaje: RatingBar

        init {
            nombre = v.findViewById(R.id.tvNombre)
            descripcion = v.findViewById(R.id.tvDescripcion)
            sitio = v.findViewById(R.id.ivPoi)

            v.setOnClickListener{
                listener.onClick(bindingAdapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.card_layout, parent, false)
        return ViewHolder(v, mListener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val p = pois[position]
        holder.nombre.text = p.nombre
        holder.descripcion.text = p.descripcion
        holder.sitio.setImageResource(p.sitioId)

    }

    override fun getItemCount(): Int {
        return pois.size
    }

}
