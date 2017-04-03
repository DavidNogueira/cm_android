package com.example.student.exemplos_listas;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;


import com.example.student.exemplos_listas.adapter.MyCursorAdapter;
import com.example.student.exemplos_listas.db.Contrato;
import com.example.student.exemplos_listas.db.DB;

public class MainActivity extends AppCompatActivity {

    //v4 tutorial 4 base de dados____________________________________________
    DB mDbHelper;
    SQLiteDatabase db;
    Cursor c, c_pessoas;
    ListView lista;
    SimpleCursorAdapter adapter;
    MyCursorAdapter madapter;

    //fim v4 tutorial 4 base de dados____________________________________________


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main);

        // v4 tutorial 7 contextmenu eliminar____________________________________________
        registerForContextMenu((ListView) findViewById(R.id.lista));
        // v4 fim tutorial 7 contextmenu eliminar________________________________________






        //v4 tutorial 4 base de dados____________________________________________
        mDbHelper = new DB(this);
        db = mDbHelper.getReadableDatabase();

        lista = (ListView) findViewById(R.id.lista);
        //registerForContextMenu(lista);

        //cuidado!!!!! mudar para o outro adaptador
        // preencheLista();
        preencheListaCostumizada();


        //preencheSpinner();
        //fim v4 tutorial 4 base de dados____________________________________________

    }


    //1ºVideo Shared preferences____________________________________________
    public void clickbotaoshared(View v) {

        SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt(Utils.IDADE, 40);
        //editor.putInt(Utils.IDADE,50);
        editor.putString(Utils.NOME, "Mohamed Balacucoestupido");
        editor.commit();

        //*caso quisecemos ir buscar as shared preferences noutra classe, teriamos que usar a linha(comentada) abaixo
        //SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
        int peso = sharedPref.getInt("peso", 0);
        int idade = sharedPref.getInt("idade", 0);
        String nome = sharedPref.getString("nome", null);
        Toast.makeText(MainActivity.this, "peso: " + String.valueOf(peso) + "; idade: "
                + String.valueOf(idade) + "; nome: " + nome, Toast.LENGTH_SHORT).show();
    }
    //fim 1ºVideo Shared preferences____________________________________________

    public void clickBotao(View v) {

        ContentValues cv = new ContentValues();
        //cv.put(Contrato.Pessoa._ID, 7);
        cv.put(Contrato.Pessoa.COLUMN_NOME, "Vaca das Cordas");
        cv.put(Contrato.Pessoa.COLUMN_IDADE, 69);
        cv.put(Contrato.Pessoa.COLUMN_ID_CIDADE, 2);
        db.insert(Contrato.Pessoa.TABLE_NAME, null, cv);
        refresh();

    }

    public void refresh() {
      //  getCursor();

        //cuidado!!!!! mudar para o outro adaptador
        //adapter.swapCursor(c);
       // madapter.swapCursor(c);

        //preencheLista();

preencheListaCostumizada();

    }

    private void getCursor() {
        String bla = "SELECT "+ Contrato.Pessoa.TABLE_NAME +"."+ Contrato.Pessoa._ID +","+ Contrato.Pessoa.COLUMN_NOME +","+ Contrato.Cidade.COLUMN_NOME +","+ Contrato.Pessoa.COLUMN_IDADE+
                " FROM "+ Contrato.Pessoa.TABLE_NAME + ", " + Contrato.Cidade.TABLE_NAME +
                " WHERE " + Contrato.Pessoa.COLUMN_ID_CIDADE + " = " + Contrato.Cidade.TABLE_NAME +"."+ Contrato.Cidade._ID;

        c = db.rawQuery(bla, null);

/*        c = db.query(false, Contrato.Pessoa.TABLE_NAME, Contrato.Pessoa.PROJECTION,
                "idade > ?", new String[]{String.valueOf(30)},
                null, null,
                Contrato.Pessoa.COLUMN_NOME + " DESC", null);*/

    }


    //v4 tutorial 4 base de dados____________________________________________

    private void preencheLista() {



        String bla = "SELECT "+ Contrato.Pessoa.TABLE_NAME +"."+ Contrato.Pessoa._ID +","+ Contrato.Pessoa.COLUMN_NOME +","+ Contrato.Cidade.COLUMN_NOME +","+ Contrato.Pessoa.COLUMN_IDADE+
                " FROM "+ Contrato.Pessoa.TABLE_NAME + ", " + Contrato.Cidade.TABLE_NAME +
                " WHERE " + Contrato.Pessoa.COLUMN_ID_CIDADE + " = " + Contrato.Cidade.TABLE_NAME +"."+ Contrato.Cidade._ID;

        c = db.rawQuery(bla, null);






        // c = db.query(false, Contrato.Pessoa.TABLE_NAME, Contrato.Pessoa.PROJECTION, null, null, null, null, null, null);

        //v4 tutorial 5 base de dados query____________________________________________
     /*   c = db.query(false, Contrato.Pessoa.TABLE_NAME, Contrato.Pessoa.PROJECTION,
                "idade > ?", new String[]{String.valueOf(30)},
                null, null,
                Contrato.Pessoa.COLUMN_NOME + " DESC", null);*/

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
                " WHERE " + Contrato.Pessoa.COLUMN_ID_CIDADE + " = " + Contrato.Cidade.TABLE_NAME +"."+ Contrato.Cidade._ID +
                " AND " + Contrato.Pessoa.COLUMN_ID_CIDADE + " = 3";


        c = db.rawQuery(bla, null);*/


        //fim v4 tutorial 5 base de dados query____________________________________________

        adapter = new SimpleCursorAdapter(this,
                android.R.layout.two_line_list_item,
                c,
                new String[]{Contrato.Pessoa._ID, Contrato.Cidade.COLUMN_NOME},
                new int[]{android.R.id.text1, android.R.id.text2},
                SimpleCursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);

        lista.setAdapter(adapter);
    }
    //fim v4 tutorial 4 base de dados____________________________________________


    // v4 tutorial 7 contextmenu eliminar____________________________________________

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

                Toast.makeText(MainActivity.this, "editar: " + String.valueOf(itemPosition), Toast.LENGTH_SHORT).show();
                updateInBD(id_pessoa);


                return true;
            case R.id.remove:

                Toast.makeText(MainActivity.this, "remover: " + String.valueOf(itemPosition), Toast.LENGTH_SHORT).show();

                Toast.makeText(MainActivity.this, id_pessoa + "/" + nome_pessoa, Toast.LENGTH_SHORT).show();

                deleteFromBD(id_pessoa);


                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

    private void deleteFromBD(int id) {

        db.delete(Contrato.Pessoa.TABLE_NAME, Contrato.Pessoa._ID + " =?", new String[]{id + ""});
        refresh();
    }
    //fim v4 tutorial 7 contextmenu eliminar____________________________________________



    // v4 tutorial 8 contextmenu editar ____________________________________________
    private void updateInBD(int id) {

        ContentValues cv= new ContentValues();
        cv.put(Contrato.Pessoa.COLUMN_ID_CIDADE, 4);
        db.update(Contrato.Pessoa.TABLE_NAME, cv,  Contrato.Pessoa._ID + " =?", new String[]{id + ""});
        refresh();
    }
    // v4 fim tutorial 8 contextmenu editar____________________________________________









    private void preencheListaCostumizada() {
        getCursor();

        madapter = new MyCursorAdapter(MainActivity.this, c);//é o cursor


        lista.setAdapter(madapter);//vai à lista e preenche-a com  o novo cursor
    }


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

