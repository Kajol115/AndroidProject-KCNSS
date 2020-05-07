package com.example.dell.blankactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;

public class blankactivity extends AppCompatActivity {

    Button btndata,btndata2;
    TextView textView1;
    CheckBox checkBox1,checkBox2,checkBox3;
    RadioButton rb1,rb2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blankactivity);
        btndata=(Button)findViewById(R.id.btndata);
        btndata2=(Button)findViewById(R.id.btndata2);
        textView1=(TextView)findViewById(R.id.textView1);
        checkBox1=(CheckBox)findViewById(R.id.checkBox1);
        checkBox2=(CheckBox)findViewById(R.id.checkBox2);
        checkBox3=(CheckBox)findViewById(R.id.checkBox3);
        rb1=(RadioButton)findViewById(R.id.rb1);
        rb2=(RadioButton)findViewById(R.id.rb2);

        btndata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView1.setText(" ");
                if (checkBox1.isChecked()) {
                    textView1.append(checkBox1.getText());
                }
                if (checkBox2.isChecked()) {
                    textView1.append(checkBox2.getText());
                }
                if (checkBox3.isChecked()) {
                    textView1.append(checkBox3.getText());
                }

                }

            }
        );

        btndata2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(rb1.isChecked()) {
                    textView1.setText("male");
                }
                if(rb2.isChecked()) {
                    textView1.setText(rb2.getText());
                }
                }
            }
        );
    }
}
