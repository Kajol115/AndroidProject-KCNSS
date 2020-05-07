package com.example.dell.geolocation;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements LocationListener {

    Button btnLocation;
    TextView txtLocation;
    LocationManager locationManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLocation=(Button) findViewById(R.id.btnLocation);
        txtLocation=(TextView) findViewById(R.id.txtLocation);

        btnLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getLocation();
            }
        });
    }

    @Override
    public void onLocationChanged(Location location) {
        txtLocation.setText("CURRENT LOCATION: " + location.getLatitude() + "," + location.getLongitude());

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {


    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

        Toast.makeText(MainActivity.this, "PLEASE ENABLE GPS AND INTERNET", Toast.LENGTH_SHORT).show();
    }

    private void getLocation(){

        try {
            locationManager=(LocationManager) getSystemService(Context.LOCATION_SERVICE);
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,5000,0,this);
        } catch (SecurityException e) {
            e.printStackTrace();
        }
    }


}
