package com.example.student.tudo;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity_escolha extends AppCompatActivity {

    public TextView editNome;//iniciamos a textView
    public TextView editPass;//iniciamos a textView
    public String nome;
    public int pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2_escolha);

        editNome = (TextView) findViewById(R.id.txtnome);//a textView que foi iniciada, é associada à que já existe
        editPass = (TextView) findViewById(R.id.txtpass);//a textView que foi iniciada, é associada à que já existe

        android.content.SharedPreferences sharedPref = getSharedPreferences(getString(R.string.shared_pref_1), Context.MODE_PRIVATE);
        //nome = sharedPref.getString("nome", null);//é o mesmo que a de baixo desta
        nome = sharedPref.getString(Utils.NOME, null);
        pass = sharedPref.getInt("pass", 0);

        editNome.setText(String.valueOf(nome));
        editPass.setText(String.valueOf(pass));

    }
}
