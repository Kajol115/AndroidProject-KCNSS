package com.example.dell.navigationdrawer;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class feedback extends AppCompatActivity {

    EditText t1,t2;
    Button b1;
    String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        t1=(EditText) findViewById(R.id.editText);
        t2=(EditText) findViewById(R.id.editText2);
        b1=(Button) findViewById(R.id.button4);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i=getIntent();
                username=i.getStringExtra("uname");

                try {
                    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                    StrictMode.setThreadPolicy(policy);



                    OkHttpClient client = new OkHttpClient();

                    HttpUrl.Builder urlBuilder = HttpUrl.parse("https://nsspro.000webhostapp.com/profeedback.php").newBuilder();
                    urlBuilder.addQueryParameter("ename",t1.getText().toString());
                    urlBuilder.addQueryParameter("fb",t2.getText().toString());
                    urlBuilder.addQueryParameter("uname",username);

                    String url = urlBuilder.build().toString();
                    Log.d("TESTDATA", url);
                    Request request = new Request.Builder()
                            .url(url)
                            .build();

                    client.newCall(request).enqueue(new Callback() {
                        @Override
                        public void onFailure(Call call, IOException e) {

                        }

                        @Override
                        public void onResponse(Call call, final Response response) throws IOException {

                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {


                                    try {
                                        String desc= response.body().string();
                                        //desc = response.body().string();
                                        Toast.makeText(feedback.this, desc, Toast.LENGTH_SHORT).show();
                                        Intent i=getIntent();
                                        String username=i.getStringExtra("uname");
                                        Intent intent=new Intent(feedback.this,MainActivity.class);
                                       // intent.putExtra("eventdesc",desc.toString());
                                        intent.putExtra("uname",username.toString());
                                        //intent.putExtra("ename",lv.getItemAtPosition(position).toString());
                                        startActivity(intent);



                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }




                                }
                            });
                        }

                        ;
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });






    }



}


