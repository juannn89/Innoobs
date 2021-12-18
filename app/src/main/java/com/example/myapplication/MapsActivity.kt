package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.example.myapplication.databinding.ActivityMapsBinding

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var map: GoogleMap
/*
    private lateinit var binding: ActivityMapsBinding
*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)

/*
        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)
*/



        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap
/*
        val bundle : Bundle? = intent.extras
        val latitud = bundle!!.getDouble("latitud")
        val longitud = bundle!!.getDouble("longitud")
*/


        val latitudN = 10.39972
        val longitudN = -75.51444

        // Add a marker in Sydney and move the camera
        val poiUbicacion = LatLng(latitudN, longitudN)
        val zoomLevel = 15f
        map.addMarker(MarkerOptions().position(poiUbicacion).title("Punto de interes"))
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(poiUbicacion, zoomLevel))
    }
}