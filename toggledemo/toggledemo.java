package com.example.dell.toggledemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.ToggleButton;

public class toggledemo extends AppCompatActivity {
    ToggleButton toggleButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toggledemo);

        toggleButton = (ToggleButton) findViewById(R.id.toggleButton);

        //toggleButton.setChecked(true);
        toggleButton.toggle();

        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                {
                    //Toggle enabled.
                    Toast.makeText(toggledemo.this, "on clicked", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    //Toggle disabled.
                    Toast.makeText(toggledemo.this, "off clicked", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
