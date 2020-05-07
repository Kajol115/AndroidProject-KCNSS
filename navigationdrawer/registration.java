package com.example.dell.navigationdrawer;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class registration extends AppCompatActivity {

    EditText fn,ln,age,add,email,contact,bg,uname,pswd;
    RadioGroup rg1,rg2,rg3,rg4,rg5,rg6;
    RadioButton rm,rf,bdy,bdn,pdy,pdn,bay,ban,acy,acn,vidy,vidn;
    Button register;
    String gender,bd,pd,ba,ac,vid;
    ProgressDialog progressDialog;

    public boolean validate(){

        if(fn.getText().length()==0||ln.getText().length()==0||age.getText().length()==0||add.getText().length()==0||email.getText().length()==0||contact.getText().length()==0||bg.getText().length()==0||uname.getText().length()==0||pswd.getText().length()==0)
        {
            Toast.makeText(this, "Please enter all fields", Toast.LENGTH_SHORT).show();
            fn.requestFocus();
            ln.requestFocus();
            age.requestFocus();
            add.requestFocus();
            email.requestFocus();
            contact.requestFocus();
            bg.requestFocus();
            uname.requestFocus();
            pswd.requestFocus();

            fn.setError("PLEASE ENTER YOUR FIRST NAME");
            ln.setError("PLEASE ENTER YOUR LAST NAME");
            age.setError("PLEASE ENTER  AGE");
            add.setError("PLEASE ENTER ADDRESS");
            email.setError("PLEASE ENTER EMAIL");
            contact.setError("PLEASE ENTER CONTACT");
            bg.setError("PLEASE ENTER BLOOD GROUP");
            uname.setError("PLEASE ENTER YOUR USERNAME");
            pswd.setError("PLEASE ENTER PASSWORD");
            return false;
        }

        else
        {
            int c=0;
            if(contact.getText().length()==10)
            {
                if (!contact.getText().toString().matches("[6-9][0-9]{9}")) {

                    Toast.makeText(getApplication(), "Invalid Mobile No", Toast.LENGTH_LONG).show();
                    contact.setError("Invalid Mobile Number");
                    c++;
                    contact.requestFocus();
                    return false;
                }
            }

            else if(contact.getText().length()==13)
            {
                    if (!contact.getText().toString().matches("[+]91[6-9][0-9]{9}"))
                    {
                        Toast.makeText(getApplication(), "Invalid Mobile No", Toast.LENGTH_LONG).show();
                        contact.setError("Invalid Mobile Number");
                        c++;
                        contact.requestFocus();
                        return false;
                    }
            }
            else
            {
                contact.setError("Invalid Mobile Number");
                c++;
                contact.requestFocus();
                return false;
            }
            if(!Patterns.EMAIL_ADDRESS.matcher(email.getText().toString()).matches())
            {
                email.setError("invalid email");
                email.requestFocus();
            }

            if (c == 0)
            {
                Toast.makeText(getApplication(), "Validated", Toast.LENGTH_LONG).show();
                return true;
            }
            else
            {
                return false;
            }
        }


        }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);



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
        rm=(RadioButton) findViewById(R.id.radioButton);
        rf=(RadioButton) findViewById(R.id.radioButton2);
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
                if (validate()) {

                   /* progressDialog=new ProgressDialog(registration.this);
                    progressDialog.setTitle("Submitting");
                    progressDialog.setMessage("Processing");
                    progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                    progressDialog.show();
                    progressDialog.setCancelable(false);*/

                    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                    StrictMode.setThreadPolicy(policy);

                    OkHttpClient client = new OkHttpClient();

                    if (rm.isChecked()) {
                        gender = "male";
                    }
                    if (rf.isChecked()) {
                        gender = "female";
                    }
                    if (bdy.isChecked()) {
                        bd = "yes";
                    }
                    if (bdn.isChecked()) {
                        bd = "no";
                    }
                    if (pdy.isChecked()) {
                        pd = "yes";
                    }
                    if (pdn.isChecked()) {
                        pd = "no";
                    }
                    if (bay.isChecked()) {
                        ba = "yes";
                    }
                    if (ban.isChecked()) {
                        ba = "no";
                    }
                    if (acy.isChecked()) {
                        ac = "yes";
                    }
                    if (acn.isChecked()) {
                        ac = "no";
                    }
                    if (vidy.isChecked()) {
                        vid = "yes";
                    }
                    if (vidn.isChecked()) {
                        vid = "no";
                    }


                    HttpUrl.Builder urlBuilder = HttpUrl.parse("https://nsspro.000webhostapp.com/proregister.php").newBuilder();
                    urlBuilder.addQueryParameter("fname", fn.getText().toString());
                    urlBuilder.addQueryParameter("lname", ln.getText().toString());
                    urlBuilder.addQueryParameter("age", age.getText().toString());
                    urlBuilder.addQueryParameter("gender", gender.toString());
                    urlBuilder.addQueryParameter("add", add.getText().toString());
                    urlBuilder.addQueryParameter("email", email.getText().toString());
                    urlBuilder.addQueryParameter("contact", contact.getText().toString());
                    urlBuilder.addQueryParameter("bg", bg.getText().toString());
                    urlBuilder.addQueryParameter("bd", bd.toString());
                    urlBuilder.addQueryParameter("pd", pd.toString());
                    urlBuilder.addQueryParameter("ba", ba.toString());
                    urlBuilder.addQueryParameter("ac", ac.toString());
                    urlBuilder.addQueryParameter("vid", vid.toString());
                    urlBuilder.addQueryParameter("uname", uname.getText().toString());
                    urlBuilder.addQueryParameter("pswd", pswd.getText().toString());

                    String url = urlBuilder.build().toString();

                    Log.d("reg", url);

                    Request request = new Request.Builder()
                            .url(url)
                            .build();


                    client.newCall(request).enqueue(new Callback() {
                        @Override
                        public void onFailure(Call call, IOException e) {

                        }

                        @Override
                        public void onResponse(Call call, Response response) throws IOException {

                           // progressDialog.dismiss();
                            Toast.makeText(registration.this, "Registered Successsfully", Toast.LENGTH_SHORT).show();
                            Intent intentLogin = new Intent(registration.this, login.class);
                            intentLogin.putExtra("uname", uname.getText().toString());
                            Log.d("name", uname.getText().toString());
                            startActivity(intentLogin);
                        }
                    });

                }
            }
        });

    }
}
