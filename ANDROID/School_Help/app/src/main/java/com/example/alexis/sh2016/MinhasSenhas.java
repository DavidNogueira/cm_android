package com.example.alexis.sh2016;

import android.content.ContentValues;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MinhasSenhas extends AppCompatActivity {



    int num;
    int i;
    int nao=0;

    String[] foods = new String[30];

    private TextView txt29;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_minhas_senhas);


        txt29 = (TextView) findViewById(R.id.textView29);

        for(i = 33; i<64; i++) {

            if(getData(i).equalsIgnoreCase(null)){
                num=i;
                nao=1;
                updateTable();

            }
            if(getData(i).equalsIgnoreCase("1")){
                foods[0]= "ola";
            }

        }

        txt29.setText(foods[0]);





    }





    public  void initializeDB(){
        MyTable user = new MyTable();
        String[] tableCreateArray = { user.getDatabaseCreateQuery() };
        dbOperation operation = new dbOperation(this,tableCreateArray);
        operation.open();
        operation.close();
    }

    public  void saveData(){
        int m;
        dbOperation operationObj = new dbOperation(this);
        operationObj.open();
        MyTable Fields = new MyTable();
        ContentValues initialValues = new ContentValues();
        for(int x = 33; x<64; x++) {
            m = Integer.parseInt(getData(x));
            m = m + num;
            initialValues.put(Fields.getScore(), m);
            operationObj.insertTableData(Fields.getTableName(), initialValues);
        }
        operationObj.close();
    }


    /* GET THE DATA FROM DB ,PARAMS - FILENAME -> GET THE DATA */
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


    public void updateTable(){
        int m;
        dbOperation operationObj = new dbOperation(this);
        operationObj.open();
        MyTable Fields = new MyTable();
        //check for the value to update if no value then insert.
        for(int x = 33; x<64; x++) {
            String file_ = getData(x+1);
            if(file_.equals("error")){
                saveData();
            }else{
                String condition = Fields.getID() + " = '" +x+ "'";
                ContentValues initialValues = new ContentValues();
                m = Integer.parseInt(getData(x));
                m = m + num;
                if(nao==1){
                    m=0;
                    nao=0;
                }
                initialValues.put(Fields.getScore(), m);
                operationObj.updateTable(Fields.getTableName(), initialValues, condition);
            }
        }

        operationObj.close();
    }




}