package com.example.student.tudo2.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by david on 30/03/17.
 */
public class DB extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "pessoas.db";

    public DB (Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    public void onCreate(SQLiteDatabase db){

        db.execSQL(Contrato.Cidade.SQL_CREATE_ENTRIES);
        db.execSQL(Contrato.Pessoa.SQL_CREATE_ENTRIES);
/*

        db.execSQL("insert into " + Contrato.Cidade.TABLE_NAME + " values (1, 'Gaia');");
        db.execSQL("insert into " + Contrato.Cidade.TABLE_NAME + " values (2, 'Braga');");
        db.execSQL("insert into " + Contrato.Cidade.TABLE_NAME + " values (3, 'Monção');");
        db.execSQL("insert into " + Contrato.Cidade.TABLE_NAME + " values (4, 'Viana');");
        db.execSQL("insert into " + Contrato.Cidade.TABLE_NAME + " values (5, 'Estriclapissalandia');");


        db.execSQL("insert into " + Contrato.Pessoa.TABLE_NAME + " values (1, 'David', 78, 2);");
        db.execSQL("insert into " + Contrato.Pessoa.TABLE_NAME + " values (2, 'Alexis', 33, 1);");
        db.execSQL("insert into " + Contrato.Pessoa.TABLE_NAME + " values (3, 'Renato', 9, 5);");
        db.execSQL("insert into " + Contrato.Pessoa.TABLE_NAME + " values (4, 'Picapau Amarelo', 43, 3);");
        db.execSQL("insert into " + Contrato.Pessoa.TABLE_NAME + " values (5, 'Prostata na cuecaaaaaaaaa', 12, 2);");
        db.execSQL("insert into " + Contrato.Pessoa.TABLE_NAME + " values (6, 'Shuarsnegger', 300, 5);");
*/





        db.execSQL("insert into " + Contrato.Cidade.TABLE_NAME + " values (1, 'Gaia');");
        db.execSQL("insert into " + Contrato.Cidade.TABLE_NAME + " values (2, 'Braga');");
        db.execSQL("insert into " + Contrato.Cidade.TABLE_NAME + " values (3, 'Monção');");
        db.execSQL("insert into " + Contrato.Cidade.TABLE_NAME + " values (4, 'Viana');");
        db.execSQL("insert into " + Contrato.Cidade.TABLE_NAME + " values (5, 'Estriclapissalandia');");


       // db.execSQL("insert into " + Contrato.Pessoa.TABLE_NAME + " ("+Contrato.Pessoa.COLUMN_NOME +","
        // + Contrato.Pessoa.COLUMN_IDADE+","+Contrato.Pessoa.COLUMN_ID_CIDADE+") values ('David', 78, 2);");

        db.execSQL("insert into " + Contrato.Pessoa.TABLE_NAME + " values (1, 'David', 78, 2);");
        db.execSQL("insert into " + Contrato.Pessoa.TABLE_NAME + " values (2, 'Alexis', 33, 1);");
        db.execSQL("insert into " + Contrato.Pessoa.TABLE_NAME + " values (3, 'Renato', 9, 5);");
        db.execSQL("insert into " + Contrato.Pessoa.TABLE_NAME + " values (4, 'Picapau Amarelo', 43, 3);");
        db.execSQL("insert into " + Contrato.Pessoa.TABLE_NAME + " values (5, 'Robocop', 12, 2);");
        db.execSQL("insert into " + Contrato.Pessoa.TABLE_NAME + " values (6, 'Shuarsnegger', 300, 5);");

    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL(Contrato.Pessoa.SQL_DROP_ENTRIES);
        db.execSQL(Contrato.Cidade.SQL_DROP_ENTRIES);
        onCreate(db);
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion){
        onUpgrade(db, oldVersion, newVersion);
    }

}
