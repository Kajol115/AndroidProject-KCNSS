package com.example.dell.sqllistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView listView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView1=(ListView) findViewById(R.id.listview1);

        //string array of values
        String [] data=new String[]{
                "c","c++","java","c#","javascript","html","css","php","node.js"
        };

        ArrayAdapter <String> adapter=new ArrayAdapter<String>(this.getApplicationContext(),android.R.layout.simple_list_item_1,data);
        listView1.setAdapter(adapter);

        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String currentdata = listView1.getItemAtPosition(position).toString();
                Toast.makeText(MainActivity.this, currentdata, Toast.LENGTH_SHORT).show();
            }
        });
    }




}
