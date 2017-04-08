package com.example.student.nogueiradavid;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import com.example.student.nogueiradavid.db.Contrato;
import com.example.student.nogueiradavid.db.DB;

public class Actividade3 extends AppCompatActivity {

    public TextView editNome;//iniciamos a textView
    public EditText editCidade;//iniciamos a textView
    public String nome;
    public int pass;



    DB mDbHelper;
    SQLiteDatabase db;

    Cursor c, c_pessoas;
    ListView lista, lista2;
    SimpleCursorAdapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividade3);


        mDbHelper = new DB(this);
        db = mDbHelper.getReadableDatabase();//declaração da bd

        lista = (ListView) findViewById(R.id.listView);
        editCidade = (EditText) findViewById(R.id.editcidade);

        preencheLista();



        editNome = (TextView) findViewById(R.id.txtnome);//a textView que foi iniciada, é associada à que já existe

        android.content.SharedPreferences sharedPref = getSharedPreferences(getString(R.string.shared_pref_1), Context.MODE_PRIVATE);
        //nome = sharedPref.getString("nome", null);//é o mesmo que a de baixo desta
        nome = sharedPref.getString(Utils.NOME, null);

        editNome.setText(String.valueOf(nome));





    }


    private void preencheLista() {

        getCursor1();

        //fim v4 tutorial 5 base de dados query____________________________________________

        adapter = new SimpleCursorAdapter(this,
                android.R.layout.two_line_list_item,
                c,
                new String[]{Contrato.Pessoa.COLUMN_NOME, Contrato.Cidade.COLUMN_NOME},
                new int[]{android.R.id.text1, android.R.id.text2},
                SimpleCursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);

        lista.setAdapter(adapter);
    }


    private void getCursor1() {

        String bla = "SELECT "+ Contrato.Pessoa.TABLE_NAME +"."+ Contrato.Pessoa._ID +","+ Contrato.Pessoa.COLUMN_NOME +","+ Contrato.Cidade.COLUMN_NOME +","+ Contrato.Pessoa.COLUMN_IDADE+
                " FROM "+ Contrato.Pessoa.TABLE_NAME + ", " + Contrato.Cidade.TABLE_NAME +
                " WHERE " + Contrato.Pessoa.COLUMN_ID_CIDADE + " = " + Contrato.Cidade.TABLE_NAME +"."+ Contrato.Cidade._ID;

        c = db.rawQuery(bla, null);


    }


/*
        public void queryy(View v){

            String bla = "SELECT "+ Contrato.Pessoa.TABLE_NAME +"."+ Contrato.Pessoa._ID +","+ Contrato.Pessoa.COLUMN_NOME +","+ Contrato.Cidade.COLUMN_NOME +","+ Contrato.Pessoa.COLUMN_IDADE+
                    " FROM "+ Contrato.Pessoa.TABLE_NAME + ", " + Contrato.Cidade.TABLE_NAME +
                    " WHERE " + Contrato.Pessoa.COLUMN_ID_CIDADE + " = " + Contrato.Cidade.TABLE_NAME +"."+ Contrato.Cidade._ID;

            c = db.rawQuery(bla, null);



            adapter = new SimpleCursorAdapter(this,
                    android.R.layout.two_line_list_item,
                    c,
                    new String[]{Contrato.Pessoa.COLUMN_NOME, Contrato.Cidade.COLUMN_NOME},
                    new int[]{android.R.id.text1, android.R.id.text2},
                    SimpleCursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);

            lista.setAdapter(adapter);


        }*/

    public void listagem(View v) {

        String cid = editCidade.getText().toString();

        String bla = "SELECT "+ Contrato.Pessoa.TABLE_NAME +"."+ Contrato.Pessoa._ID +","+ Contrato.Pessoa.COLUMN_NOME +","+ Contrato.Cidade.TABLE_NAME +"."+ Contrato.Cidade.COLUMN_NOME +","+ Contrato.Pessoa.COLUMN_IDADE+
                " FROM "+ Contrato.Pessoa.TABLE_NAME + ", " + Contrato.Cidade.TABLE_NAME +
                " WHERE " + Contrato.Pessoa.COLUMN_ID_CIDADE + " = " + Contrato.Cidade.TABLE_NAME +"."+ Contrato.Cidade._ID+
                " AND " + Contrato.Cidade.TABLE_NAME +"."+ Contrato.Cidade.COLUMN_NOME +" = '"+ cid + "'";

        c = db.rawQuery(bla, null);

        adapter.swapCursor(c);

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu){

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_ativ_1, menu);
        return true;

    }
    //v3 tutorial 9
    @Override
    public boolean onOptionsItemSelected(MenuItem item){

        switch (item.getItemId()){

            case R.id.opcao1:

                Intent i = new Intent(Actividade3.this, Atividade4.class);
                startActivity(i);


                return true;

            default:
                return super.onOptionsItemSelected(item);

        }
    }


    @Override
    protected void onDestroy(){
        super.onDestroy();

        if (!c.isClosed()){
            c.close();
            c = null;
        }
        if (db.isOpen()){
            db.close();
            db = null;
        }

    }


}
