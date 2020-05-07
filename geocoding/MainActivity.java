package com.example.dell.geocoding;

import android.location.Address;
import android.location.Geocoder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView txtdata;
    Button btngeocoder;
    Button btnRgeocoder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtdata=(TextView) findViewById(R.id.txtdata);
        btngeocoder=(Button) findViewById(R.id.btngeocoder);
        btnRgeocoder=(Button) findViewById(R.id.btnRgeocoder);

        btngeocoder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Geocoder gc =new Geocoder(MainActivity.this);

                    if (gc.isPresent())
                    {
                            List<Address> list=gc.getFromLocationName("K.C.COLLEGE,CHURCHGATE,MUMBAI,MAHARASHTRA",1);
                            Address address=list.get(0);
                            double lat=address.getLatitude();
                            double lng=address.getLongitude();
                            txtdata.setText("LATITUDE IS " + lat + "LONGITUDE IS " + lng);

                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        btnRgeocoder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    Geocoder gc =new Geocoder(MainActivity.this);
                    if ((gc.isPresent()))
                    {
                        List<Address> list= gc.getFromLocation(18.9322,72.8264,1);
                        Address address=list.get(0);
                        txtdata.setText("THE LOCATION DETAILS ARE : \n");
                        txtdata.append("\n NAME: "+ address.getLocality());
                        txtdata.append("\nADMIN AREA: " + address.getAdminArea());
                        txtdata.append("\nCOUNTRY: " + address.getCountryName());
                        txtdata.append("\nCOUNTRYCODE: " + address.getCountryCode());
                        txtdata.append("\nPOSTALCODE : "+ address.getPostalCode());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
