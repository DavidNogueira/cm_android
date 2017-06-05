package com.example.student.nogueiradavid;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.student.nogueiradavid.db.Contrato;
import com.example.student.nogueiradavid.db.DB;

public class activity4 extends AppCompatActivity {


    DB mDbHelper;
    SQLiteDatabase db;


    public EditText descr;
    public EditText latitu;
    public EditText longitu;
    public EditText tipo;



    public String novodescr;
    public String novolatitu;
    public String novolongitu;
    public int novotipo;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_activity4);





        mDbHelper = new DB(this);
        db = mDbHelper.getReadableDatabase();//declaração da bd

        descr = (EditText) findViewById(R.id.edit1);
        latitu = (EditText) findViewById(R.id.edit2);
        longitu = (EditText) findViewById(R.id.edit3);
        tipo = (EditText) findViewById(R.id.edit4);



    }




    public void botaoinsert(View v) {

        novodescr = descr.getText().toString();
        novolatitu = latitu.getText().toString();
        novolongitu = longitu.getText().toString();
        novotipo = Integer.parseInt(tipo.getText().toString());



        ContentValues cv= new ContentValues();
        cv.put(Contrato.Monumento.COLUMN_DESCR, novodescr);
        cv.put(Contrato.Monumento.COLUMN_LATITUDE, novolatitu);
        cv.put(Contrato.Monumento.COLUMN_LONGITUDE, novolongitu);
        cv.put(Contrato.Monumento.COLUMN_TIPO, novotipo);


        db.insert(Contrato.Monumento.TABLE_NAME,null,cv);



        finish();



    }


    @Override
    protected void onDestroy(){
        super.onDestroy();


        if (db.isOpen()){
            db.close();
            db = null;
        }

    }


}
