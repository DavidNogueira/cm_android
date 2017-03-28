package com.example.student.fundamentos_inicias_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class AtividadeInicial extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atividade_inicial);

        Toast.makeText(AtividadeInicial.this, "onCreate", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause(){
        super.onPause();
        Toast.makeText(AtividadeInicial.this, "onPause", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop(){
        super.onStop();
       Log.d("TAG","onStop");
    }

    @Override
    protected void onStart(){
        super.onStart();
        Toast.makeText(AtividadeInicial.this, "onStart", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume(){
        super.onResume();
        Toast.makeText(AtividadeInicial.this, "onResume", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d("TAG","onDestroy");
    }


}
