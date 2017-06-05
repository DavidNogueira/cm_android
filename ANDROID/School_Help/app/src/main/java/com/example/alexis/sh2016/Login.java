package com.example.alexis.sh2016;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;



public class Login extends AppCompatActivity {


    private EditText username;
    private EditText password;
    private Button entrar;
    private String xd;


    private final static String STORECHECKa="wqcheck1.txt";
    private final static String STORECHECKd="wqcheck2.txt";

    private final static String STORELOGINa="wqlogin1.txt";
    private final static String STORELOGINd="wqlogin2.txt";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        username = (EditText) findViewById(R.id.editText2);
        password = (EditText) findViewById(R.id.editText3);
        entrar = (Button) findViewById(R.id.button8);


        readFileInEditor3();
        readFileInEditor4();



        entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(username.getText().toString().equals("alexissousa") && password.getText().toString().equals("w")){



                    try {
                        OutputStreamWriter out= new OutputStreamWriter(openFileOutput(STORELOGINa, 0));
                        out.write("1");
                        out.close();
                        //Toast.makeText(getApplicationContext(),"The contents are saved in the file.", Toast.LENGTH_LONG).show();
                    }
                    catch (Throwable t) {
                        Toast.makeText(getApplicationContext(),"Exception: "+t.toString(), Toast.LENGTH_LONG).show();
                    }

                    readFileInEditor();

                }else if (username.getText().toString().equals("davidnogueira ") && password.getText().toString().equals("w")){

                    try {
                        OutputStreamWriter out= new OutputStreamWriter(openFileOutput(STORELOGINd, 0));
                        out.write("1");
                        out.close();
                        //Toast.makeText(getApplicationContext(),"The contents are saved in the file.", Toast.LENGTH_LONG).show();
                    }
                    catch (Throwable t) {
                        Toast.makeText(getApplicationContext(),"Exception: "+t.toString(), Toast.LENGTH_LONG).show();
                    }

                    readFileInEditor2();


                /*}else if (username.getText().toString().equals("Pedro Faria ") && password.getText().toString().equals("w")){

                    try {
                        OutputStreamWriter out= new OutputStreamWriter(openFileOutput(STORELOGINd, 0));
                        out.write("1");
                        out.close();
                        //Toast.makeText(getApplicationContext(),"The contents are saved in the file.", Toast.LENGTH_LONG).show();
                    }
                    catch (Throwable t) {
                        Toast.makeText(getApplicationContext(),"Exception: "+t.toString(), Toast.LENGTH_LONG).show();
                    }

                    readFileInEditor2();
*/
                }else{
                    Toast.makeText(getApplicationContext(),"Username/Password Incorreta", Toast.LENGTH_LONG).show();

                }

            }
        });


    }










    public void readFileInEditor() {

        try {

            InputStream in = this.openFileInput(STORECHECKa);

            if (in != null) {
                InputStreamReader tmp=new InputStreamReader(in);
                BufferedReader reader=new BufferedReader(tmp);
                String str;
                StringBuilder buf=new StringBuilder();

                while ((str = reader.readLine()) != null) {

                    buf.append(str);
                }
                in.close();
                xd = buf.toString();
                if(xd.equals("1")){
                    finish();
                    Intent intent = new Intent(Login.this, Tabbed.class);
                    startActivityForResult(intent, 1);
                }

            }
        }

        catch (java.io.FileNotFoundException e) {
            // that's OK, we probably haven't created it yet
            finish();
            Intent intent = new Intent(Login.this, MainActivity.class);
            startActivityForResult(intent, 1);
        }

        catch (Throwable t) {
            Toast.makeText(this, "Exception: " + t.toString(), Toast.LENGTH_LONG).show();

        }

    }


    public void readFileInEditor2() {

        try {

            InputStream in = this.openFileInput(STORECHECKd);

            if (in != null) {
                InputStreamReader tmp=new InputStreamReader(in);
                BufferedReader reader=new BufferedReader(tmp);
                String str;
                StringBuilder buf=new StringBuilder();

                while ((str = reader.readLine()) != null) {

                    buf.append(str);
                }
                in.close();
                xd = buf.toString();
                if(xd.equals("1")){
                    finish();
                    Intent intent = new Intent(Login.this, Tabbed.class);
                    startActivityForResult(intent, 1);
                }


            }

        }

        catch (java.io.FileNotFoundException e) {
            // that's OK, we probably haven't created it yet
            finish();
            Intent intent = new Intent(Login.this, MainActivity.class);
            startActivityForResult(intent, 1);
        }

        catch (Throwable t) {
            Toast.makeText(this, "Exception: " + t.toString(), Toast.LENGTH_LONG).show();

        }

    }


    public void readFileInEditor3() {

        try {

            InputStream in = this.openFileInput(STORELOGINa);

            if (in != null) {
                InputStreamReader tmp=new InputStreamReader(in);
                BufferedReader reader=new BufferedReader(tmp);
                String str;
                StringBuilder buf=new StringBuilder();

                while ((str = reader.readLine()) != null) {

                    buf.append(str);
                }
                in.close();
                xd = buf.toString();
                if(xd.equals("1")){
                    finish();
                    Intent intent = new Intent(Login.this, Tabbed.class);
                    startActivityForResult(intent, 1);
                }
            }
        }

        catch (java.io.FileNotFoundException e) {
            // that's OK, we probably haven't created it yet
        }

        catch (Throwable t) {
            Toast.makeText(this, "Exception: " + t.toString(), Toast.LENGTH_LONG).show();

        }


    }



    public void readFileInEditor4() {

        try {

            InputStream in = this.openFileInput(STORELOGINd);

            if (in != null) {
                InputStreamReader tmp=new InputStreamReader(in);
                BufferedReader reader=new BufferedReader(tmp);
                String str;
                StringBuilder buf=new StringBuilder();

                while ((str = reader.readLine()) != null) {

                    buf.append(str);
                }
                in.close();
                xd = buf.toString();
                if(xd.equals("1")){
                    finish();
                    Intent intent = new Intent(Login.this, Tabbed.class);
                    startActivityForResult(intent, 1);
                }
            }
        }

        catch (java.io.FileNotFoundException e) {
            // that's OK, we probably haven't created it yet
        }

        catch (Throwable t) {
            Toast.makeText(this, "Exception: " + t.toString(), Toast.LENGTH_LONG).show();

        }


    }





}