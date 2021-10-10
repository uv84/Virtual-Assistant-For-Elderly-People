package com.example.vaep;



import androidx.annotation.NonNull;
import androidx.arch.core.internal.SafeIterableMap;
import androidx.collection.ArraySet;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.vaep.databinding.ActivityMapsBinding;
import com.example.vaep.location.GPSTracker;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.Constants;
import com.google.android.gms.location.Geofence;
import com.google.android.gms.location.GeofencingClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private static final int REQUEST_CODE_PERMISSION = 2;
    String mPermission = Manifest.permission.ACCESS_FINE_LOCATION;
    private PackageManager MockPackageManager;
    Button send12;
    private ActivityMapsBinding binding;
    private GeofencingClient geofencingClient;
    public static final float GEOFENCE_RADIUS_IN_METERS = 20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        send12 = (Button) findViewById(R.id.send);

        geofencingClient = LocationServices.getGeofencingClient(this);


        try {
            if (ActivityCompat.checkSelfPermission(this, mPermission) != MockPackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[]{mPermission}, REQUEST_CODE_PERMISSION);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

//         Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        send12.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                sendLocation1();
            }
        });
//        geofenceList.add(new Geofence.Builder()
//                // Set the request ID of the geofence. This is a string to identify this
//                // geofence.
//                .setRequestId(entry.getKey())
//
//                .setCircularRegion(
//                        entry.getValue().latitude,
//                        entry.getValue().longitude,
//                        Constants.GEOFENCE_RADIUS_IN_METERS
//                )
//                .setExpirationDuration(Constants.GEOFENCE_EXPIRATION_IN_MILLISECONDS)
//                .setTransitionTypes(Geofence.GEOFENCE_TRANSITION_ENTER |
//                        Geofence.GEOFENCE_TRANSITION_EXIT)
//                .build());


    }

    private void sendLocation1() {
        try {
            if (ActivityCompat.checkSelfPermission(this, mPermission) != MockPackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[]{mPermission}, REQUEST_CODE_PERMISSION);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        GPSTracker gps = new GPSTracker(MapsActivity.this);
        if (gps.canGetLocation()) {

            double lat = gps.getLatitude();
            double lon = gps.getLongitude();
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS)
                    != PackageManager.PERMISSION_GRANTED) {
                // Permission is not granted
                // Ask for permision
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.SEND_SMS}, 1);
            } else {
                String message = "Urval just sent you his location "+"http://maps.google.com?q=" + lat + "," + lon;
                String number = "8850013138";
                SmsManager smsManager = SmsManager.getDefault();
                StringBuffer smsBody = new StringBuffer();
                smsBody.append(Uri.parse(message));
                android.telephony.SmsManager.getDefault().sendTextMessage(number, null, smsBody.toString(), null, null);
                Toast.makeText(this, "Your Location has been sent to "+ number,
                        Toast.LENGTH_LONG).show();
            }
        } else {

            gps.showSettingsAlert();
        }
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
        mMap.setMyLocationEnabled(true);
        final GPSTracker gps = new GPSTracker(MapsActivity.this);

        if (gps.canGetLocation()) {
            LatLng latlng = new LatLng(gps.getLatitude(), gps.getLongitude());
//            Toast.makeText(getApplicationContext(), "Your Location is - \nLat: "
//                    + gps.getLatitude() + "\nLong: " + gps.getLongitude(), Toast.LENGTH_LONG).show();
            mMap.addMarker(new MarkerOptions().position(latlng).title("You are here!"));
            float zoomLevel = (float) 7;
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latlng,zoomLevel));
        } else {
            gps.showSettingsAlert();
        }
    }






}