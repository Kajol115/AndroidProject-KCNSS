package com.example.dell.act1;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class act1 extends AppCompatActivity {

    Button btnalert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act1);

        btnalert=(Button) findViewById(R.id.btnalert);

        btnalert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder=new AlertDialog.Builder(act1.this);
                builder.setTitle("alert box");
                builder.setMessage("this is alert box");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(act1.this,"ok pressed",Toast.LENGTH_SHORT).show();
                    }


                });

                builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Toast.makeText(act1.this, "cancel pressed", Toast.LENGTH_SHORT).show();
                    }

                }


            }
        });
        AlertDialog alertDialog=builder.create();
        alertDialog.show();
    }
}
