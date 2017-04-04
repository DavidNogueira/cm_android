package com.example.student.all_concepts;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.student.all_concepts.db.Contrato;
import com.example.student.all_concepts.db.DB;

public class Editar extends AppCompatActivity {

    DB mDbHelper;
    SQLiteDatabase db;

    public TextView editId;
    public TextView editNome;
    public EditText editIdade;
    public EditText editIdCidade;


    public String nome;
    public int idade;
    public int id_cidade;

    public String valor;
    public String valor2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_editar);


        mDbHelper = new DB(this);
        db = mDbHelper.getReadableDatabase();//declaração da bd

        editId = (TextView) findViewById(R.id.edit0);
        editNome = (TextView) findViewById(R.id.edit1);
        editIdade = (EditText) findViewById(R.id.edit2);
        editIdCidade = (EditText) findViewById(R.id.edit3);


        Toast.makeText(Editar.this,valor, Toast.LENGTH_SHORT).show();

        valor = getIntent().getStringExtra(Utils.PARAM_ID);

        editId.setText(valor);

        valor2 = getIntent().getStringExtra(Utils.PARAM_NOME);

        editNome.setText(valor2);



    }


    public void botaoinsert(View v) {

        nome = editNome.getText().toString();
        idade = Integer.parseInt(editIdade.getText().toString());
        id_cidade = Integer.parseInt(editIdCidade.getText().toString());



        ContentValues cv= new ContentValues();
        cv.put(Contrato.Pessoa.COLUMN_IDADE, idade);
        cv.put(Contrato.Pessoa.COLUMN_ID_CIDADE, id_cidade);
        db.update(Contrato.Pessoa.TABLE_NAME, cv,  Contrato.Pessoa._ID + " =?", new String[]{valor + ""});



        finish();



    }



}
