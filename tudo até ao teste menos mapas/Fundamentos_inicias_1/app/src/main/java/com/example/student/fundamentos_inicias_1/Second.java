package com.example.student.fundamentos_inicias_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

import com.example.student.fundamentos_inicias_1.adapters.CustomArrayAdapter;
import com.example.student.fundamentos_inicias_1.entities.Pessoa;
import com.example.student.fundamentos_inicias_1.utils.Utils;

import java.util.ArrayList;

public class Second extends AppCompatActivity {

    ArrayList<Pessoa> arrayPessoa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        String valor = getIntent().getStringExtra(Utils.PARAM_NOME);

       // String valor = getIntent().getStringExtra("k");

        Toast.makeText(Second.this, valor, Toast.LENGTH_SHORT).show();

        //v3 tutorial 10
        registerForContextMenu((ListView) findViewById(R.id.lista2));
        arrayPessoa = new ArrayList<>();

        fillLista();
    }

    //v3 tutorial 5
    public void botao1(View v){
        int valor=2;
        Intent output = new Intent();
        output.putExtra(Utils.PARAM_OUTPUT, "RESULTADO teste");
        output.putExtra(Utils.PARAM_ERRO, "RESULTADO ERRADO");

        if (valor == 1){

            setResult(RESULT_OK, output);
        }else
            setResult(RESULT_CANCELED, output);


        finish();

    }


    //v3 tutorial 7
    private void fillLista(){
        ArrayList<String> arrayItems = new ArrayList<>();
        arrayItems.add("Segunda");
        arrayItems.add("Terça");
        arrayItems.add("Quarta");
        arrayItems.add("Quinta");
        arrayItems.add("Sexta");
        ArrayAdapter<String> itemsAdapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayItems);
        ((ListView) findViewById(R.id.lista)).setAdapter(itemsAdapter);


        //v3 tutorial 8

       // ArrayList<Pessoa> arrayPessoa = new ArrayList<>();
        arrayPessoa.add(new Pessoa ("Alexis", "gaia", 40));
        arrayPessoa.add(new Pessoa ("David", "Braga", 70));
        arrayPessoa.add(new Pessoa ("Renato", "Derrsce", 9));


        CustomArrayAdapter itemsAdapter2 =
                new CustomArrayAdapter(this, arrayPessoa);
        ((ListView) findViewById(R.id.lista2)).setAdapter(itemsAdapter2);

    }

    //v3 tutorial 10

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_cont_1, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item){
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int index = info.position;
        Pessoa p = arrayPessoa.get(index);

        switch(item.getItemId()){

            case R.id.edit:
                Toast.makeText(Second.this, "editar "+ p.getNome(), Toast.LENGTH_SHORT).show();
                return true;
            case R.id.remove:
                Toast.makeText(Second.this, "remover "+ p.getNome(), Toast.LENGTH_SHORT).show();
                return true;
            default: return super.onContextItemSelected(item);
        }
    }
}