package com.example.dell.dbdemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.icu.text.IDNA;

/**
 * Created by dell on 10/08/2017.
 */

public class StudentsDatabaseHelper extends SQLiteOpenHelper{

    //CREATE DATABASE DBNAME 1.1
    private static final String db_name ="StudentDatabase.db";

    //CREATE TABLE TABLENAME 1.1
    private static final String table_name = "student";

    //A UNIQUE VERSION IDENTIFIER
    private static final int db_version = 1;

    public StudentsDatabaseHelper(Context context) {
        super(context, db_name, null, db_version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String query = "CREATE TABLE students (ID INTEGER PRIMARY KEY, Name TEXT,Class TEXT);";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS student");
        onCreate(db);
    }

    public void addStudent(int id,String name,String classname){
        SQLiteDatabase db = getWritableDatabase();

        //String query = "INSERT INTO students (ID,Name,Class) values("+id+",' " +name+ " ',' " +classname+" ');";
        //db.execSQL(query);
        ContentValues values=new ContentValues();
        //here id is the and id is the values to the content values object
        values.put("Id",id);
        values.put("Name",name);
        values.put("Class",classname);

        //here student is the tablename and the values is set of data keys
        //Id,Name,Classname to be inserted into the table
        db.insert("Student",null,values);
        db.close();

    }

    public void updateStudent(int id,String name,String classname){

        SQLiteDatabase db = getWritableDatabase();
        //String query = "UPDATE students SET Name=' " +name+ " ',Class=' " +classname+" WHERE ID=" + id + ";";
        //db.execSQL(query);
        ContentValues contentValues=new ContentValues();
        contentValues.put("Name",name);
        contentValues.put("Class",classname);
        db.update("student",contentValues,"ID = "+id,null);
        db.close();
    }

    public void deleteStudent(int id){
        SQLiteDatabase db = getWritableDatabase();

        String query = "delete from students where ID=" + id;
        db.execSQL(query);

    }

    public String getStudentById(int id)
    {
        //here result variable will hold the data fetched from the db
        String result="";

        //to fetch the data from the table we use a cursor object
        //and sqlitedatabase object

        SQLiteDatabase db= getWritableDatabase();
        String query="select * from student where ID="+id;
        Cursor c=db.rawQuery(query,null);

        //move the cursor position to the first position of record
        if(c.moveToFirst())
        {
            result+=c.getString(1)+"\n";
            result+=c.getString(2)+"\n";
        }
        else
        {
            result="no record found";
        }
        db.close();
        return result;
    }

    public String getAllStudents()
    {
        //here result variable will hold the data fetched from db
        String result = "";

        SQLiteDatabase db = getWritableDatabase();

        String query= "select * from students";


        Cursor c = db.rawQuery(query,null);
        //MOVE TO THE FIRST RECORD
        //c.moveToFirst();

        while(c.moveToNext())
        {
           result += c.getInt(0) + "\n";
            result += c.getString(1) + "\n";
            result += c.getString(2) + "\n";
        }
        db.close();
        return result;

    }


    }
