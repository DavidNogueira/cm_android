package com.example.student.studenttool;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.os.ResultReceiver;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.Manifest;


import com.example.student.studenttool.Constants;
import com.example.student.studenttool.FetchAddressIntentService;
import com.example.student.studenttool.FetchCoordinatesIntentService;
import com.example.student.studenttool.MapaRua;
import com.example.student.studenttool.R;
import com.example.student.studenttool.Utils;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.Geofence;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.ArrayList;
import java.util.List;

public class Mapa extends AppCompatActivity implements OnMapReadyCallback, GoogleMap.OnMapClickListener,
        GoogleMap.OnMapLongClickListener, LocationListener, GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener {

    GoogleMap mMap;
    private GoogleApiClient mGoogleApiClient;
    LocationRequest mLocationRequest;
    ArrayList<LatLng> pontos;
    private AddressResultReceiver mResultReceiver;


    TextView txttempo;

    public int idMapa;

    String lati;
    String longi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_mapa);

        android.content.SharedPreferences sharedPref = getSharedPreferences(getString(R.string.shared_pref_1),Context.MODE_PRIVATE);


        String valor = sharedPref.getString(Utils.IDMAPA, "0");
        idMapa = Integer.parseInt(valor);

        pontos = new ArrayList();

        mResultReceiver = new AddressResultReceiver(new Handler());

        // a partir da API 12
        MapFragment mapFragment = (MapFragment) getFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        mLocationRequest = new LocationRequest();
        buildGoogleApiClient();


        LocationManager myManager;
        MyLocListener loc;
        loc = new MyLocListener();
        myManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        myManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, loc);


         lati = sharedPref.getString(Utils.LATITUDE, "0");
         longi = sharedPref.getString(Utils.LONGITUDE, "0");




        //createGeoFence();

        txttempo = (TextView) findViewById(R.id.txttempo);

        Location l = new Location("");
        l.setLatitude(Double.parseDouble(lati));
        l.setLatitude(Double.parseDouble(longi));
        startIntentService(l);
    }








    @Override
    public void onMapReady(GoogleMap map) {
        mMap = map;
        LatLng pontodestino;
        String titulo;

        if (idMapa == 1){
            pontodestino = new LatLng(41.694504, -8.846884);//ESTG
            titulo = "ESTG";
        }else if (idMapa == 2){
            pontodestino = new LatLng(41.693273, -8.832527);//SA
            titulo = "SA";

        }else if (idMapa == 3){
            pontodestino = new LatLng(41.692034, -8.834817);//sedeIPVC
            titulo = "IPVC";

        }else {
            pontodestino = new LatLng(0, 0);//ESTG
            titulo = "0,0";

        }


/*
        switch (idMapa){

            case 1:
                    pontodestino = new LatLng(41.694504, -8.846884);//ESTG
                return;

            case 2:
                    pontodestino = new LatLng(41.693282, -8.8132482);//SA
                return;

            case 3:
                    pontodestino = new LatLng(41.692034, -8.834817);//sedeIPVC
                return;

            default:
                pontodestino = new LatLng(41.694504, -8.846884);//ESTG
                return;


        }*/

        Double doublelati = Double.valueOf(lati);
        Double doublelongi = Double.valueOf(longi);


        LatLng pontoorigem = new LatLng(doublelati, doublelongi);

        map.addMarker(new MarkerOptions()
                .position(pontoorigem)
                .title("You are HERE"));
        map.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        map.addMarker(new MarkerOptions()
                .position(pontodestino)
                .title(titulo));
        map.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        map.setOnMapClickListener(this);
        map.setOnMapLongClickListener(this);

        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(pontodestino)
                .zoom(16)
                .bearing(45)
                .tilt(60)
                .build();
        map.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));

       // focusMapa(pontodestino);
    }

    private void focusMapa(LatLng latlng) {

        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(latlng)      // Sets the center of the map to Mountain View
                .zoom(16)                   // Sets the zoom
                .bearing(45)                // Sets the orientation of the camera to east
                .tilt(60)                   // Sets the tilt of the camera to 60 degrees
                .build();                   // Creates a CameraPosition from the builder
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
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


    protected void createLocationRequest() {
        mLocationRequest.setInterval(10000);
        mLocationRequest.setFastestInterval(10000);
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
    }

    protected synchronized void buildGoogleApiClient() {
        // CONSTRUIR O CLIENTE DA API DO GOOGLE QUE SERA INICIADO NO ONSTART()
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API).build();
        // CONSTRUIR O PEDIDO DE SINAL
        createLocationRequest();
    }

    @Override
    protected void onStart() {
        super.onStart();
        // INICIAR O SERVIÇO DE GOOGLE PLAY
        mGoogleApiClient.connect();
    }

    @Override
    public void onConnected(Bundle connectionHint) {
        // MOMENTO EM QUE O SERVIÇO DO GOOGLE PLAY É CONETADO (DEPOIS DE mGoogleApiClient.connect();)
        startLocationUpdates();
        startIntentCoordinatesService();
    }

    protected void startLocationUpdates() {
        // PEDIDO DE SINAL PROPRIAMENTE DITO
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            // Check Permissions Now
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 0);
        } else {
            LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, mLocationRequest, this);
            mMap.setMyLocationEnabled(true);
        }
    }


    @Override
    public void onLocationChanged(Location location) {
        Toast.makeText(this, "gps recebido -> lat: " + location.getLatitude() + "; long: " + location.getLongitude(), Toast.LENGTH_SHORT).show();
        LocationServices.FusedLocationApi.removeLocationUpdates(mGoogleApiClient, this);
    }

    protected void startIntentService(Location location) {
        Intent intent = new Intent(this, FetchAddressIntentService.class);
        intent.putExtra(Constants.RECEIVER, mResultReceiver);
        intent.putExtra(Constants.LOCATION_DATA_EXTRA, location);
        startService(intent);
    }

    protected void startIntentCoordinatesService() {
        Intent intent = new Intent(this, FetchCoordinatesIntentService.class);
        intent.putExtra(Constants.LOCATION_DATA_EXTRA, "Lisboa");
        intent.putExtra(Constants.RECEIVER, mResultReceiver);
        startService(intent);
    }


    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    public void onRequestPermissionsResult(int requestCode,
                                           String[] permissions,
                                           int[] grantResults) {
        if (requestCode == 0) {
            if (grantResults.length == 1
                    && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                if (requestCode == 0) {
                    startLocationUpdates();
                }

            } else {
                // Permission was denied or request was cancelled
            }
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        //parar
    }

    @Override
    protected void onResume() {
        super.onResume();
        //ativar
    }

    class AddressResultReceiver extends ResultReceiver {
        public AddressResultReceiver(Handler handler) {
            super(handler);
        }

        @Override
        protected void onReceiveResult(int resultCode, Bundle resultData) {

            if (resultData.containsKey(Constants.RESULT_DATA_KEY)) {
                String mAddressOutput = resultData.getString(Constants.RESULT_DATA_KEY);
                Toast.makeText(Mapa.this, mAddressOutput, Toast.LENGTH_SHORT).show();
                txttempo.setText(mAddressOutput);

            }
            if (resultData.containsKey(Constants.LATITUDE)) {
                LatLng l = new LatLng(
                        resultData.getDouble(Constants.LATITUDE),
                        resultData.getDouble(Constants.LONGITUDE)
                );
               // focusMapa(l);
            }
        }
    }


    public void acaba(View v) {

        Intent i = new Intent(Mapa.this, MainActivity_tabs.class);
        startActivity(i);
        finish();
    }

}