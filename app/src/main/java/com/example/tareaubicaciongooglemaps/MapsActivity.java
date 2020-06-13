package com.example.tareaubicaciongooglemaps;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
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
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        String lat_str = getIntent().getStringExtra("latitud");
        String lon_str = getIntent().getStringExtra("longitud");

        if(lat_str.equals("") && lon_str.equals("")){
            LatLng arica = new LatLng(-18.483437, -70.310248);
            mMap.addMarker(new MarkerOptions().position(arica).title("Universidad Santo Tomás"));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(arica, 18));

        }else {
            Float lat_flo = Float.parseFloat(lat_str);
            Float lon_flo = Float.parseFloat(lon_str);

            // Add a marker in Sydney and move the camera
            //LatLng arica = new LatLng(-18.483437, -70.310248);
            LatLng arica = new LatLng(lat_flo, lon_flo);
            mMap.addMarker(new MarkerOptions().position(arica).title("Ciudad de la eterna primavera"));
            //mMap.moveCamera(CameraUpdateFactory.newLatLng(arica));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(arica, 18));
        }
    }
}