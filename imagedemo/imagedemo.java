package com.example.dell.imagedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class imagedemo extends AppCompatActivity {

    Button btn;
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imagedemo);

        img=(ImageView) findViewById(R.id.imageView3);
        btn=(Button) findViewById(R.id.btnchangeimg);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                img.setImageResource(R.drawable.heart);
            }
        });
    }
}
