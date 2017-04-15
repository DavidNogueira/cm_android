package com.example.student.studenttool;

import android.app.Dialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.student.studenttool.entities.Ementa;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Frag3 extends Fragment{


    private static final String ARG_SECTION_NUMBER = "section_number";



    private TextView saldoAcivity;
    private TextView saldo;
    private String stredittext;
    private Double tot ;
    private Double tot2 = 0.0;
    private Button btn;
    private Dialog dialog;

    public TextView bla;

    public String nome_uti;

    Button[] bt = new Button[30];
    int num=0;

    int x, t;
    int i =0;
    private final static String STORETEXT="storetext8.txt";



    public Frag3(){

    }

    public static Frag3 newInstance(){

        Frag3 fragment = new Frag3();
        return fragment;

    }
    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){


        View rootView = inflater.inflate(R.layout.frag3, container, false);

        bt[0] = (Button)rootView.findViewById(R.id.button1);
        bt[1] = (Button)rootView.findViewById(R.id.button2);
        bt[2] = (Button)rootView.findViewById(R.id.button3);
        bt[3] = (Button)rootView.findViewById(R.id.button4);
        bt[4] = (Button)rootView.findViewById(R.id.button5);
        bt[5] = (Button)rootView.findViewById(R.id.button6);
        bt[6] = (Button)rootView.findViewById(R.id.button7);
        bt[7] = (Button)rootView.findViewById(R.id.button8);
        bt[8] = (Button)rootView.findViewById(R.id.button9);
        bt[9] = (Button)rootView.findViewById(R.id.button10);
        bt[10] = (Button)rootView.findViewById(R.id.button11);
        bt[11] = (Button)rootView.findViewById(R.id.button12);
        bt[12] = (Button)rootView.findViewById(R.id.button13);
        bt[13] = (Button)rootView.findViewById(R.id.button14);
        bt[14] = (Button)rootView.findViewById(R.id.button15);
        bt[15] = (Button)rootView.findViewById(R.id.button16);
        bt[16] = (Button)rootView.findViewById(R.id.button17);
        bt[17] = (Button)rootView.findViewById(R.id.button18);
        bt[18] = (Button)rootView.findViewById(R.id.button19);
        bt[19] = (Button)rootView.findViewById(R.id.button20);
        bt[20] = (Button)rootView.findViewById(R.id.button21);
        bt[21] = (Button)rootView.findViewById(R.id.button22);
        bt[22] = (Button)rootView.findViewById(R.id.button23);
        bt[23] = (Button)rootView.findViewById(R.id.button24);
        bt[24] = (Button)rootView.findViewById(R.id.button25);
        bt[25] = (Button)rootView.findViewById(R.id.button26);
        bt[26] = (Button)rootView.findViewById(R.id.button27);
        bt[27] = (Button)rootView.findViewById(R.id.button28);
        bt[28] = (Button)rootView.findViewById(R.id.button29);
        bt[29] = (Button)rootView.findViewById(R.id.button30);








        bt[0].setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                naVenda(0);
                return true;
            }
        });
        bt[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                naCompra(0);
            }
        });

        bt[1].setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                naVenda(1);
                return true;
            }
        });
        bt[1].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                naCompra(1);
            }
        });

        bt[2].setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                naVenda(2);
                return true;
            }
        });
        bt[2].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                naCompra(2);
            }
        });

        bt[3].setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                naVenda(3);
                return true;
            }
        });
        bt[3].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                naCompra(3);
            }
        });

        bt[4].setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                naVenda(4);
                return true;
            }
        });
        bt[4].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                naCompra(4);
            }
        });

        bt[5].setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                naVenda(5);
                return true;
            }
        });
        bt[5].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                naCompra(5);
            }
        });

        bt[6].setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                naVenda(6);
                return true;
            }
        });
        bt[6].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                naCompra(6);
            }
        });

        bt[7].setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                naVenda(7);
                return true;
            }
        });
        bt[7].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                naCompra(7);
            }
        });

        bt[8].setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                naVenda(8);
                return true;
            }
        });
        bt[8].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                naCompra(8);
            }
        });

        bt[9].setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                naVenda(9);
                return true;
            }
        });
        bt[9].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                naCompra(9);
            }
        });

        bt[10].setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                naVenda(10);
                return true;
            }
        });
        bt[10].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                naCompra(10);
            }
        });

        bt[11].setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                naVenda(11);
                return true;
            }
        });
        bt[11].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                naCompra(11);
            }
        });

        bt[12].setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                naVenda(12);
                return true;
            }
        });
        bt[12].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                naCompra(12);
            }
        });

        bt[13].setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                naVenda(13);
                return true;
            }
        });
        bt[13].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                naCompra(13);
            }
        });

        bt[14].setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                naVenda(14);
                return true;
            }
        });
        bt[14].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                naCompra(14);
            }
        });

        bt[15].setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                naVenda(15);
                return true;
            }
        });
        bt[15].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                naCompra(15);
            }
        });

        bt[16].setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                naVenda(16);
                return true;
            }
        });
        bt[16].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                naCompra(16);
            }
        });

        bt[17].setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                naVenda(17);
                return true;
            }
        });
        bt[17].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                naCompra(17);
            }
        });

        bt[18].setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                naVenda(18);
                return true;
            }
        });
        bt[18].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                naCompra(18);
            }
        });

        bt[19].setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                naVenda(19);
                return true;
            }
        });
        bt[19].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                naCompra(19);
            }
        });

        bt[20].setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                naVenda(20);
                return true;
            }
        });
        bt[20].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                naCompra(20);
            }
        });

        bt[21].setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                naVenda(21);
                return true;
            }
        });
        bt[21].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                naCompra(21);
            }
        });

        bt[22].setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                naVenda(22);
                return true;
            }
        });
        bt[22].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                naCompra(22);
            }
        });

        bt[23].setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                naVenda(23);
                return true;
            }
        });
        bt[23].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                naCompra(23);
            }
        });

        bt[24].setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                naVenda(24);
                return true;
            }
        });
        bt[24].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                naCompra(24);
            }
        });

        bt[25].setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                naVenda(25);
                return true;
            }
        });
        bt[25].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                naCompra(25);
            }
        });

        bt[26].setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                naVenda(26);
                return true;
            }
        });
        bt[26].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                naCompra(26);
            }
        });

        bt[27].setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                naVenda(27);
                return true;
            }
        });
        bt[27].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                naCompra(27);
            }
        });

        bt[28].setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                naVenda(28);
                return true;
            }
        });
        bt[28].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                naCompra(28);
            }
        });

        bt[29].setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                naVenda(29);
                return true;
            }
        });
        bt[29].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                naCompra(29);
            }
        });








        saldo = (TextView) rootView.findViewById(R.id.textView88);

        saldoAcivity = (TextView) rootView.findViewById(R.id.textView86);
        saldoAcivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                //web service para descontar saldo
            }
        });



        //WS
        SharedPreferences pref = this.getActivity().getSharedPreferences(getString(R.string.shared_pref_1) ,Context.MODE_PRIVATE);
        nome_uti = pref.getString(Utils.NOME, null);
        bla = (TextView) rootView.findViewById(R.id.textView88);
        atualizaSaldo(nome_uti);
       // Toast.makeText(getActivity().getApplicationContext(), Utils.NOME + " " + nome_uti, Toast.LENGTH_SHORT).show();

        atualizaEmenta();




        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_three, container, false);
        return rootView;

    }




    public void atualizaSaldo(String nome){
        String url = "http://192.168.2.149:8888/cmsaldo.php?nome="+nome+"";

        Toast.makeText(getActivity().getApplicationContext(), nome, Toast.LENGTH_SHORT).show();


        JsonObjectRequest jsObjRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            // ((TextView) findViewById(R.id.texto)).setText(response.getString(Utils.param_status));
                            bla.setText(response.getString("status"));
                            //Toast.makeText(MainActivity.this, response.getString("status"), Toast.LENGTH_SHORT).show();



                        } catch(JSONException ex){}
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        bla.setText(Utils.output_erro);
                    }
                });

        // Access the RequestQueue through your singleton class.
        MySingleton.getInstance(this.getContext()).addToRequestQueue(jsObjRequest);


}


    public void atualizaEmenta(){


        String url = "http://192.168.2.149:8888/cmementa.php";


        JsonObjectRequest jsObjRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        try {


                            //((TextView) findViewById(R.id.texto)).setText(response.getString(Utils.param_status));
                            JSONArray arr = response.getJSONArray(Utils.param_dados);

                            for (int i = 0; i < arr.length(); i++) {
                                JSONObject obj = arr.getJSONObject(i);
                                // Toast.makeText(WS.this, obj.getString("nome") + ";" + obj.getString("morada") + ";" + obj.getString("idade"), Toast.LENGTH_SHORT).show();

                               // arrayItems.add(obj.getString("nome"));

                              //  arrayPessoa.add(new Pessoa (obj.getString("nome"), obj.getString("morada"), obj.getInt("idade")));

                                bt[i].setText(obj.getString("nome"));


                            }






                        } catch(JSONException ex){}
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //((TextView) findViewById(R.id.texto)).setText(Utils.output_erro);
                        Toast.makeText(getActivity().getApplicationContext(), "deu erro", Toast.LENGTH_SHORT).show();

                    }
                });

        // Access the RequestQueue through your singleton class.
        MySingleton.getInstance(this.getContext()).addToRequestQueue(jsObjRequest);



    }




/*

    public void naVenda(final int k){
        int tt = 0;
        int hh;

        tt = k + 33;
        hh=Integer.parseInt(getData(tt));
        if(hh>0 ){
            dialog = new Dialog(getActivity());
            dialog.setTitle("VENDER SENHA");
            dialog.setContentView(R.layout.vender_senha);
            dialog.show();
            Button okButton = (Button) dialog.findViewById(R.id.button83);
            Button cancelButton = (Button) dialog.findViewById(R.id.button84);
            okButton.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    dialog.cancel();
                    num = k + 33;
                    updateTable2();


                    try {
                        OutputStreamWriter out = new OutputStreamWriter(getActivity().openFileOutput(STORETEXT, 0));

                        tot2 = 2.4 + Double.parseDouble(saldo.getText().toString());
                        out.write(String.valueOf(tot2));
                        out.close();
                        //Toast.makeText(getActivity().getApplicationContext(),"The contents are saved in the file.", Toast.LENGTH_LONG).show();
                        readFileInEditor();
                        bt[k].setBackgroundColor(0xffff8800);


                    }
                    catch (Throwable t) {
                        // Toast.makeText(getActivity().getApplicationContext(),"Exception: "+t.toString(), Toast.LENGTH_LONG).show();
                    }


                }
            });
            cancelButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.cancel();
                }
            });
        }


    }




    public void naCompra(final int k){
        int tt = 0;
        int hh;
        double qq;
        tt = k + 33;
        hh=Integer.parseInt(getData(tt));
        qq=Double.parseDouble(saldo.getText().toString());
        if(hh==0 && qq>=2.4) {
            dialog = new Dialog(getActivity());
            dialog.setTitle("COMPRAR SENHA");
            dialog.setContentView(R.layout.comprar_senha);
            dialog.show();
            Button okButton = (Button) dialog.findViewById(R.id.button81);
            Button cancelButton = (Button) dialog.findViewById(R.id.button82);
            okButton.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    dialog.cancel();
                    num = k + 33;
                    updateTable();
                    try {
                        OutputStreamWriter out = new OutputStreamWriter(getActivity().openFileOutput(STORETEXT, 0));

                        tot2 = Double.parseDouble(saldo.getText().toString()) - 2.4;
                        out.write(String.valueOf(tot2));
                        out.close();
                        // Toast.makeText(getActivity().getApplicationContext(), "The contents are saved in the file.", Toast.LENGTH_LONG).show();
                        readFileInEditor();
                        bt[k].setBackgroundColor(Color.RED);
                    }
                    catch (Throwable t) {
                        //  Toast.makeText(getActivity().getApplicationContext(),"Exception: "+t.toString(), Toast.LENGTH_LONG).show();
                    }
                }
            });
            cancelButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.cancel();
                }
            });
        }

    }

*/




    public void naCompra(final int k){

        int t =k+1;
    }
    public void naVenda(final int k){

        int t =k+1;
    }


}
