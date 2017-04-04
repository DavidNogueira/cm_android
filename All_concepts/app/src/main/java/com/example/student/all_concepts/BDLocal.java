package com.example.student.all_concepts;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import com.example.student.all_concepts.adapters.MyCursorAdapter;
import com.example.student.all_concepts.db.Contrato;
import com.example.student.all_concepts.db.DB;

public class BDLocal extends AppCompatActivity {


    DB mDbHelper;
    SQLiteDatabase db;
    Cursor c, c_pessoas;
    ListView lista, lista2;

    SimpleCursorAdapter adapter;
    MyCursorAdapter madapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_bdlocal);

        registerForContextMenu((ListView) findViewById(R.id.lista2));

        //1º
        mDbHelper = new DB(this);
        db = mDbHelper.getReadableDatabase();//declaração da bd

        lista = (ListView) findViewById(R.id.lista);
        lista2 = (ListView) findViewById(R.id.lista2);


        //2º preencher as listas
        preencheLista();
        preencheListaCostumizada();




    }
    private void getCursor1() {

        String bla = "SELECT "+ Contrato.Pessoa.TABLE_NAME +"."+ Contrato.Pessoa._ID +","+ Contrato.Pessoa.COLUMN_NOME +","+ Contrato.Cidade.COLUMN_NOME +","+ Contrato.Pessoa.COLUMN_IDADE+
                " FROM "+ Contrato.Pessoa.TABLE_NAME + ", " + Contrato.Cidade.TABLE_NAME +
                " WHERE " + Contrato.Pessoa.COLUMN_ID_CIDADE + " = " + Contrato.Cidade.TABLE_NAME +"."+ Contrato.Cidade._ID;

        c = db.rawQuery(bla, null);


    }


    private void preencheLista() {

        getCursor1();

        //fim v4 tutorial 5 base de dados query____________________________________________

        adapter = new SimpleCursorAdapter(this,
                android.R.layout.two_line_list_item,
                c,
                new String[]{Contrato.Pessoa._ID, Contrato.Cidade.COLUMN_NOME},
                new int[]{android.R.id.text1, android.R.id.text2},
                SimpleCursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);

        lista.setAdapter(adapter);
    }





    private void preencheListaCostumizada() {


        getCursor1();

        madapter = new MyCursorAdapter(BDLocal.this, c);//é o cursor


        lista2.setAdapter(madapter);//vai à lista e preenche-a com  o novo cursor
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
                Toast.makeText(BDLocal.this,"OPÇAO 1", Toast.LENGTH_SHORT).show();




                return true;
            case R.id.opcao2:
                Toast.makeText(BDLocal.this,"OPÇAO 2", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.opcao3:
                Toast.makeText(BDLocal.this,"OPÇAO 3", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.opcao4:
                Toast.makeText(BDLocal.this,"OPÇAO 4", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_cont_1, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

        int itemPosition = info.position;
        c.moveToPosition(itemPosition);
        int id_pessoa = c.getInt(c.getColumnIndex(Contrato.Pessoa._ID));
        String nome_pessoa = c.getString(c.getColumnIndex(Contrato.Pessoa.COLUMN_NOME));

        switch (item.getItemId()) {

            case R.id.edit:
/*
                Toast.makeText(MainActivity.this, "editar: " + String.valueOf(itemPosition), Toast.LENGTH_SHORT).show();
                updateInBD(id_pessoa);
*/

                return true;
            case R.id.remove:

                Toast.makeText(BDLocal.this, "remover: " + String.valueOf(itemPosition), Toast.LENGTH_SHORT).show();

                Toast.makeText(BDLocal.this, id_pessoa + "/" + nome_pessoa, Toast.LENGTH_SHORT).show();

                deleteFromBD(id_pessoa);


                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }


    private void deleteFromBD(int id) {

        db.delete(Contrato.Pessoa.TABLE_NAME, Contrato.Pessoa._ID + " =?", new String[]{id + ""});
       // refresh();
    }
    //fim v4 tutorial 7 contextmenu eliminar____________________________________________


/*
    // v4 tutorial 8 contextmenu editar ____________________________________________
    private void updateInBD(int id) {

        ContentValues cv= new ContentValues();
        cv.put(Contrato.Pessoa.COLUMN_ID_CIDADE, 4);
        db.update(Contrato.Pessoa.TABLE_NAME, cv,  Contrato.Pessoa._ID + " =?", new String[]{id + ""});
        refresh();
    }
*/

    @Override
    protected void onDestroy(){
        super.onDestroy();

        if (!c.isClosed()){
            c.close();
            c = null;
        }
        if (!c_pessoas.isClosed()){
            c_pessoas.close();
            c_pessoas =null;
        }
        if (db.isOpen()){
            db.close();
            db = null;
        }

    }








}
