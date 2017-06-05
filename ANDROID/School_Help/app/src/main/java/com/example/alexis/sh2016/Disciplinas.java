package com.example.alexis.sh2016;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.CompoundButton.OnCheckedChangeListener;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Disciplinas extends Activity {

    public CheckBox[] ch = new CheckBox[32];
    Button save;
    int checked = 0;
    int[] check=new int[32];

    private String xd1;
    private String xd2;


    private final static String STORECHECKa="wqcheck1.txt";
    private final static String STORECHECKd="wqcheck2.txt";

    private final static String STORELOGINa="wqlogin1.txt";
    private final static String STORELOGINd="wqlogin2.txt";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disciplinas);
        initializeDB();

        save = (Button)findViewById(R.id.button2);

        ch[0] = (CheckBox)findViewById(R.id.checkBox);
        ch[1] = (CheckBox)findViewById(R.id.checkBox2);
        ch[2] = (CheckBox)findViewById(R.id.checkBox3);
        ch[3] = (CheckBox)findViewById(R.id.checkBox4);
        ch[4] = (CheckBox)findViewById(R.id.checkBox5);
        ch[5] = (CheckBox)findViewById(R.id.checkBox6);
        ch[6] = (CheckBox)findViewById(R.id.checkBox7);
        ch[7] = (CheckBox)findViewById(R.id.checkBox8);
        ch[8] = (CheckBox)findViewById(R.id.checkBox9);
        ch[9] = (CheckBox)findViewById(R.id.checkBox10);
        ch[10] = (CheckBox)findViewById(R.id.checkBox11);
        ch[11] = (CheckBox)findViewById(R.id.checkBox12);
        ch[12] = (CheckBox)findViewById(R.id.checkBox13);
        ch[13] = (CheckBox)findViewById(R.id.checkBox14);
        ch[14] = (CheckBox)findViewById(R.id.checkBox15);
        ch[15] = (CheckBox)findViewById(R.id.checkBox16);
        ch[16] = (CheckBox)findViewById(R.id.checkBox17);
        ch[17] = (CheckBox)findViewById(R.id.checkBox18);
        ch[18] = (CheckBox)findViewById(R.id.checkBox19);
        ch[19] = (CheckBox)findViewById(R.id.checkBox20);
        ch[20] = (CheckBox)findViewById(R.id.checkBox21);
        ch[21] = (CheckBox)findViewById(R.id.checkBox22);
        ch[22] = (CheckBox)findViewById(R.id.checkBox23);
        ch[23] = (CheckBox)findViewById(R.id.checkBox24);
        ch[24] = (CheckBox)findViewById(R.id.checkBox25);
        ch[25] = (CheckBox)findViewById(R.id.checkBox26);
        ch[26] = (CheckBox)findViewById(R.id.checkBox27);
        ch[27] = (CheckBox)findViewById(R.id.checkBox28);
        ch[28] = (CheckBox)findViewById(R.id.checkBox29);
        ch[29] = (CheckBox)findViewById(R.id.checkBox30);
        ch[30] = (CheckBox)findViewById(R.id.checkBox31);
        ch[31] = (CheckBox)findViewById(R.id.checkBox32);

        for(int i = 0; i<32; i++) {

            if (getData(i+1).equalsIgnoreCase("0"))
                ch[i].setChecked(false);

            else
                ch[i].setChecked(true);


        }

        save.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                updateTable();
               // Toast.makeText(getApplicationContext(), "Saved '" + checked + "' in DB", Toast.LENGTH_SHORT).show();


                readFileInEditor3();
                readFileInEditor4();

                //Toast.makeText(getApplicationContext(), "xd1 '" + xd1 , Toast.LENGTH_SHORT).show();
                //Toast.makeText(getApplicationContext(), "xd2 '" + xd2 , Toast.LENGTH_SHORT).show();

             //   if(xd1.equals("1")){
                    try {

                        OutputStreamWriter out= new OutputStreamWriter(openFileOutput(STORECHECKa, 0));
                        out.write("1");
                        out.close();
                        //Toast.makeText(getApplicationContext(),"The contents are saved in the file.", Toast.LENGTH_LONG).show();
                    }
                    catch (Throwable t) {
                        Toast.makeText(getApplicationContext(),"Exception: "+t.toString(), Toast.LENGTH_LONG).show();
                    }
               // } else if(xd2.equals("1")){
                    try {

                        OutputStreamWriter out= new OutputStreamWriter(openFileOutput(STORECHECKd, 0));
                        out.write("1");
                        out.close();
                        //Toast.makeText(getApplicationContext(),"The contents are saved in the file.", Toast.LENGTH_LONG).show();
                    }
                    catch (Throwable t) {
                        Toast.makeText(getApplicationContext(),"Exception: "+t.toString(), Toast.LENGTH_LONG).show();
                    }
               // }


                Intent intent = new Intent(v.getContext(), Tabbed.class);
                startActivityForResult(intent, 0);
                finish();

            }
        });
    }




    @Override
    public void onBackPressed() {
        finish();
        Intent intent = new Intent(Disciplinas.this, MainActivity.class);
        startActivityForResult(intent, 1);
    }




    public  void initializeDB(){
        MyTable user = new MyTable();
        String[] tableCreateArray = { user.getDatabaseCreateQuery() };
        dbOperation operation = new dbOperation(this,tableCreateArray);
        operation.open();
        operation.close();
    }

    /*** SAVE THE DATA IN DB - GIVE FILENAME AND DATA ***/
    public  void saveData(){
        dbOperation operationObj = new dbOperation(this);
        operationObj.open();
        MyTable Fields = new MyTable();
        ContentValues initialValues = new ContentValues();
        for(int x = 0; x<32; x++) {
            if (ch[x].isChecked()){
                checked = 1;
            }
            if (!ch[x].isChecked()){
                checked = 0;
            }
            initialValues.put(Fields.getScore(), checked);
            operationObj.insertTableData(Fields.getTableName(), initialValues);
        }
        operationObj.close();
    }

    /*** GET THE DATA FROM DB ,PARAMS - FILENAME -> GET THE DATA ***/
    public String getData(int id){
        String _data = "";
        dbOperation operationObj = new dbOperation(this);
        operationObj.open();
        MyTable fields = new MyTable();
        String  condition2 = fields.getID() + " ='" + id + "'";
        String[] dbFields4 = {fields.getScore()};
        Cursor cursor2 =  operationObj.getTableRow(fields.getTableName(),dbFields4,condition2,fields.getID() + " ASC ","1");
        if(cursor2.getCount() > 0)
        {
            cursor2.moveToFirst();
            do{
                _data = cursor2.getString(0);
            }while(cursor2.moveToNext());
        }else{
            _data = "error";
        }
        cursor2.close();
        cursor2.deactivate();
        operationObj.close();
        return _data;
    }
    Button btt;
    /*** SAVE OR UPDATE DB -> GIVE THE FILENAME AND DATA ***/
    public void updateTable(){
        dbOperation operationObj = new dbOperation(this);
        operationObj.open();
        MyTable Fields = new MyTable();
        //check for the value to update if no value then insert.
        for(int x = 0; x<32; x++) {
            String file_ = getData(x+1);
            if(file_.equals("error")){
                saveData();
            }else{
                x=x+1;
                String condition = Fields.getID() + " = '" +x+ "'";
                x=x-1;
                ContentValues initialValues = new ContentValues();
                if(ch[x].isChecked()){
                    checked = 1;
                }

                if(!ch[x].isChecked()){
                    checked = 0;
                }
                initialValues.put(Fields.getScore(), checked);
                operationObj.updateTable(Fields.getTableName(), initialValues, condition);
            }
        }

        operationObj.close();
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
                xd1 = buf.toString();
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
                xd2 = buf.toString();
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