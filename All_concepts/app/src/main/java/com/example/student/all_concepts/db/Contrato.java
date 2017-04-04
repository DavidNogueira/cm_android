package com.example.student.all_concepts.db;

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

    public static abstract class Pessoa implements BaseColumns {

        public static final String TABLE_NAME = "pessoa";

        //public static final String ID_P = "idp";


        public static final String COLUMN_NOME = "nome";
        public static final String COLUMN_IDADE = "idade";
        public static final String COLUMN_ID_CIDADE = "id_cidade";


        public static final String[] PROJECTION ={Pessoa._ID, Pessoa.COLUMN_NOME, Pessoa.COLUMN_IDADE, Pessoa.COLUMN_ID_CIDADE};

        //  public static final String[] PROJECTION2 ={Pessoa.COLUMN_NOME, Pessoa.COLUMN_IDADE, Cidade.COLUMN_NOME};


        public static final String SQL_CREATE_ENTRIES =
                "CREATE TABLE "+ Pessoa.TABLE_NAME + "("+
                        Pessoa._ID + INT_TYPE + " PRIMARY KEY,"+
                        Pessoa.COLUMN_NOME + TEXT_TYPE + ","+
                        Pessoa.COLUMN_IDADE + INT_TYPE + ","+
                        Pessoa.COLUMN_ID_CIDADE + INT_TYPE+ " REFERENCES " +
                        Cidade.TABLE_NAME + "("+Cidade._ID +"));";

        public static final String SQL_DROP_ENTRIES =
                "DROP TABLE "+ Pessoa.TABLE_NAME+ ";";

    }

    //_________________________--------------_____----____---__--__--__-__--__--_--_____-------___------


    public static abstract class Cidade implements BaseColumns{

        public static final String TABLE_NAME = "cidade";

        //public static final String ID_C = "idc";

        public static final String COLUMN_NOME = "nomec";

        public static final String[] PROJECTION ={Cidade._ID, Cidade.COLUMN_NOME};

        public static final String SQL_CREATE_ENTRIES =
                "CREATE TABLE "+ Cidade.TABLE_NAME + "("+
                        Cidade._ID + INT_TYPE + " PRIMARY KEY,"+
                        Cidade.COLUMN_NOME + TEXT_TYPE + ");";

        public static final String SQL_DROP_ENTRIES =
                "DROP TABLE "+ Cidade.TABLE_NAME + ";";

    }

}
