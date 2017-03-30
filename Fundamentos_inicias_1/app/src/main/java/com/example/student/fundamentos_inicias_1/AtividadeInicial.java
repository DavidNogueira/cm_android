package com.example.student.fundamentos_inicias_1;

import android.content.Intent;
import android.speech.tts.UtteranceProgressListener;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;




import com.example.student.fundamentos_inicias_1.utils.Utils;




public class AtividadeInicial extends AppCompatActivity {

    //EditText editNome = (EditText)findViewById(R.id.editnome);
    EditText editNome;
    private int REQUEST_CODE_OP_1 = 1;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atividade_inicial);

        editNome = (EditText)findViewById(R.id.editnome);



        Toast.makeText(AtividadeInicial.this, getResources().getString(R.string.bemvindo2), Toast.LENGTH_SHORT).show();
        Toast.makeText(AtividadeInicial.this, "onCreate", Toast.LENGTH_SHORT).show();



}
    // v3 tutorial 4
    public void botao1(View v){
       // EditText editNome = (EditText)findViewById(R.id.editnome);

        if(editNome.getText().toString().equals("")){
            Toast.makeText(AtividadeInicial.this, "escreva algo", Toast.LENGTH_SHORT).show();

        }
        else{
            Toast.makeText(AtividadeInicial.this, editNome.getText().toString(), Toast.LENGTH_SHORT).show();

            TextView umdoistres = (TextView) findViewById(R.id.umdoistres);
            umdoistres.setText(editNome.getText().toString());
        }

    }


    //v3 tutorial 5/6
    public void botao2(View v){
        Intent i = new Intent(AtividadeInicial.this, Second.class);
        i.putExtra(Utils.PARAM_NOME, editNome.getText().toString());

        i.putExtra("k", editNome.getText().toString());
        //startActivity(i);
        startActivityForResult(i, REQUEST_CODE_OP_1);

    }


    //v3 tutorial 5/6
    public void botao3(View v){
        Intent i = new Intent(AtividadeInicial.this, MainActivity_tabs.class);

        startActivity(i);

    }




    //v3 tutorial 6
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // Check which request we're responding to
        if (requestCode == REQUEST_CODE_OP_1) {
            // Make sure the request was successful
            if (resultCode == RESULT_OK) {
                Toast.makeText(AtividadeInicial.this, data.getStringExtra(Utils.PARAM_OUTPUT), Toast.LENGTH_SHORT).show();
            }
            if (resultCode == RESULT_CANCELED) {
                Toast.makeText(AtividadeInicial.this, data.getStringExtra(Utils.PARAM_ERRO), Toast.LENGTH_SHORT).show();

            }
        }
    }

    //v3 tutorial 9
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
            Toast.makeText(AtividadeInicial.this,"OPÇAO 1", Toast.LENGTH_SHORT).show();
            return true;
        case R.id.opcao2:
            Toast.makeText(AtividadeInicial.this,"OPÇAO 2", Toast.LENGTH_SHORT).show();
            return true;
        case R.id.opcao3:
            Toast.makeText(AtividadeInicial.this,"OPÇAO 3", Toast.LENGTH_SHORT).show();
            return true;
        case R.id.opcao4:
            Toast.makeText(AtividadeInicial.this,"OPÇAO 4", Toast.LENGTH_SHORT).show();
            return true;
        default:
            return super.onOptionsItemSelected(item);

    }
}


/*


    //v2 tutorial 4
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
*/


}
