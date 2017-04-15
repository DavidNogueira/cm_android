package com.example.student.studenttool;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.student.studenttool.adapters.MyCursorAdapter;
import com.example.student.studenttool.db.Contrato;
import com.example.student.studenttool.db.DB;

public class SelectSubjectsTres extends AppCompatActivity {

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
        setContentView(R.layout.layout_select_subjects_tres);


        //1º
        mDbHelper = new DB(this);
        db = mDbHelper.getReadableDatabase();//declaração da bd

        lista = (ListView) findViewById(R.id.lista);

        idDeTras = getIntent().getStringExtra(Utils.CURSO);

        Toast.makeText(SelectSubjectsTres.this,  idDeTras, Toast.LENGTH_SHORT).show();

        preencheListaCostumizada();



    }

    public void itemClicked(View v) {
        //code to check if this checkbox is checked!
        CheckBox checkBox = (CheckBox)v;
        if(checkBox.isChecked()){
            Toast.makeText(SelectSubjectsTres.this,
                    "Checked", Toast.LENGTH_LONG).show();
        }
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
        madapter = new MyCursorAdapter(SelectSubjectsTres.this, c);//é o cursor
        lista.setAdapter(madapter);//vai à lista e preenche-a com  o novo cursor
    }



    public void subjectsave(View v){

        Intent i = new Intent(SelectSubjectsTres.this, MainActivity_tabs.class);
        startActivity(i);
        finish();
    }




}
