package com.example.student.studenttool;

import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Mapa extends AppCompatActivity implements OnMapReadyCallback, GoogleMap.OnMapClickListener,
GoogleMap.OnMapLongClickListener, LocationListener, GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener {

    GoogleMap mMap;
    private GoogleApiClient mGoogleApiClient;
    LocationRequest mLocationRequest;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_mapa);

    // a partir da API 12
    MapFragment mapFragment = (MapFragment) getFragmentManager()
            .findFragmentById(R.id.map);
mapFragment.getMapAsync(this); // prepara o mapa e retorna para o método onMapReady

        mLocationRequest = new LocationRequest();

    }

    @Override
    public void onMapReady(GoogleMap map) {

        mMap = map;

        LatLng pontodestino = new LatLng(41.1, -8.2);
        map.addMarker(new MarkerOptions()
                .position(pontodestino)
                .title("ESTG"));
        map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);

        map.setOnMapClickListener(this);
        map.setOnMapLongClickListener(this);

        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(pontodestino)
                .zoom(18)
                .bearing(45)
                .tilt(60)
                .build();
        map.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));


        /*map.addMarker(new MarkerOptions()
                .position(new LatLng(41.1, -8.2))
                .title("Marker"));*/


    }

    @Override
    public void onMapClick(LatLng latLng) {

    }

    @Override
    public void onMapLongClick(LatLng latLng) {
        Intent i = new Intent (this, MapaRua.class);
        i.putExtra(Utils.LAT, latLng.latitude);
        i.putExtra(Utils.LONG, latLng.longitude);
        startActivity(i);
    }





    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {

    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

}

