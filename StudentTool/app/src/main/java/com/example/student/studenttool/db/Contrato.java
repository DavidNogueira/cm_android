package com.example.student.studenttool.db;

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

    //_________________________--------------_____----____---__--__--__-__--__--_--_____-------___------

    public static abstract class Associa implements BaseColumns {

        public static final String TABLE_NAME = "associa";

        public static final String COLUMN_ID_CURSO = "id_curso";
        public static final String COLUMN_ID_DISCIPLINA = "id_disciplina";
        public static final String COLUMN_CHECK = "check";


        public static final String[] PROJECTION ={Associa._ID, Associa.COLUMN_ID_CURSO,
                Associa.COLUMN_ID_DISCIPLINA, Associa.COLUMN_CHECK};

        public static final String SQL_CREATE_ENTRIES =
                "CREATE TABLE "+ Associa.TABLE_NAME + "("+
                        Associa._ID + INT_TYPE + ","+
                        Associa.COLUMN_ID_CURSO + INT_TYPE + " REFERENCES," +
                        Curso.TABLE_NAME + "("+Curso._ID +") " +
                        Associa.COLUMN_ID_DISCIPLINA + INT_TYPE + " REFERENCES," +
                        Disciplina.TABLE_NAME + "("+Disciplina._ID +") " +
                        Associa.COLUMN_CHECK + INT_TYPE + "" +
                        "PRIMARY KEY ("+Associa.COLUMN_ID_CURSO+" , "+Associa.COLUMN_ID_DISCIPLINA+
                        "));";

        public static final String SQL_DROP_ENTRIES =
                "DROP TABLE "+ Associa.TABLE_NAME+ ";";

    }




    //_________________________--------------_____----____---__--__--__-__--__--_--_____-------___------



    public static abstract class Curso implements BaseColumns {

        public static final String TABLE_NAME = "curso";

        public static final String COLUMN_NOME_CURSO = "nomec";

        public static final String[] PROJECTION ={Curso._ID, Curso.COLUMN_NOME_CURSO};

        public static final String SQL_CREATE_ENTRIES =
                "CREATE TABLE "+ Curso.TABLE_NAME + "("+
                        Curso._ID + INT_TYPE + " PRIMARY KEY,"+
                        Curso.COLUMN_NOME_CURSO + TEXT_TYPE +");";

        public static final String SQL_DROP_ENTRIES =
                "DROP TABLE "+ Curso.TABLE_NAME+ ";";

    }



    //_________________________--------------_____----____---__--__--__-__--__--_--_____-------___------



    public static abstract class Disciplina implements BaseColumns {

        public static final String TABLE_NAME = "disciplina";

        public static final String COLUMN_NOME_DISCIPLINA = "nomed";

        public static final String[] PROJECTION ={Disciplina._ID, Disciplina.COLUMN_NOME_DISCIPLINA};

        public static final String SQL_CREATE_ENTRIES =
                "CREATE TABLE "+ Disciplina.TABLE_NAME + "("+
                        Disciplina._ID + INT_TYPE + " PRIMARY KEY,"+
                        Disciplina.COLUMN_NOME_DISCIPLINA + TEXT_TYPE +");";

        public static final String SQL_DROP_ENTRIES =
                "DROP TABLE "+ Disciplina.TABLE_NAME+ ";";

    }



}
