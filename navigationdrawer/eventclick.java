package com.example.dell.navigationdrawer;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.messaging.FirebaseMessaging;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class eventclick extends AppCompatActivity {

    Button b1;
    TextView t1;
    //int oldItem;
    String d,username,ename;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventclick);



        b1=(Button) findViewById(R.id.button2);
        t1=(TextView) findViewById(R.id.textView2);


        Intent intent = getIntent();
        d=intent.getStringExtra("eventdesc");
        username=intent.getStringExtra("uname");
        ename=intent.getStringExtra("ename");
        t1.setText(d);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {


                    subscribe_to_topic();

                    StrictMode.ThreadPolicy policy=new StrictMode.ThreadPolicy.Builder().permitAll().build();
                    StrictMode.setThreadPolicy(policy);

                    OkHttpClient client=new OkHttpClient();

                    HttpUrl.Builder urlBuilder= HttpUrl.parse("http://192.168.43.86/minipro/proevents.php").newBuilder();
                    urlBuilder.addQueryParameter("uname",username.toString());
                   // urlBuilder.addQueryParameter("pswd",ps.getText().toString());

                    String url=urlBuilder.build().toString();

                    Request request=new Request.Builder()
                            .url(url)
                            .build();
                    client.newCall(request).enqueue(new Callback() {


                        @Override
                        public void onFailure(Call call, IOException e) {

                            Intent intentLogin = new Intent(eventclick.this,event.class);
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

                                        Toast.makeText(eventclick.this, x, Toast.LENGTH_SHORT).show();


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

    private void subscribe_to_topic() {

        ename=ename.replace(" ","");

        Toast.makeText(this, ename, Toast.LENGTH_SHORT).show();

        FirebaseMessaging.getInstance().unsubscribeFromTopic(ename);
        FirebaseMessaging.getInstance().subscribeToTopic(ename);
    }
}
