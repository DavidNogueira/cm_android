package com.example.student.studenttool;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import com.example.student.studenttool.adapters.MyCursorAdapter;
import com.example.student.studenttool.db.Contrato;
import com.example.student.studenttool.db.DB;

public class SelectSubjects extends AppCompatActivity {

    DB mDbHelper;
    SQLiteDatabase db;

    Cursor c, c_pessoas;
    ListView lista, lista2;
    SimpleCursorAdapter adapter;
    MyCursorAdapter madapter;


    public String idDeTras;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_select_subjects);


        //1º
        mDbHelper = new DB(this);
        db = mDbHelper.getReadableDatabase();//declaração da bd

        lista = (ListView) findViewById(R.id.lista);

        idDeTras = getIntent().getStringExtra(Utils.CURSO);

        Toast.makeText(SelectSubjects.this,  idDeTras, Toast.LENGTH_SHORT).show();

        preencheListaCostumizada();


    }

    private void getCursor1() {


        String bla = "SELECT "+Contrato.Disciplina.TABLE_NAME +"."+ Contrato.Disciplina._ID + ","+ Contrato.Associa.TABLE_NAME+"."+ Contrato.Associa.COLUMN_ID_DISCIPLINA +","+  Contrato.Disciplina.COLUMN_NOME_DISCIPLINA +
                " FROM "+ Contrato.Associa.TABLE_NAME + ", " + Contrato.Disciplina.TABLE_NAME +
                " WHERE " + Contrato.Associa.COLUMN_ID_DISCIPLINA + " = " + Contrato.Disciplina.TABLE_NAME +"."+ Contrato.Disciplina._ID +
                " AND "+Contrato.Associa.TABLE_NAME+"."+ Contrato.Associa.COLUMN_ID_CURSO+" = "+ idDeTras;

        c = db.rawQuery(bla, null);
    }

    private void preencheListaCostumizada() {


        getCursor1();

        madapter = new MyCursorAdapter(SelectSubjects.this, c);//é o cursor


        lista.setAdapter(madapter);//vai à lista e preenche-a com  o novo cursor
    }







}
