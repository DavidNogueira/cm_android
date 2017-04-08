package com.example.student.nogueiradavid;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Actividade2 extends AppCompatActivity {
    public EditText editNome;
    public String nome;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividade2);
    }


    public void botaologin(View v){

        editNome = (EditText) findViewById(R.id.nome);
        nome = editNome.getText().toString();



        SharedPreferences sharedPref = getSharedPreferences(getString(R.string.shared_pref_1), Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(Utils.NOME, nome);
        editor.commit();


        Intent i = new Intent(Actividade2.this, Actividade3.class);
        startActivity(i);


    }



}
