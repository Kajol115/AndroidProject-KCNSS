package com.example.dell.navigationdrawer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class profile extends AppCompatActivity {

    String username;
    Button b1,b2;
    TextView t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Intent i=getIntent();
        username=i.getStringExtra("uname");
        t1=(TextView) findViewById(R.id.textView5);
        t1.setText(username);

        b1=(Button) findViewById(R.id.button);
        b2=(Button) findViewById(R.id.button3);

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i=new Intent(profile.this,imageupload.class);
                i.putExtra("uname",username);
                startActivity(i);

            }
        });
    }
}
