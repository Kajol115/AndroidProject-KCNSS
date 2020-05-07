package com.example.dell.registerdemo;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class register extends AppCompatActivity {

    EditText fn,ln,age,add,email,contact,bg,uname,pswd;
    RadioGroup rg1,rg2,rg3,rg4,rg5,rg6;
    RadioButton rm,rf,bdy,bdn,pdy,pdn,bay,ban,acy,acn,vidy,vidn;
    Button register;
    String gender,bd,pd,ba,ac,vid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        fn = (EditText) findViewById(R.id.txtFName);
        ln = (EditText) findViewById(R.id.editTextln);
        age = (EditText) findViewById(R.id.editTextage);
        add = (EditText) findViewById(R.id.editText6);
        email = (EditText) findViewById(R.id.editText4);
        contact = (EditText) findViewById(R.id.editText5);
        bg = (EditText) findViewById(R.id.editTextbg);


        rg1 = (RadioGroup) findViewById(R.id.rg1);
        //int selectedId = rg1.getCheckedRadioButtonId();
        //gen = (RadioButton) findViewById(selectedId);
        rm=(RadioButton) findViewById(R.id.rb1);
        rf=(RadioButton) findViewById(R.id.rb2);
        bdy=(RadioButton) findViewById(R.id.radioButton3);
        bdn=(RadioButton) findViewById(R.id.radioButton4);
        pdy=(RadioButton) findViewById(R.id.radioButton5);
        pdn=(RadioButton) findViewById(R.id.radioButton6);
        bay=(RadioButton) findViewById(R.id.radioButton9);
        ban=(RadioButton) findViewById(R.id.radioButton10);
        acy=(RadioButton) findViewById(R.id.radioButton11);
        acn=(RadioButton) findViewById(R.id.radioButton12);
        vidy=(RadioButton) findViewById(R.id.radioButton13);
        vidn=(RadioButton) findViewById(R.id.radioButton14);
        if(rm.isChecked())
        {
            gender="male";
        }
        if(rf.isChecked())
        {
            gender="female";
        }


        rg2 = (RadioGroup) findViewById(R.id.rg2);
        rg3 = (RadioGroup) findViewById(R.id.rg3);
        rg4 = (RadioGroup) findViewById(R.id.rg4);
        rg5 = (RadioGroup) findViewById(R.id.rg5);
        rg6 = (RadioGroup) findViewById(R.id.rg6);
       /* int selectedId1 = rg2.getCheckedRadioButtonId();
        bd = (RadioButton) findViewById(selectedId1);
        int selectedId2 = rg3.getCheckedRadioButtonId();
        pd = (RadioButton) findViewById(selectedId2);
        int selectedId3 = rg4.getCheckedRadioButtonId();
        ba = (RadioButton) findViewById(selectedId3);
        int selectedId4 = rg5.getCheckedRadioButtonId();
        ac = (RadioButton) findViewById(selectedId4);
        int selectedId5 = rg6.getCheckedRadioButtonId();
        vid = (RadioButton) findViewById(selectedId5);*/

        uname = (EditText) findViewById(R.id.txtuname);
        pswd = (EditText) findViewById(R.id.txtpw);
        register = (Button) findViewById(R.id.button);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                StrictMode.setThreadPolicy(policy);

                OkHttpClient client = new OkHttpClient();

                if(rm.isChecked())
                {
                    gender="male";
                }
                if(rf.isChecked())
                {
                    gender="female";
                }
                if(bdy.isChecked())
                {
                    bd="yes";
                }
                if(bdn.isChecked())
                {
                    bd="no";
                }
                if(pdy.isChecked())
                {
                    pd="yes";
                }
                if(pdn.isChecked())
                {
                    pd="no";
                }
                if(bay.isChecked())
                {
                    ba="yes";
                }
                if(ban.isChecked())
                {
                    ba="no";
                }
                if(acy.isChecked())
                {
                    ac="yes";
                }
                if(acn.isChecked())
                {
                    ac="no";
                }
                if(vidy.isChecked())
                {
                    vid="yes";
                }
                if(vidn.isChecked())
                {
                    vid="no";
                }



                HttpUrl.Builder urlBuilder = HttpUrl.parse("https://nsspro.000webhostapp.com/proregister.php").newBuilder();
                urlBuilder.addQueryParameter("fname", fn.getText().toString());
                urlBuilder.addQueryParameter("lname", ln.getText().toString());
                urlBuilder.addQueryParameter("age", age.getText().toString());
                urlBuilder.addQueryParameter("gender", gender.toString());
                urlBuilder.addQueryParameter("add", add.getText().toString());
                urlBuilder.addQueryParameter("email", email.getText().toString());
                urlBuilder.addQueryParameter("contact", contact.getText().toString());
                urlBuilder.addQueryParameter("bg", bg.toString());
                urlBuilder.addQueryParameter("bd", bd.toString());
                urlBuilder.addQueryParameter("pd", pd.toString());
                urlBuilder.addQueryParameter("ba", ba.toString());
                urlBuilder.addQueryParameter("ac", ac.toString());
                urlBuilder.addQueryParameter("vid", vid.toString());
                urlBuilder.addQueryParameter("uname", uname.getText().toString());
                urlBuilder.addQueryParameter("pswd", pswd.getText().toString());

                String url = urlBuilder.build().toString();

                Request request = new Request.Builder()
                        .url(url)
                        .build();

                client.newCall(request).enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {

                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        Intent intentLogin = new Intent(register.this, page1.class);
                        startActivity(intentLogin);
                    }
                });

            }
        });

    }

}
