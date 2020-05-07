package com.example.dell.msc;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends Activity {

    Button save,read;
    EditText txt;
    TextView res;

    private String filename = "Sample";
    private String filpath ="/sdcard/MyFileStorage";

    File myExternalFile;
    String myData="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt=(EditText) findViewById(R.id.input);
        res=(TextView) findViewById(R.id.res);
        save=(Button) findViewById(R.id.save);
        read =(Button) findViewById(R.id.read);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{

                    FileOutputStream fos=new FileOutputStream(myExternalFile);
                    fos.write(txt.getText().toString().getBytes());



                }catch (IOException e)
                {
                    e.printStackTrace();
                }

                txt.setText("");
                res.setText("Saved to external storage");


            }
        });

        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{

                    FileInputStream fis = new FileInputStream(myExternalFile);
                    DataInputStream in = new DataInputStream(fis);
                    BufferedReader br = new BufferedReader(new InputStreamReader(in));

                    String line="";
                    while ((line=br.readLine())!=null){
                        myData=myData+line;

                    }

                    in.close();

                }catch (IOException e)
                {
                    e.printStackTrace();
                }

                txt.setText(myData);
                res.setText("Retrieved data");
            }
        });

    if(!isExternalStroageAvailable() || isExternalStorageReadOnly()){

        save.setEnabled(false);

    }
    else{
        myExternalFile=new File(getExternalFilesDir(filpath),filename);
    }
}

    private static boolean isExternalStroageAvailable() {
        String extStorage= Environment.getExternalStorageState();

        if(Environment.MEDIA_MOUNTED.equals(extStorage))
        {
            return true;
        }
        return false;
    }

    private static boolean isExternalStorageReadOnly()

    {
        String extStorage = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED_READ_ONLY.equals(extStorage)) {
            return true;
        }
        return false;
    }
    }
