package com.example.dell.navigationdrawer;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessaging;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);

        String token= FirebaseInstanceId.getInstance().getToken().toString();
        FirebaseMessaging.getInstance().unsubscribeFromTopic("blooddonation");
        FirebaseMessaging.getInstance().subscribeToTopic("blooddonation");
        Log.d("token",token);

        Intent i=getIntent();
        username=i.getStringExtra("uname");


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        else if (id == R.id.profile){
            Intent prointent=new Intent(MainActivity.this,profile.class);
            prointent.putExtra("uname",username);
            startActivity(prointent);

        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_abtus) {
            // Handle the camera action
        } else if (id == R.id.nav_events) {
            Intent eventintent=new Intent(MainActivity.this,event.class);
            eventintent.putExtra("uname",username.toString());
            startActivity(eventintent);

        } else if (id == R.id.nav_achieve) {
            Intent eventintent=new Intent(MainActivity.this,achievement.class);
            startActivity(eventintent);

        } else if (id == R.id.nav_mydiary) {

            Intent md=new Intent(MainActivity.this,mydiary.class);
            md.putExtra("uname",username);
            startActivity(md);

        } else if (id == R.id.nav_fb) {

            Intent fbi=new Intent(MainActivity.this,feedback.class);
            fbi.putExtra("uname",username);
            startActivity(fbi);


        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
