package com.example.dell.navigationdrawer;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class achievement extends AppCompatActivity {


    ListView lv;
    model[] modelItems;
    ArrayAdapter adapter;
    ArrayList<String> list;
    TextView t1,t2,t3,t4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);



        try {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);



            OkHttpClient client = new OkHttpClient();

            HttpUrl.Builder urlBuilder = HttpUrl.parse("https://nsspro.000webhostapp.com/proachievements.php").newBuilder();
            //urlBuilder.addQueryParameter("PID", txtPID.getText().toString());

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


                            //txtInfo.setText(response.body().string());

                            try {
                                String data = response.body().string();

                                final JSONArray jsonArray = new JSONArray(data);
                                JSONObject jsonObject=null;





                                list = new ArrayList<String>(1);

                                lv = (ListView) findViewById(R.id.listView1);
                                for(int i=0;i< jsonArray.length();i++) {
                                    jsonObject = jsonArray.getJSONObject(i);
                                    String fname=jsonObject.getString("fname");
                                    String lname=jsonObject.getString("lname");
                                    String ename=jsonObject.getString("ename");
                                    String level=jsonObject.getString("level");
                                   // Log.d("Value",value);

                                    /*list.add(fname);
                                    list.add(lname);
                                    list.add(ename);
                                    list.add(level);*/

                                    t1=(TextView) findViewById(R.id.t1);
                                    t2=(TextView) findViewById(R.id.t2);
                                    t3=(TextView) findViewById(R.id.t3);
                                    t4=(TextView) findViewById(R.id.t4);
                                    //list.add(jsonObject.toString());
                                    t1.setText(fname);
                                    t2.setText(lname);
                                    t3.setText(ename);
                                    t4.setText(level);
                                }
                                adapter = new ArrayAdapter<String>(achievement.this, R.layout.row, list);
                                lv.setAdapter(adapter);
                                lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                    @Override
                                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {




                                        Intent intent=new Intent(achievement.this,eventclick.class);
                                        intent.putExtra("data",lv.getItemAtPosition(position).toString());
                                        startActivity(intent);
                                    }
                                });

                                    /*txtPID.setText(jsonObject.getString("ProductID"));
                                    txtPName.setText(jsonObject.getString("PName"));
                                    txtPrice.setText(jsonObject.getString("Price"));*/

                                Log.d("TESTDATA", jsonObject.toString());




                            } catch (Exception e) {
                                //  txtInfo.setText(e.getMessage());
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
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}
