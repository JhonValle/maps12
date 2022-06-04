package com.example.maps12;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.maps12.R;
import com.example.maps12.databinding.ActivityMapsBinding;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;


public class MapsActivity extends FragmentActivity implements OnMapReadyCallback,GoogleMap.OnMarkerClickListener {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;
    private Marker markerPrueba;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng arequipa = new LatLng(-16.3988667, -71.5369607);
        mMap.addMarker(new MarkerOptions().position(arequipa).title("Ciudad de Arequipa").snippet("La ciudad blanca"));



        LatLng lima = new LatLng(-12.0621065,-77.0365256);
        mMap.addMarker(new MarkerOptions().position(lima).title("Ciudad de Lima").snippet
                ("Descripcion de Lima").icon(BitmapDescriptorFactory.fromResource(R.drawable.mapa1)));

        LatLng tacna = new LatLng(-18.0138521,-70.2511614);
        mMap.addMarker(new MarkerOptions().position(tacna).title("Ciudad de Tacna").snippet
                ("Descripcion de tacna").icon(BitmapDescriptorFactory.fromResource(R.drawable.mapa2)));

        LatLng tumbes = new LatLng(-3.833333,-80.5);
        mMap.addMarker(new MarkerOptions().position(tumbes).title("Ciudad de Tumbes").snippet
                ("Descripcion de Tumbes").icon(BitmapDescriptorFactory.fromResource(R.drawable.mapa3)));

        LatLng lambayeque = new LatLng(-6.333333,-80);
        mMap.addMarker(new MarkerOptions().position(lambayeque).title("Ciudad de Lambayeque").snippet
                ("Descripcion de Lambayeque").icon(BitmapDescriptorFactory.fromResource(R.drawable.mapa4)));

        LatLng ayacucho = new LatLng(-14,-74);
        mMap.addMarker(new MarkerOptions().position(ayacucho).draggable(true).title("Ciudad de Ayacucho").snippet
                ("Descripcion de Ayacucho").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));

        LatLng cusco = new LatLng(-13.5170887,-71.9785356);
        mMap.addMarker(new MarkerOptions().position(cusco).draggable(true).title("Ciudad de Cusco").snippet
                ("Descripcion de Cusco").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET)));

        LatLng puerto = new LatLng(-12.5938633,-69.1866773);
        mMap.addMarker(new MarkerOptions().position(puerto).draggable(true).title("Ciudad de Puerto Maldonado").snippet
                ("Descripcion de Puerto Maldonado").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));


        LatLng Trujillo = new LatLng(-8.1116778, -79.0287742);
        mMap.addMarker(new MarkerOptions().position(Trujillo).title("Ciudad de Trujillo").snippet("La ciudad de Trujillo"));



        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(arequipa,7));

        googleMap.setOnMarkerClickListener(this);

    }

    @Override
    public boolean onMarkerClick(Marker marker) {

        if(marker.equals(markerPrueba)){
            String lat,lng;
            lat = Double.toString(marker.getPosition().latitude);
            lng = Double.toString(marker.getPosition().longitude);
            Toast.makeText(this,lat+ ""+ lng, Toast.LENGTH_SHORT).show();
        }
        return false;
    }
}