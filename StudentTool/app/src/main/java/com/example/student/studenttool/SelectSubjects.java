package com.example.student.studenttool;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
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


    public CheckBox[] ch = new CheckBox[32];
    int checked = 0;
    int[] check=new int[32];



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_select_subjects);




        ch[0] = (CheckBox)findViewById(R.id.checkBox1);
        ch[1] = (CheckBox)findViewById(R.id.checkBox2);
        ch[2] = (CheckBox)findViewById(R.id.checkBox3);
        ch[3] = (CheckBox)findViewById(R.id.checkBox4);
        ch[4] = (CheckBox)findViewById(R.id.checkBox5);
        ch[5] = (CheckBox)findViewById(R.id.checkBox6);
        ch[6] = (CheckBox)findViewById(R.id.checkBox7);
        ch[7] = (CheckBox)findViewById(R.id.checkBox8);
        ch[8] = (CheckBox)findViewById(R.id.checkBox9);
        ch[9] = (CheckBox)findViewById(R.id.checkBox10);
        ch[10] = (CheckBox)findViewById(R.id.checkBox11);
        ch[11] = (CheckBox)findViewById(R.id.checkBox12);
        ch[12] = (CheckBox)findViewById(R.id.checkBox13);
        ch[13] = (CheckBox)findViewById(R.id.checkBox14);
        ch[14] = (CheckBox)findViewById(R.id.checkBox15);
        ch[15] = (CheckBox)findViewById(R.id.checkBox16);
        ch[16] = (CheckBox)findViewById(R.id.checkBox17);
        ch[17] = (CheckBox)findViewById(R.id.checkBox18);
        ch[18] = (CheckBox)findViewById(R.id.checkBox19);
        ch[19] = (CheckBox)findViewById(R.id.checkBox20);
        ch[20] = (CheckBox)findViewById(R.id.checkBox21);
        ch[21] = (CheckBox)findViewById(R.id.checkBox22);
        ch[22] = (CheckBox)findViewById(R.id.checkBox23);
        ch[23] = (CheckBox)findViewById(R.id.checkBox24);
        ch[24] = (CheckBox)findViewById(R.id.checkBox25);
        ch[25] = (CheckBox)findViewById(R.id.checkBox26);
        ch[26] = (CheckBox)findViewById(R.id.checkBox27);
        ch[27] = (CheckBox)findViewById(R.id.checkBox28);
        ch[28] = (CheckBox)findViewById(R.id.checkBox29);
        ch[29] = (CheckBox)findViewById(R.id.checkBox30);
        ch[30] = (CheckBox)findViewById(R.id.checkBox31);
        ch[31] = (CheckBox)findViewById(R.id.checkBox32);




        //1º
        mDbHelper = new DB(this);
        db = mDbHelper.getReadableDatabase();//declaração da bd

        lista = (ListView) findViewById(R.id.lista);

        idDeTras = getIntent().getStringExtra(Utils.CURSO);

        //Toast.makeText(SelectSubjects.this,  idDeTras, Toast.LENGTH_SHORT).show();








        getCursor1();



    }

    private void getCursor1() {


        String bla = "SELECT "+ Contrato.Associa.COLUMN_CHECK +","+  Contrato.Associa.TABLE_NAME+"."+ Contrato.Associa.COLUMN_ID_DISCIPLINA +","+  Contrato.Disciplina.COLUMN_NOME_DISCIPLINA + ","+ Contrato.Associa.TABLE_NAME+"."+ Contrato.Associa._ID +
                " FROM "+ Contrato.Associa.TABLE_NAME + ", " + Contrato.Disciplina.TABLE_NAME +
                " WHERE " + Contrato.Associa.COLUMN_ID_DISCIPLINA + " = " + Contrato.Disciplina.TABLE_NAME +"."+ Contrato.Disciplina._ID +
                " AND "+Contrato.Associa.TABLE_NAME+"."+ Contrato.Associa.COLUMN_ID_CURSO+" = "+ idDeTras+
                " ORDER BY " + Contrato.Associa.TABLE_NAME +"."+ Contrato.Associa._ID;

        c = db.rawQuery(bla, null);

        String nomeDis;
        String checki;
        for(int i=0; i < 32; i++){

            c.moveToPosition(i);
            nomeDis = c.getString(c.getColumnIndex(Contrato.Disciplina.COLUMN_NOME_DISCIPLINA));
            ch[i].setText(nomeDis);
            checki = c.getString(c.getColumnIndex(Contrato.Associa.COLUMN_CHECK));
            if(checki.equals("1")){
                ch[i].setChecked(true);
            }else{
                ch[i].setChecked(false);
            }


        }

    }


    public void subjectsave(View v){
       int k;

        if(idDeTras.equals("1")){
            k=1;
        }else{
            k=33;
        }


        for(int i=0; i < 32; i++){
            if(ch[i].isChecked()){


                ContentValues cv= new ContentValues();
                cv.put(Contrato.Associa.COLUMN_CHECK, 1);

                db.update(Contrato.Associa.TABLE_NAME, cv,  Contrato.Associa._ID + " =?", new String[]{k + ""});


            }else{


                ContentValues cv= new ContentValues();
                cv.put(Contrato.Associa.COLUMN_CHECK, 0);
                db.update(Contrato.Associa.TABLE_NAME, cv,  Contrato.Associa._ID + " =?", new String[]{k + ""});

            }
        k=k+1;
        }



        Intent i = new Intent(SelectSubjects.this, MainActivity_tabs.class);
        String p = String.valueOf(idDeTras);
        i.putExtra(Utils.CURSO, p);
        finish();
        startActivity(i);
    }




}
