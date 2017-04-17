package com.example.student.studenttool;


import android.app.IntentService;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.os.ResultReceiver;
import android.text.TextUtils;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static com.google.android.gms.wearable.DataMap.TAG;

/**
 * Created by sarapaiva on 02/03/17.
 */

public class FetchCoordinatesIntentService extends IntentService {
    protected ResultReceiver mReceiver;

    public FetchCoordinatesIntentService() {
        super("FetchCoordinatesIntentService");
    }

    private void deliverResultToReceiver(int resultCode, ArrayList resultado) {
        Bundle bundle = new Bundle();
        if (resultado.size()> 0) {
            bundle.putDouble(Constants.LATITUDE, Double.valueOf(resultado.get(0).toString()));
            bundle.putDouble(Constants.LONGITUDE, Double.valueOf(resultado.get(1).toString()));
        }
        mReceiver.send(resultCode, bundle);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Geocoder geocoder = new Geocoder(this, Locale.getDefault());
        String errorMessage = "";

        // Get the location passed to this service through an extra.
        String myLocation = intent.getStringExtra(
                Constants.LOCATION_DATA_EXTRA);

        mReceiver = intent.getParcelableExtra(Constants.RECEIVER);

        List<Address> addresses = null;

        try {
            addresses = geocoder.getFromLocationName(myLocation, 5);


        } catch (IOException ioException) {
            errorMessage = getString(R.string.service_not_available);
            Log.e(TAG, errorMessage, ioException);
        } catch (IllegalArgumentException illegalArgumentException) {
            // send message invalid parameters
            // TO DO
        }
        // Handle case where no coordinates are found.
        if (addresses == null || addresses.size()  == 0) {
            if (errorMessage.isEmpty()) {
                // send message no addresses found
                Log.e(TAG, errorMessage);
            }
            deliverResultToReceiver(Constants.FAILURE_RESULT, new ArrayList());
        } else {
            Address address = addresses.get(0);
            double longitude = address.getLongitude();
            double latitude = address.getLatitude();

            Log.i(TAG, getString(R.string.address_found));
            ArrayList resultado = new ArrayList();
            resultado.add(latitude);
            resultado.add(longitude);
            deliverResultToReceiver(Constants.SUCCESS_RESULT,
                    resultado);
        }
    }
}

