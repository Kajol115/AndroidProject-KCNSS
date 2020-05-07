package com.example.dell.menusandnavigationdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class menunavigation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menun);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //return super.onCreateOptionsMenu(menu);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu,menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
       // return super.onOptionsItemSelected(item);

        switch(item.getItemId())
        {
            case R.id.item1:
                Toast.makeText(this, "WELCOME TO FYCS", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item2:
                Toast.makeText(this, "WELCOME TO SYCS", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item3:
                startActivity(new Intent(menunavigation.this,MainActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
