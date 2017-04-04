package com.example.student.all_concepts;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

public class Escolha extends AppCompatActivity {
    public TextView editNome;//iniciamos a textView
    public TextView editPass;//iniciamos a textView
    public String nome;
    public int pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_escolha);


        editNome = (TextView) findViewById(R.id.txtnome);//a textView que foi iniciada, é associada à que já existe
        editPass = (TextView) findViewById(R.id.txtpass);//a textView que foi iniciada, é associada à que já existe

        android.content.SharedPreferences sharedPref = getSharedPreferences(getString(R.string.shared_pref_1),Context.MODE_PRIVATE);
        //nome = sharedPref.getString("nome", null);//é o mesmo que a de baixo desta
        nome = sharedPref.getString(Utils.NOME, null);
        pass = sharedPref.getInt("pass", 0);

        editNome.setText(String.valueOf(nome));
        editPass.setText(String.valueOf(pass));




    }


    public void botaows(View v) {

        Intent i = new Intent(Escolha.this, WS.class);
        startActivity(i);
    }



    public void botaobdlocal(View v) {

        Intent i = new Intent(Escolha.this, BDLocal.class);
        startActivity(i);
    }



}
