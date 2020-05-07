package com.example.dell.navigationdrawer;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class login extends AppCompatActivity {

    EditText un,ps;
    TextView h1,h2;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        un=(EditText) findViewById(R.id.uname);
        ps=(EditText) findViewById(R.id.pswd);
        login=(Button) findViewById(R.id.btnlogin);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                    StrictMode.ThreadPolicy policy=new StrictMode.ThreadPolicy.Builder().permitAll().build();
                    StrictMode.setThreadPolicy(policy);

                    OkHttpClient client=new OkHttpClient();

                    HttpUrl.Builder urlBuilder= HttpUrl.parse("https://nsspro.000webhostapp.com/prologin.php").newBuilder();
                    urlBuilder.addQueryParameter("uname",un.getText().toString());
                    urlBuilder.addQueryParameter("pswd",ps.getText().toString());

                    String url=urlBuilder.build().toString();

                    Log.d("url",url);

                    Request request=new Request.Builder()
                            .url(url)
                            .build();
                    client.newCall(request).enqueue(new Callback() {


                        @Override
                        public void onFailure(Call call, IOException e) {
                            Log.e("Error",e.getMessage()+"\n"+e.getLocalizedMessage()+"\n"+e.toString());
                            Intent intentLogin = new Intent(login.this,MainActivity.class);
                            intentLogin.putExtra("uname",un.getText());
                            startActivity(intentLogin);

                        }

                        @Override
                        public void onResponse(Call call, final Response response) throws IOException {

                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    try{
                                        //Toast.makeText(login.this, response.body().string(), Toast.LENGTH_LONG).show();

                                        String x = response.body().string();
                                        Log.d("ID",x);

                                        Toast.makeText(login.this, x, Toast.LENGTH_SHORT).show();

                                       // if(x.equals("success"))
                                        //{
                                            Toast.makeText(login.this, "LOGIN SUCCESSFUL", Toast.LENGTH_SHORT).show();
                                            Intent intentLogin = new Intent(login.this, MainActivity.class);
                                            intentLogin.putExtra("uname",un.getText().toString());
                                            intentLogin.putExtra("id",x);
                                            startActivity(intentLogin);
                                        //}
                                        if(x.equals("fail"))
                                        {
                                            //Toast.makeText(login.this, "in2", Toast.LENGTH_SHORT).show();
                                            Toast.makeText(login.this, "Invalid username or password...Try again", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                    catch(Exception e){
                                        e.printStackTrace();
                                    }
                                }
                            });
                        }
                    });
                }
                catch(Exception e){
                    e.printStackTrace();
                }



            }
        });

    }
}
