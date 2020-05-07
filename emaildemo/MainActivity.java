package com.example.dell.emaildemo;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void sendEmail(View v){

        EditText txtEmailTo=(EditText) findViewById(R.id.txtEmailTo);
        EditText txtSubject=(EditText) findViewById(R.id.txtSubject);
        EditText txtMessage=(EditText) findViewById(R.id.txtMessage);


        String[] TO ={txtEmailTo.getText().toString()};
        String[] CC={""};
        String subject=txtSubject.getText().toString();
        String message=txtMessage.getText().toString();

        Intent emailintent=new Intent(Intent.ACTION_SEND);

        emailintent.setData(Uri.parse("email to:"));
        emailintent.setType("text/plain");

        emailintent.putExtra(Intent.EXTRA_EMAIL,TO);
        emailintent.putExtra(Intent.EXTRA_CC,CC);
        emailintent.putExtra(Intent.EXTRA_SUBJECT,subject);
        emailintent.putExtra(Intent.EXTRA_TEXT,message);

        try {
            startActivity(Intent.createChooser(emailintent,"send email"));
            finish();
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(this, "NO EMAIL CLIENT APP INSTALLED", Toast.LENGTH_SHORT).show();;
        }


    }
}
