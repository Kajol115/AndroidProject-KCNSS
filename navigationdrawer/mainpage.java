package com.example.dell.navigationdrawer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class mainpage extends AppCompatActivity {

    Button login,register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainpage);

        login=(Button) findViewById(R.id.btnlogin);
        register=(Button) findViewById(R.id.btnregister);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLogin = new Intent(mainpage.this,login.class);
                startActivity(intentLogin);
            }


        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentabt = new Intent(mainpage.this, com.example.dell.navigationdrawer.registration.class);
                startActivity(intentabt);

            }
        });
    }
}
