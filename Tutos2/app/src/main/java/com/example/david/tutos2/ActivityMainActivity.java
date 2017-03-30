package com.example.david.tutos2;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class ActivityMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_activity_main);
    }

    public void clickBotao3(View v){

        SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt(Utils.IDADE,40);
        editor.putString(Utils.NOME,"Mohamed Balacucoestupido");
        editor.commit();


        int peso = sharedPref.getInt("peso",0);
        int idade = sharedPref.getInt("idade",0);
        String nome = sharedPref.getString("nome", null);
        Toast.makeText(ActivityMainActivity.this, "peso: "+ String.valueOf(peso) + "; idade: "
                + String.valueOf(idade) + "; nome: "+ nome, Toast.LENGTH_SHORT).show();



    }






}
