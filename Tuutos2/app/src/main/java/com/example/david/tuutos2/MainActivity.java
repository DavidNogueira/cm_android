package com.example.david.tuutos2;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import com.example.david.tuutos2.db.Contrato;
import com.example.david.tuutos2.db.DB;

public class MainActivity extends AppCompatActivity {

    //v4 tutorial 4 base de dados____________________________________________
    DB mDbHelper;
    SQLiteDatabase db;
    Cursor c, c_pessoas;
    ListView lista;
    SimpleCursorAdapter adapter;
    //fim v4 tutorial 4 base de dados____________________________________________




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main);

        //v4 tutorial 4 base de dados____________________________________________
        mDbHelper = new DB(this);
        db = mDbHelper.getReadableDatabase();

        lista = (ListView) findViewById(R.id.lista);
        //registerForContextMenu(lista);
        preencheLista();
        //preencheSpinner();
        //fim v4 tutorial 4 base de dados____________________________________________

    }




    //1ºVideo Shared preferences____________________________________________
    public void clickbotao(View v){

        SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt(Utils.IDADE,40);
        //editor.putInt(Utils.IDADE,50);
        editor.putString(Utils.NOME,"Mohamed Balacucoestupido");
        editor.commit();

        //*caso quisecemos ir buscar as shared preferences noutra classe, teriamos que usar a linha(comentada) abixo
        //SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
        int peso = sharedPref.getInt("peso",0);
        int idade = sharedPref.getInt("idade",0);
        String nome = sharedPref.getString("nome", null);
        Toast.makeText(MainActivity.this, "peso: "+ String.valueOf(peso) + "; idade: "
                + String.valueOf(idade) + "; nome: "+ nome, Toast.LENGTH_SHORT).show();
    }
    //fim 1ºVideo Shared preferences____________________________________________


    //v4 tutorial 4 base de dados____________________________________________

    private void preencheLista(){

       // c = db.query(false, Contrato.Pessoa.TABLE_NAME, Contrato.Pessoa.PROJECTION, null, null, null, null, null, null);

        //v4 tutorial 5 base de dados query____________________________________________
         c = db.query(false, Contrato.Pessoa.TABLE_NAME, Contrato.Pessoa.PROJECTION,
                 "IDADE > ?", new String[]{String.valueOf(30)},
                 null, null,
                 Contrato.Pessoa.COLUMN_NOME + " DESC", null);

       /* c = db.query(false, Contrato.Pessoa.TABLE_NAME, Contrato.Pessoa.PROJECTION,
                "IDADE > ? AND IDADE < ? AND nome = ?", new String[]{String.valueOf(30), String.valueOf(70), "Alexis"} ,
                null, null,
                Contrato.Pessoa.COLUMN_IDADE + " DESC", null);*/

/*        c = db.query(false, Contrato.Pessoa.TABLE_NAME + ", " + Contrato.Cidade.TABLE_NAME,
               // new String[]{Contrato.Pessoa.COLUMN_NOME, Contrato.Pessoa.COLUMN_IDADE,
                        Contrato.Pessoa.PROJECTION,
                      //  Contrato.Pessoa.COLUMN_ID_CIDADE},
                        "? = ? AND ? = ?", new String[]{Contrato.Pessoa.COLUMN_ID_CIDADE, Contrato.Cidade._ID,
                        Contrato.Pessoa.COLUMN_ID_CIDADE, String.valueOf(3)+""} ,
                null, null,
                Contrato.Pessoa.COLUMN_IDADE + " DESC", null);

        String bla;


        bla = "SELECT "+ Contrato.Pessoa.COLUMN_NOME +","+ Contrato.Pessoa.COLUMN_IDADE +","+ Contrato.Cidade.COLUMN_NOME+
                " FROM "+ Contrato.Pessoa.TABLE_NAME + ", " + Contrato.Cidade.TABLE_NAME +
                " WHERE " + Contrato.Pessoa.COLUMN_ID_CIDADE + " = " + Contrato.Cidade.TABLE_NAME +"."+ "idc" +
                " AND " + Contrato.Pessoa.COLUMN_ID_CIDADE + " = 3";


        c = db.rawQuery(bla, null);*/



        //fim v4 tutorial 5 base de dados query____________________________________________



        adapter =new SimpleCursorAdapter(this,
                android.R.layout.two_line_list_item,
                c,
                new String[]{Contrato.Pessoa.COLUMN_NOME, Contrato.Pessoa.COLUMN_IDADE},
                new int[]{android.R.id.text1, android.R.id.text2},
                SimpleCursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);

        lista.setAdapter(adapter);
    }
    //fim v4 tutorial 4 base de dados____________________________________________






}
