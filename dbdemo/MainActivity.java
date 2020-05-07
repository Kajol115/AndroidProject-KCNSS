package com.example.dell.dbdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText txtID, txtNAME, txtCLASS;
    Button btnADD, btnDEL, btnUPD, btnread,btnselect;
    TextView txtDATA;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtID = (EditText) findViewById(R.id.txtID);
        txtNAME =(EditText) findViewById(R.id.txtNAME);
        txtCLASS = (EditText) findViewById(R.id.txtCLASS);
        txtDATA = (TextView) findViewById(R.id.txtDaTA);

        btnADD = (Button) findViewById(R.id.btnADD);
        btnread=(Button) findViewById(R.id.btnread);
        btnDEL = (Button) findViewById(R.id.btnDEL);
        btnUPD =(Button) findViewById(R.id.btnUPD);
        btnselect = (Button) findViewById(R.id.btnselect);


        final StudentsDatabaseHelper dbacess = new StudentsDatabaseHelper(this.getApplicationContext());

        btnADD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int id = Integer.parseInt(txtID.getText().toString());
                String name = txtNAME.getText().toString();
                String classname = txtCLASS.getText().toString();
                dbacess.addStudent(id,name,classname);
                Toast.makeText(MainActivity.this, "record added", Toast.LENGTH_SHORT).show();
                txtDATA.setText(dbacess.getAllStudents());

            }
        });

      /*  btnUPD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int id = Integer.parseInt(txtID.getText().toString());
                String name = txtNAME.getText().toString();
                String classname = txtCLASS.getText().toString();
                dbacess.updateStudent(id,name,classname);
                Toast.makeText(MainActivity.this, "record updated", Toast.LENGTH_SHORT).show();
                txtDATA.setText(dbacess.getAllStudents());

            }
        });
*/
        btnread.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int id=Integer.parseInt(txtID.getText().toString());
                txtDATA.setText(dbacess.getStudentById(id));
            }
        });

        btnDEL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int id = Integer.parseInt(txtID.getText().toString());

                dbacess.deleteStudent(id);
                Toast.makeText(MainActivity.this, "record deleted", Toast.LENGTH_SHORT).show();
                txtDATA.setText(dbacess.getAllStudents());

            }
        });



        btnselect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtDATA.setText(dbacess.getAllStudents());
            }
        });
    }
}
