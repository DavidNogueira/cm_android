package com.example.student.studenttool;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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
import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    public EditText editNome;
    public EditText editPass;//para a pass
    public String nome;
    public String pass;

    public int schedule;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        android.content.SharedPreferences sharedPref = getSharedPreferences(getString(R.string.shared_pref_1),Context.MODE_PRIVATE);
        int log = sharedPref.getInt(Utils.LOGED_IN, 0);

        if (log == 1){
            Intent i = new Intent(MainActivity.this, MainActivity_tabs.class);
            startActivity(i);
            finish();
        }


    }


    public void botaologin(View v) {

        editNome = (EditText) findViewById(R.id.nome);
        editPass = (EditText) findViewById(R.id.pass);//para a pass

        nome = editNome.getText().toString();
        pass = editPass.getText().toString();
        //String url = "http://192.168.0.78:8888/cmlogin.php?nome="+nome+"&pass="+pass+"";
        String url = getString(R.string.urlmamp)+"cmlogin.php?nome="+nome+"&pass="+pass+"";


        JsonObjectRequest jsObjRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            // ((TextView) findViewById(R.id.texto)).setText(response.getString(Utils.param_status));
                            ((TextView) findViewById(R.id.texto)).setText(response.getString("status"));
                            //Toast.makeText(MainActivity.this, response.getString("status"), Toast.LENGTH_SHORT).show();

                            if(response.getString("status").equals("OK")){
                                SharedPreferences sharedPref = getSharedPreferences(getString(R.string.shared_pref_1), Context.MODE_PRIVATE);
                                SharedPreferences.Editor editor = sharedPref.edit();
                                editor.putInt(Utils.PASS, Integer.parseInt(pass));
                                editor.putString(Utils.NOME, nome);
                                editor.putInt(Utils.LOGED_IN, 1);
                                editor.commit();

                                schedule = sharedPref.getInt(Utils.SCHEDULE, 0);

                                if(schedule == 0){
                                    Intent i = new Intent(MainActivity.this, SelectCourse.class);
                                    startActivity(i);
                                    finish();
                                }else{
                                    Intent i = new Intent(MainActivity.this, MainActivity_tabs.class);
                                    startActivity(i);
                                    finish();
                                }


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


