package com.example.student.nogueiradavid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    double media = 0;
    int negativas = 0;
    int numalunos = 0;


    public ArrayList<String> arrayItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }




    public void botao3(View v) {


        Intent i = new Intent(MainActivity.this, activity3.class);
        startActivity(i);
    }





    public void botao4(View v) {



        String url = "http://ahead.ycorn.pt/saraws/ws_teste_2.php";

        arrayItems = new ArrayList<>();

        JsonObjectRequest jsObjRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        try {

                            ((TextView) findViewById(R.id.textView)).setText(response.getString("status"));
                            JSONArray arr = response.getJSONArray("dados");

                            for (int i = 0; i < arr.length(); i++) {
                                JSONObject obj = arr.getJSONObject(i);

                                //arrayItems.add(obj.getString("cidade"));

                                //  arrayPessoa.add(new Pessoa (obj.getString("cidade"), obj.getString("pais"), obj.getInt("habitantes")));
                                media = media + obj.getInt("idade");




                                JSONArray arr2 = obj.getJSONArray("notas");


                                for (int x = 0; x < arr2.length(); x++) {

                                    JSONObject obj2 = arr2.getJSONObject(x);
                                    if (obj2.getInt("nota") < 10 && obj2.getString("nome").equals("Matematica")){
                                        negativas = negativas + 1;
                                    }


                                }


                                numalunos = numalunos + 1;


                            }


                            media = media / numalunos;

                            Toast.makeText(MainActivity.this, String.valueOf(media), Toast.LENGTH_SHORT).show();
                            Toast.makeText(MainActivity.this, String.valueOf(negativas), Toast.LENGTH_SHORT).show();
                            Toast.makeText(MainActivity.this, String.valueOf(numalunos), Toast.LENGTH_SHORT).show();







                        } catch(JSONException ex){}
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, "erro", Toast.LENGTH_SHORT).show();

                    }
                });


        // Access the RequestQueue through your singleton class.
        MySingleton.getInstance(this).addToRequestQueue(jsObjRequest);


    }



}
