package com.example.student.nogueiradavid;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class LayoutMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main);
    }

    public void actividade2(View v){


        Intent i = new Intent(LayoutMainActivity.this, Actividade2.class);
        startActivity(i);
    }



    // 11)
    /*



   public void ws(View v) {


        String url = "http://ahead.ycorn.pt/saraws/ws_teste.php";

        JsonObjectRequest jsObjRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        try {


                            ((TextView) findViewById(R.id.texto)).setText(response.getString(Utils.param_status));
                            JSONArray arr = response.getJSONArray(Utils.param_dados);
                            int x =0;
                            int p=0;
                            for (int i = 0; i < arr.length(); i++) {
                                JSONObject obj = arr.getJSONObject(i);
                                x= x + obj.getInt("habitantes");
                                JSONArray arr2 = response.getJSONArray("monumentos");
                                for (int t = 0; t < arr2.length(); t++) {
                                    p = p + 1;
                                }
                               // Toast.makeText(MainActivity.this, obj.getString("nome") + ";" + obj.getString("morada") + ";" + obj.getString("idade"), Toast.LENGTH_SHORT).show();


                            }
                            Toast.makeText(MainActivity.this, "habitantes "+x, Toast.LENGTH_SHORT).show();
                            Toast.makeText(MainActivity.this, "monumentos"+p, Toast.LENGTH_SHORT).show();






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
     */





}
