package com.example.student.studenttool.db;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by david on 30/03/17.
 */
public class DB extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 15;
    public static final String DATABASE_NAME = "cm.db";

    private static final String TABLE_LABELS = "curso";



    public DB (Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    public void onCreate(SQLiteDatabase db){

        db.execSQL(Contrato.Disciplina.SQL_CREATE_ENTRIES);
        db.execSQL(Contrato.Curso.SQL_CREATE_ENTRIES);
        db.execSQL(Contrato.Associa.SQL_CREATE_ENTRIES);

        db.execSQL("insert into " + Contrato.Curso.TABLE_NAME + " values (1, 'ENGª INFORMÁTICA');");
        db.execSQL("insert into " + Contrato.Curso.TABLE_NAME + " values (2, 'ENGª DA COMPUTAÇÃO GRÁFICA E MULTIMÉDIA');");


       // db.execSQL("insert into " + Contrato.Pessoa.TABLE_NAME + " ("+Contrato.Pessoa.COLUMN_NOME +","
       //         + Contrato.Pessoa.COLUMN_IDADE+","+Contrato.Pessoa.COLUMN_ID_CIDADE+") values ('David', 78, 2);");

        //EI
        db.execSQL("insert into " + Contrato.Disciplina.TABLE_NAME + " values (1, 'Análise Matemática');");
        db.execSQL("insert into " + Contrato.Disciplina.TABLE_NAME + " values (2, 'Álgebra Linear e Geometria Analítica');");
        db.execSQL("insert into " + Contrato.Disciplina.TABLE_NAME + " values (3, 'Arquitectura e Sistemas de Computadores');");
        db.execSQL("insert into " + Contrato.Disciplina.TABLE_NAME + " values (4, 'Algoritmos e Estruturas de Dados');");
        db.execSQL("insert into " + Contrato.Disciplina.TABLE_NAME + " values (5, 'Matemática Discreta I');");
        db.execSQL("insert into " + Contrato.Disciplina.TABLE_NAME + " values (6, 'Matemática Discreta II');");
        db.execSQL("insert into " + Contrato.Disciplina.TABLE_NAME + " values (7, 'Programação I');");
        db.execSQL("insert into " + Contrato.Disciplina.TABLE_NAME + " values (8, 'Sistemas Operativos');");
        db.execSQL("insert into " + Contrato.Disciplina.TABLE_NAME + " values (9, 'Estatística');");
        db.execSQL("insert into " + Contrato.Disciplina.TABLE_NAME + " values (10, 'Comportamento, Sociedade e Cidadania I');");

        db.execSQL("insert into " + Contrato.Disciplina.TABLE_NAME + " values (11, 'Investigação Operacional');");
        db.execSQL("insert into " + Contrato.Disciplina.TABLE_NAME + " values (12, 'Engenharia de Software I');");
        db.execSQL("insert into " + Contrato.Disciplina.TABLE_NAME + " values (13, 'Programação II');");
        db.execSQL("insert into " + Contrato.Disciplina.TABLE_NAME + " values (14, 'Bases de Dados');");
        db.execSQL("insert into " + Contrato.Disciplina.TABLE_NAME + " values (15, 'Redes Computadores');");
        db.execSQL("insert into " + Contrato.Disciplina.TABLE_NAME + " values (16, 'Projecto I');");
        db.execSQL("insert into " + Contrato.Disciplina.TABLE_NAME + " values (17, 'Administração Bases de Dados');");
        db.execSQL("insert into " + Contrato.Disciplina.TABLE_NAME + " values (18, 'Tecnologias Multimédia');");
        db.execSQL("insert into " + Contrato.Disciplina.TABLE_NAME + " values (19, 'Interacção Homem-Máquina');");
        db.execSQL("insert into " + Contrato.Disciplina.TABLE_NAME + " values (20, 'Inteligência Artificial');");
        db.execSQL("insert into " + Contrato.Disciplina.TABLE_NAME + " values (21, 'Engenharia de Software II');");
        db.execSQL("insert into " + Contrato.Disciplina.TABLE_NAME + " values (22, 'Projecto II');");

        db.execSQL("insert into " + Contrato.Disciplina.TABLE_NAME + " values (23, 'Comportamento, Sociedade e Cidadania II');");
        db.execSQL("insert into " + Contrato.Disciplina.TABLE_NAME + " values (24, 'Sistemas de Informação em Rede');");
        db.execSQL("insert into " + Contrato.Disciplina.TABLE_NAME + " values (25, 'Integração de Sistemas');");
        db.execSQL("insert into " + Contrato.Disciplina.TABLE_NAME + " values (26, 'Opção I');");
        db.execSQL("insert into " + Contrato.Disciplina.TABLE_NAME + " values (27, 'Projecto III');");
        db.execSQL("insert into " + Contrato.Disciplina.TABLE_NAME + " values (28, 'Comportamento, Sociedade e Cidadania II');");
        db.execSQL("insert into " + Contrato.Disciplina.TABLE_NAME + " values (29, 'Computação Móvel');");
        db.execSQL("insert into " + Contrato.Disciplina.TABLE_NAME + " values (30, 'Segurança de Redes e Sistemas');");
        db.execSQL("insert into " + Contrato.Disciplina.TABLE_NAME + " values (31, 'Opção II');");
        db.execSQL("insert into " + Contrato.Disciplina.TABLE_NAME + " values (32, 'Projecto IV');");

        //ECGM
        db.execSQL("insert into " + Contrato.Disciplina.TABLE_NAME + " values (33, 'Propedêutica da Matemática');");
        db.execSQL("insert into " + Contrato.Disciplina.TABLE_NAME + " values (34, 'Design Gráfico');");
        db.execSQL("insert into " + Contrato.Disciplina.TABLE_NAME + " values (35, 'Matemática');");
        db.execSQL("insert into " + Contrato.Disciplina.TABLE_NAME + " values (36, 'Física Dinâmica');");
        db.execSQL("insert into " + Contrato.Disciplina.TABLE_NAME + " values (37, 'Matemática para Computação Gráficat');");
        db.execSQL("insert into " + Contrato.Disciplina.TABLE_NAME + " values (38, 'Ambientes de Programação Gráfica');");
        db.execSQL("insert into " + Contrato.Disciplina.TABLE_NAME + " values (39, 'Computação Gráfica');");
        db.execSQL("insert into " + Contrato.Disciplina.TABLE_NAME + " values (40, 'Projecto 2D');");
        db.execSQL("insert into " + Contrato.Disciplina.TABLE_NAME + " values (41, 'Programação 3D');");
        db.execSQL("insert into " + Contrato.Disciplina.TABLE_NAME + " values (42, 'Realidade Virtual');");
        db.execSQL("insert into " + Contrato.Disciplina.TABLE_NAME + " values (43, 'Design Multimédia');");
        db.execSQL("insert into " + Contrato.Disciplina.TABLE_NAME + " values (44, 'Redes e Sistemas de Comunicação de Dados');");
        db.execSQL("insert into " + Contrato.Disciplina.TABLE_NAME + " values (45, 'Projecto 3D');");
        db.execSQL("insert into " + Contrato.Disciplina.TABLE_NAME + " values (46, 'Modelação 3D');");
        db.execSQL("insert into " + Contrato.Disciplina.TABLE_NAME + " values (47, 'Sistemas Multimédia');");
        db.execSQL("insert into " + Contrato.Disciplina.TABLE_NAME + " values (48, 'Produção Audiovisual');");
        db.execSQL("insert into " + Contrato.Disciplina.TABLE_NAME + " values (49, 'Sistemas de Informação Geográfica');");
        db.execSQL("insert into " + Contrato.Disciplina.TABLE_NAME + " values (50, 'Projecto Web');");
        db.execSQL("insert into " + Contrato.Disciplina.TABLE_NAME + " values (51, 'Animação 3D');");
        db.execSQL("insert into " + Contrato.Disciplina.TABLE_NAME + " values (52, 'Pós-Produção Audiovisual');");
        db.execSQL("insert into " + Contrato.Disciplina.TABLE_NAME + " values (53, 'Projecto Audiovisual');");


        //ASSOCIAÇÕES

        db.execSQL("insert into " + Contrato.Associa.TABLE_NAME + " values (1, 1, 1, 0);");
        db.execSQL("insert into " + Contrato.Associa.TABLE_NAME + " values (2, 1, 2, 0);");
        db.execSQL("insert into " + Contrato.Associa.TABLE_NAME + " values (3, 1, 3, 0);");
        db.execSQL("insert into " + Contrato.Associa.TABLE_NAME + " values (4, 1, 4, 0);");
        db.execSQL("insert into " + Contrato.Associa.TABLE_NAME + " values (5, 1, 5, 0);");
        db.execSQL("insert into " + Contrato.Associa.TABLE_NAME + " values (6, 1, 6, 0);");
        db.execSQL("insert into " + Contrato.Associa.TABLE_NAME + " values (7, 1, 7, 0);");
        db.execSQL("insert into " + Contrato.Associa.TABLE_NAME + " values (8, 1, 8, 0);");
        db.execSQL("insert into " + Contrato.Associa.TABLE_NAME + " values (9, 1, 9, 0);");
        db.execSQL("insert into " + Contrato.Associa.TABLE_NAME + " values (10, 1, 10, 0);");
        db.execSQL("insert into " + Contrato.Associa.TABLE_NAME + " values (11, 1, 11, 0);");
        db.execSQL("insert into " + Contrato.Associa.TABLE_NAME + " values (12, 1, 12, 0);");
        db.execSQL("insert into " + Contrato.Associa.TABLE_NAME + " values (13, 1, 13, 0);");
        db.execSQL("insert into " + Contrato.Associa.TABLE_NAME + " values (14, 1, 14, 0);");
        db.execSQL("insert into " + Contrato.Associa.TABLE_NAME + " values (15, 1, 15, 0);");
        db.execSQL("insert into " + Contrato.Associa.TABLE_NAME + " values (16, 1, 16, 0);");
        db.execSQL("insert into " + Contrato.Associa.TABLE_NAME + " values (17, 1, 17, 0);");
        db.execSQL("insert into " + Contrato.Associa.TABLE_NAME + " values (18, 1, 18, 0);");
        db.execSQL("insert into " + Contrato.Associa.TABLE_NAME + " values (19, 1, 19, 0);");
        db.execSQL("insert into " + Contrato.Associa.TABLE_NAME + " values (20, 1, 20, 0);");
        db.execSQL("insert into " + Contrato.Associa.TABLE_NAME + " values (21, 1, 21, 0);");
        db.execSQL("insert into " + Contrato.Associa.TABLE_NAME + " values (22, 1, 22, 0);");
        db.execSQL("insert into " + Contrato.Associa.TABLE_NAME + " values (23, 1, 23, 0);");
        db.execSQL("insert into " + Contrato.Associa.TABLE_NAME + " values (24, 1, 24, 0);");
        db.execSQL("insert into " + Contrato.Associa.TABLE_NAME + " values (25, 1, 25, 0);");
        db.execSQL("insert into " + Contrato.Associa.TABLE_NAME + " values (26, 1, 26, 0);");
        db.execSQL("insert into " + Contrato.Associa.TABLE_NAME + " values (27, 1, 27, 0);");
        db.execSQL("insert into " + Contrato.Associa.TABLE_NAME + " values (28, 1, 28, 0);");
        db.execSQL("insert into " + Contrato.Associa.TABLE_NAME + " values (29, 1, 29, 0);");
        db.execSQL("insert into " + Contrato.Associa.TABLE_NAME + " values (30, 1, 30, 0);");
        db.execSQL("insert into " + Contrato.Associa.TABLE_NAME + " values (31, 1, 31, 0);");
        db.execSQL("insert into " + Contrato.Associa.TABLE_NAME + " values (32, 1, 32, 0);");




        db.execSQL("insert into " + Contrato.Associa.TABLE_NAME + " values (33, 2, 33, 0);");
        db.execSQL("insert into " + Contrato.Associa.TABLE_NAME + " values (34, 2, 2, 0);");
        db.execSQL("insert into " + Contrato.Associa.TABLE_NAME + " values (35, 2, 3, 0);");
        db.execSQL("insert into " + Contrato.Associa.TABLE_NAME + " values (36, 2, 4, 0);");
        db.execSQL("insert into " + Contrato.Associa.TABLE_NAME + " values (37, 2, 34, 0);");
        db.execSQL("insert into " + Contrato.Associa.TABLE_NAME + " values (38, 2, 35, 0);");
        db.execSQL("insert into " + Contrato.Associa.TABLE_NAME + " values (39, 2, 36, 0);");
        db.execSQL("insert into " + Contrato.Associa.TABLE_NAME + " values (40, 2, 7, 0);");
        db.execSQL("insert into " + Contrato.Associa.TABLE_NAME + " values (41, 2, 8, 0);");
        db.execSQL("insert into " + Contrato.Associa.TABLE_NAME + " values (42, 2, 10, 0);");

        db.execSQL("insert into " + Contrato.Associa.TABLE_NAME + " values (43, 2, 37, 0);");
        db.execSQL("insert into " + Contrato.Associa.TABLE_NAME + " values (44, 2, 38, 0);");
        db.execSQL("insert into " + Contrato.Associa.TABLE_NAME + " values (45, 2, 39, 0);");
        db.execSQL("insert into " + Contrato.Associa.TABLE_NAME + " values (46, 2, 13, 0);");
        db.execSQL("insert into " + Contrato.Associa.TABLE_NAME + " values (47, 2, 14, 0);");
        db.execSQL("insert into " + Contrato.Associa.TABLE_NAME + " values (48, 2, 40, 0);");
        db.execSQL("insert into " + Contrato.Associa.TABLE_NAME + " values (49, 2, 41, 0);");
        db.execSQL("insert into " + Contrato.Associa.TABLE_NAME + " values (50, 2, 19, 0);");
        db.execSQL("insert into " + Contrato.Associa.TABLE_NAME + " values (51, 2, 42, 0);");
        db.execSQL("insert into " + Contrato.Associa.TABLE_NAME + " values (52, 2, 43, 0);");
        db.execSQL("insert into " + Contrato.Associa.TABLE_NAME + " values (53, 2, 44, 0);");
        db.execSQL("insert into " + Contrato.Associa.TABLE_NAME + " values (54, 2, 45, 0);");

        db.execSQL("insert into " + Contrato.Associa.TABLE_NAME + " values (55, 2, 24, 0);");
        db.execSQL("insert into " + Contrato.Associa.TABLE_NAME + " values (56, 2, 46, 0);");
        db.execSQL("insert into " + Contrato.Associa.TABLE_NAME + " values (57, 2, 47, 0);");
        db.execSQL("insert into " + Contrato.Associa.TABLE_NAME + " values (58, 2, 48, 0);");
        db.execSQL("insert into " + Contrato.Associa.TABLE_NAME + " values (59, 2, 49, 0);");
        db.execSQL("insert into " + Contrato.Associa.TABLE_NAME + " values (60, 2, 50, 0);");
        db.execSQL("insert into " + Contrato.Associa.TABLE_NAME + " values (61, 2, 51, 0);");
        db.execSQL("insert into " + Contrato.Associa.TABLE_NAME + " values (62, 2, 18, 0);");
        db.execSQL("insert into " + Contrato.Associa.TABLE_NAME + " values (63, 2, 52, 0);");
        db.execSQL("insert into " + Contrato.Associa.TABLE_NAME + " values (64, 2, 12, 0);");
        db.execSQL("insert into " + Contrato.Associa.TABLE_NAME + " values (65, 2, 53, 0);");
        db.execSQL("insert into " + Contrato.Associa.TABLE_NAME + " values (66, 2, 28, 0);");


    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL(Contrato.Associa.SQL_DROP_ENTRIES);
        db.execSQL(Contrato.Curso.SQL_DROP_ENTRIES);
        db.execSQL(Contrato.Disciplina.SQL_DROP_ENTRIES);

        onCreate(db);
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