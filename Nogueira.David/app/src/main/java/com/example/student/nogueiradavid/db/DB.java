package com.example.student.nogueiradavid.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by david on 30/03/17.
 */
public class DB extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 4;
    public static final String DATABASE_NAME = "monumentos.db";
    private static final String TABLE_LABELS = "tipo";
    public DB (Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    public void onCreate(SQLiteDatabase db){

        db.execSQL(Contrato.Monumento.SQL_CREATE_ENTRIES);
        db.execSQL(Contrato.Tipo.SQL_CREATE_ENTRIES);





        db.execSQL("insert into " + Contrato.Tipo.TABLE_NAME + " values (1, 'castelo');");
        db.execSQL("insert into " + Contrato.Tipo.TABLE_NAME + " values (2, 'museu');");




        db.execSQL("insert into " + Contrato.Monumento.TABLE_NAME + " values (1, 'alto monumento', '41.690573', '-8.836768', 2);");
        db.execSQL("insert into " + Contrato.Monumento.TABLE_NAME + " values (2, 'muito lindo', '41.692928', '-8.832970', 1);");
        db.execSQL("insert into " + Contrato.Monumento.TABLE_NAME + " values (3, 'remoto, quase invisivel', '41.691670', '-8.828689', 1);");
        db.execSQL("insert into " + Contrato.Monumento.TABLE_NAME + " values (4, 'caro, apenas para alguns', '41.696311', '-8.838773', 2);");
        db.execSQL("insert into " + Contrato.Monumento.TABLE_NAME + " values (5, 'apenas para turistas estrangeiros', '41.685693', '-8.844771', 2);");


    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){


      //  db.execSQL(Contrato.<nome da nova tabela>.SQL_CREATE_ENTRIES);


    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion){
        onUpgrade(db, oldVersion, newVersion);
    }





    public List<String> getAllLabels(){

        List<String> labels = new ArrayList<String>();

        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_LABELS;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                labels.add(cursor.getString(1));
            } while (cursor.moveToNext());
        }

        // closing connection
        cursor.close();
        db.close();

        // returning lables
        return labels;
    }


}
