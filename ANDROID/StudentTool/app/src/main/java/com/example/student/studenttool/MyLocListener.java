package com.example.student.studenttool;

import android.content.Context;
import android.content.SharedPreferences;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by david on 17/04/17.
 */

public class MyLocListener extends AppCompatActivity implements LocationListener {

    @Override
    public void onLocationChanged(Location location){
        if(location != null){
            SharedPreferences sharedPref = getSharedPreferences(getString(R.string.shared_pref_1), Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putString(Utils.LATITUDE, String.valueOf(location.getLatitude()));
            editor.putString(Utils.LONGITUDE, String.valueOf(location.getLongitude()));
            editor.commit();
        }
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


}
