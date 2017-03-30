package com.example.david.tuutos2;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main);
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
    //1ºVideo Shared preferences____________________________________________

}
