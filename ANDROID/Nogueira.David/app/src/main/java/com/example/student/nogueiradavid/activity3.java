package com.example.student.nogueiradavid;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.student.nogueiradavid.db.Contrato;
import com.example.student.nogueiradavid.db.DB;

import java.util.List;

public class activity3 extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    TextView myTextSelected;

    Spinner spinner;

    DB mDbHelper;
    SQLiteDatabase db;

    Button ok;

    Cursor c;

    ListView lista;



    SimpleCursorAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_activity3);


        spinner = (Spinner) findViewById(R.id.spinner);



        mDbHelper = new DB(this);
        db = mDbHelper.getReadableDatabase();//declaração da bd

        loadSpinnerData();

        spinner.setOnItemSelectedListener(this);
        lista = (ListView) findViewById(R.id.lista); //decalração da lista de cima



        ok = (Button) findViewById(R.id.button);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



             //   c.moveToPosition(0);
                //int idCurso = c.getInt(0);






               // // int idCurso = c.getInt(c.getColumnIndex(Contrato.Curso._ID));



                preencheLista();


            }
        });




    }




    private void getCursor1() {


        String bla = "SELECT "+ Contrato.Monumento.TABLE_NAME +"."+ Contrato.Monumento._ID + " , " + Contrato.Monumento.TABLE_NAME +"."+ Contrato.Monumento.COLUMN_DESCR +
                " FROM "+ Contrato.Monumento.TABLE_NAME + ","+ Contrato.Tipo.TABLE_NAME +
                " WHERE " + Contrato.Tipo.TABLE_NAME +"."+ Contrato.Tipo._ID + " = " + Contrato.Monumento.COLUMN_TIPO + " AND "
                + Contrato.Tipo.TABLE_NAME +"."+ Contrato.Tipo.COLUMN_DESCR + " = '" + myTextSelected.getText() + "'";

        c = db.rawQuery(bla, null);


    }


    private void preencheLista() {

        getCursor1();

        //fim v4 tutorial 5 base de dados query____________________________________________

        adapter = new SimpleCursorAdapter(this,
                android.R.layout.two_line_list_item,
                c,
                new String[]{Contrato.Monumento._ID, Contrato.Monumento.COLUMN_DESCR},
                new int[]{android.R.id.text1, android.R.id.text2},
                SimpleCursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);

        lista.setAdapter(adapter);
    }







    private void loadSpinnerData() {//preenche spinner

        DB dbb = new DB(getApplicationContext());
        List<String> lables = dbb.getAllLabels();

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, lables);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);
    }




    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        TextView myText = (TextView) view;
        Toast.makeText(this,"Seleccionas-te " + myText.getText(), Toast.LENGTH_SHORT).show();
        myTextSelected = (TextView) view;

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {


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



                db.delete(Contrato.Monumento.TABLE_NAME,Contrato.Monumento.COLUMN_TIPO + " =?",new String[]{"1"});
                preencheLista();

                return true;
            case R.id.opcao2:


                Intent i = new Intent(activity3.this, activity4.class);
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
