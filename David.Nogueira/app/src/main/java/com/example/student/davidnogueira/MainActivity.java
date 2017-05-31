package com.example.student.davidnogueira;

import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {


    public EditText editNome;
    public EditText editPass;//para a pass
    public String nome;
    public String pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void botaologin(View v) {

        editNome = (EditText) findViewById(R.id.nome);
        editPass = (EditText) findViewById(R.id.pass);//para a pass

        nome = editNome.getText().toString();
        pass = editPass.getText().toString();
        String url = "http://192.168.1.239:8888/wslogin.php?nome="+nome+"&pass="+pass+"";


        JsonObjectRequest jsObjRequest = new JsonObjectRequest
                (DownloadManager.Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            // ((TextView) findViewById(R.id.texto)).setText(response.getString(Utils.param_status));
                            ((TextView) findViewById(R.id.texto)).setText(response.getString("status"));
                            Toast.makeText(MainActivity.this, response.getString("status"), Toast.LENGTH_SHORT).show();

                            //SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
                            SharedPreferences sharedPref = getSharedPreferences(getString(R.string.shared_pref_1), Context.MODE_PRIVATE);
                            SharedPreferences.Editor editor = sharedPref.edit();
                            editor.putInt(Utils.PASS, Integer.parseInt(pass));
                            editor.putString(Utils.NOME, nome);
                            editor.commit();

                            if(response.getString("status").equals("OK")){
                                Intent i = new Intent(MainActivity.this, Escolha.class);
                                startActivity(i);
                            }else{
                                Toast.makeText(MainActivity.this, "no entry", Toast.LENGTH_SHORT).show();

                            }


                        } catch(JSONException ex){}
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        ((TextView) findViewById(R.id.texto)).setText(Utils.output_erro);
                    }
                });

        // Access the RequestQueue through your singleton class.
        MySingleton.getInstance(this).addToRequestQueue(jsObjRequest);
    }



}