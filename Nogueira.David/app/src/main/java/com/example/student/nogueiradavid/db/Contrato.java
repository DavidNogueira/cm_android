package com.example.student.nogueiradavid.db;

import android.provider.BaseColumns;




import android.test.suitebuilder.annotation.Suppress;

/**
 * Created by david on 30/03/17.
 */
public class Contrato {

    private static final String TEXT_TYPE = " TEXT ";
    private static final String INT_TYPE = " INTEGER ";

    public Contrato(){

    }

    public static abstract class Monumento implements BaseColumns {

        public static final String TABLE_NAME = "monumento";

        //public static final String ID_P = "idp";


        public static final String COLUMN_DESCR = "descr";
        public static final String COLUMN_LATITUDE = "latitude";
        public static final String COLUMN_LONGITUDE = "longitude";
        public static final String COLUMN_TIPO = "tipo";


        public static final String[] PROJECTION ={Monumento._ID, Monumento.COLUMN_DESCR, Monumento.COLUMN_LATITUDE, Monumento.COLUMN_LONGITUDE, Monumento.COLUMN_TIPO};

        //  public static final String[] PROJECTION2 ={Pessoa.COLUMN_NOME, Pessoa.COLUMN_IDADE, Cidade.COLUMN_NOME};


        public static final String SQL_CREATE_ENTRIES =
                "CREATE TABLE "+ Monumento.TABLE_NAME + "("+
                        Monumento._ID + INT_TYPE + " PRIMARY KEY,"+
                        Monumento.COLUMN_DESCR + TEXT_TYPE + ","+
                        Monumento.COLUMN_LATITUDE + TEXT_TYPE + ","+
                        Monumento.COLUMN_LONGITUDE + TEXT_TYPE + ","+
                        Monumento.COLUMN_TIPO + INT_TYPE+ " REFERENCES " +
                        Tipo.TABLE_NAME + "("+Tipo._ID +"));";

        public static final String SQL_DROP_ENTRIES =
                "DROP TABLE "+ Monumento.TABLE_NAME+ ";";

    }

    //_________________________--------------_____----____---__--__--__-__--__--_--_____-------___------


    public static abstract class Tipo implements BaseColumns{

        public static final String TABLE_NAME = "tipo";

        //public static final String ID_C = "idc";

        public static final String COLUMN_DESCR = "descr";

        public static final String[] PROJECTION ={Tipo._ID, Tipo.COLUMN_DESCR};

        public static final String SQL_CREATE_ENTRIES =
                "CREATE TABLE "+ Tipo.TABLE_NAME + "("+
                        Tipo._ID + INT_TYPE + " PRIMARY KEY,"+
                        Tipo.COLUMN_DESCR + TEXT_TYPE + ");";

        public static final String SQL_DROP_ENTRIES =
                "DROP TABLE "+ Tipo.TABLE_NAME + ";";

    }

}
