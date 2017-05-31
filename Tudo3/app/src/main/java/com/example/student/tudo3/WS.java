package com.example.student.tudo3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.example.student.tudo3.adapters.CustomArrayAdapter;
import com.example.student.tudo3.entities.Pessoa;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class WS extends AppCompatActivity {



    ListView lista;

    public Pessoa p;

    public ArrayList<String> arrayItems;
    public ArrayList<Pessoa> arrayPessoa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_ws);

        registerForContextMenu((ListView) findViewById(R.id.lista2));

        arrayItems = new ArrayList<>();
        arrayPessoa = new ArrayList<>();

        String url = "http://192.168.1.59:8888/ws_lista.php";

        JsonObjectRequest jsObjRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        try {


                            ((TextView) findViewById(R.id.texto)).setText(response.getString(Utils.param_status));
                            JSONArray arr = response.getJSONArray(Utils.param_dados);

                            for (int i = 0; i < arr.length(); i++) {
                                JSONObject obj = arr.getJSONObject(i);
                               // Toast.makeText(WS.this, obj.getString("nome") + ";" + obj.getString("morada") + ";" + obj.getString("idade"), Toast.LENGTH_SHORT).show();

                                arrayItems.add(obj.getString("nome"));

                                arrayPessoa.add(new Pessoa (obj.getString("nome"), obj.getString("morada"), obj.getInt("idade")));

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

        //o de template
        ArrayAdapter<String> itemsAdapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayItems);
        ((ListView) findViewById(R.id.lista)).setAdapter(itemsAdapter);


        //o customizado
        CustomArrayAdapter itemsAdapter2 =
                new CustomArrayAdapter(this, arrayPessoa);
        ((ListView) findViewById(R.id.lista2)).setAdapter(itemsAdapter2);




    }




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
        p = arrayPessoa.get(index);
        switch(item.getItemId()){

            case R.id.post:
                //Toast.makeText(WS.this, "editar "+ p.getNome(), Toast.LENGTH_SHORT).show();
                //WS que retorna IDADE



                String url = "http://192.168.1.59:8888/ws_idade.php";
               // String url = "http://ahead.ycorn.pt/saraws/ws2.php";
                //JSONObject jsonBody = new JSONObject();



                StringRequest stringRequest = new StringRequest
                        (Request.Method.POST, url, new Response.Listener<String>(){

                            @Override
                            public void onResponse(String response) {
                                try {
                                    JSONObject jsonoutput = new JSONObject(response);//parse
                                   // ((TextView) findViewById(R.id.texto)).setText(jsonoutput.getString("idade"));
                                    Toast.makeText(WS.this, jsonoutput.getString("idade"), Toast.LENGTH_SHORT).show();


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
                        params.put("nome", p.getNome());
                        return params;
                    }
                    @Override
                    public Map<String,String> getHeaders() throws AuthFailureError {
                        Map<String,String> params = new HashMap<>();
                        params.put("Content-Type", "application/x-www-form-urlencoded");
                        return params;
                    }
                };

                // Access the RequestQueue through your singleton class.
                MySingleton.getInstance(this).addToRequestQueue(stringRequest);






                return true;

            default: return super.onContextItemSelected(item);
        }
    }

}
