package com.example.dell.activitydemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("onCreate","in onCreate method");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("onStart","in onStart method");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("onStop","in onStop method");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("onDestroy","in onDestroy method");
    }


    @Override
    protected void onPause() {
        super.onPause();
        Log.d("onPause","in onPause method");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("onResume","in onResume method");
    }


}
