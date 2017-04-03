package com.example.student.ws_volley_simples;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;


import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main);
    }


    public void click(View v) {

       String url = "http://192.168.2.158:8888/ws1.php?nome=david&email=lolita";
       // String url = "http://ahead.ycorn.pt/saraws/ws1.php?nome=david&email=lolita";



        JsonObjectRequest jsObjRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                           // ((TextView) findViewById(R.id.texto)).setText(response.getString(Utils.param_status));
                            ((TextView) findViewById(R.id.texto)).setText(response.getString("status"));

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





    public void clickbotao1(View v) {

        String url = "http://192.168.2.158:8888/ws2.php";
//         String url = "http://ahead.ycorn.pt/saraws/ws2.php";
        //JSONObject jsonBody = new JSONObject();



        StringRequest stringRequest = new StringRequest
                (Request.Method.POST, url, new Response.Listener<String>(){

                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonoutput = new JSONObject(response);
                            ((TextView) findViewById(R.id.texto)).setText(jsonoutput.getString(Utils.param_status));

                        } catch(JSONException ex){}
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        ((TextView) findViewById(R.id.texto)).setText(Utils.output_erro);
                    }


                }){

            @Override
            protected Map<String, String> getParams(){
                Map<String, String> params = new HashMap<>();
                params.put("nome", "Alexis");
                params.put("email", "asdfghr");
                return params;
            }
            @Override
            public Map<String,String> getHeaders() throws AuthFailureError{
                Map<String,String> params = new HashMap<>();
                params.put("Content-Type", "application/x-www-form-urlencoded");
                return params;
            }
        };

        // Access the RequestQueue through your singleton class.
        MySingleton.getInstance(this).addToRequestQueue(stringRequest);
    }



    public void clickbotao2(View v) {

        // String url = "http://ahead.ycorn.pt/saraws/ws3.php?nome=sara&email=sara.paiva@estg.ipvc.pt";
         String url = "http://192.168.2.158:8888/ws3.php?nome=sara&email=sara.paiva@estg.ipvc.pt";

        JsonObjectRequest jsObjRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            ((TextView) findViewById(R.id.texto)).setText(response.getString(Utils.param_status));
                            JSONArray arr = response.getJSONArray(Utils.param_dados);
                            for (int i = 0; i < arr.length(); i++) {
                                JSONObject obj = arr.getJSONObject(i);
                                Toast.makeText(MainActivity.this, obj.getString("nome") + ";" +
                                        obj.getString("morada") + ";" + obj.getString("idade"), Toast.LENGTH_SHORT).show();
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
