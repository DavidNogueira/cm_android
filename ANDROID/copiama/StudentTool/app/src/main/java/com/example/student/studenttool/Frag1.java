package com.example.student.studenttool;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.student.studenttool.db.Contrato;
import com.example.student.studenttool.db.DB;

import static com.example.student.studenttool.R.id.ch;

public class Frag1 extends Fragment {

    DB mDbHelper;
    SQLiteDatabase db;
    Cursor c;

    private Dialog dialog;
    Button[] bt = new Button[63];


    private static final String ARG_SECTION_NUMBER = "section_number";
    public Frag1(){
    }

    public static Frag1 newInstance(int sectionNumber){

        Frag1 fragment = new Frag1();
        Bundle args= new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;

    }
    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        View rootView = inflater.inflate(R.layout.frag1, container, false);






        bt[0] = (Button)rootView.findViewById(R.id.button11);
        bt[1] = (Button)rootView.findViewById(R.id.button12);
        bt[2] = (Button)rootView.findViewById(R.id.button13);
        bt[3] = (Button)rootView.findViewById(R.id.button14);
        bt[4] = (Button)rootView.findViewById(R.id.button15);

        bt[5] = (Button)rootView.findViewById(R.id.button16);
        bt[6] = (Button)rootView.findViewById(R.id.button17);
        bt[7] = (Button)rootView.findViewById(R.id.button18);
        bt[8] = (Button)rootView.findViewById(R.id.button19);
        bt[9] = (Button)rootView.findViewById(R.id.button20);

        //22222222222222

        bt[10] = (Button)rootView.findViewById(R.id.button21);
        bt[11] = (Button)rootView.findViewById(R.id.button22);
        bt[12] = (Button)rootView.findViewById(R.id.button23);
        bt[13] = (Button)rootView.findViewById(R.id.button24);
        bt[14] = (Button)rootView.findViewById(R.id.button25);
        bt[15] = (Button)rootView.findViewById(R.id.button26);

        bt[16] = (Button)rootView.findViewById(R.id.button27);
        bt[17] = (Button)rootView.findViewById(R.id.button28);
        bt[18] = (Button)rootView.findViewById(R.id.button29);
        bt[19] = (Button)rootView.findViewById(R.id.button30);
        bt[20] = (Button)rootView.findViewById(R.id.button31);
        bt[21] = (Button)rootView.findViewById(R.id.button32);

        //33333333333333

        bt[22] = (Button)rootView.findViewById(R.id.button33);
        bt[23] = (Button)rootView.findViewById(R.id.button112);
        bt[24] = (Button)rootView.findViewById(R.id.button34);
        bt[25] = (Button)rootView.findViewById(R.id.button35);
        bt[26] = (Button)rootView.findViewById(R.id.button36);

        bt[27] = (Button)rootView.findViewById(R.id.button37);
        bt[28] = (Button)rootView.findViewById(R.id.button38);
        bt[29] = (Button)rootView.findViewById(R.id.button39);
        bt[30] = (Button)rootView.findViewById(R.id.button40);
        bt[31] = (Button)rootView.findViewById(R.id.button41);

        //outros
        bt[32] = (Button)rootView.findViewById(R.id.button42);
        bt[33] = (Button)rootView.findViewById(R.id.button43);
        bt[34] = (Button)rootView.findViewById(R.id.button44);
        bt[35] = (Button)rootView.findViewById(R.id.button45);
        bt[36] = (Button)rootView.findViewById(R.id.button46);
        bt[37] = (Button)rootView.findViewById(R.id.button47);
        bt[38] = (Button)rootView.findViewById(R.id.button48);
        bt[39] = (Button)rootView.findViewById(R.id.button49);
        bt[40] = (Button)rootView.findViewById(R.id.button50);

        for (int i = 0; i<41; i++){
            bt[i].setVisibility(View.INVISIBLE);

        }


        FloatingActionButton fab = (FloatingActionButton)  rootView.findViewById(R.id.fab1);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dialog = new Dialog(getActivity());
                dialog.setTitle("DEFINIÇÕES");
                dialog.setContentView(R.layout.customdialog);
                dialog.show();

                Button okButton = (Button)dialog.findViewById(R.id.button4);
                Button cancelButton = (Button)dialog.findViewById(R.id.button5);
                okButton.setOnClickListener(new View.OnClickListener(){

                    @Override
                    public void onClick(View v){


                        dialog.cancel();

                        Intent intent = new Intent(v.getContext(), SelectCourse.class);

                        startActivityForResult(intent, 0);
                        getActivity().finish();

                    }
                });

                cancelButton.setOnClickListener(new View.OnClickListener(){

                    @Override
                    public void onClick(View v){
                        dialog.cancel();
                    }
                });




            }
        });



        //1º
        mDbHelper = new DB(getActivity().getApplicationContext());
        db = mDbHelper.getReadableDatabase();//declaração da bd

        getCursor1();
        return rootView;
    }


    private void getCursor1() {


        String bla = "SELECT "+ Contrato.Disciplina.COLUMN_NOME_DISCIPLINA+ "," + Contrato.Associa.TABLE_NAME + "." + Contrato.Associa._ID+
                " FROM "+ Contrato.Associa.TABLE_NAME + ", " + Contrato.Disciplina.TABLE_NAME +
                " WHERE " + Contrato.Associa.COLUMN_ID_DISCIPLINA + " = " + Contrato.Disciplina.TABLE_NAME +"."+ Contrato.Disciplina._ID +
                " AND " + Contrato.Associa.COLUMN_CHECK + " = 1";

        c = db.rawQuery(bla, null);

        String nomeDis;
        String idDis;
        for(int i=0; i < c.getCount(); i++){
            c.moveToPosition(i);
            nomeDis = c.getString(c.getColumnIndex(Contrato.Disciplina.COLUMN_NOME_DISCIPLINA));
            idDis = c.getString(c.getColumnIndex(Contrato.Associa._ID));


            if(idDis.equals("1")){
                bt[5].setVisibility(View.VISIBLE);
                bt[5].setText(nomeDis);

            }
            if(idDis.equals("2")){
                bt[1].setVisibility(View.VISIBLE);
                bt[1].setText(nomeDis);

            }
            if(idDis.equals("3")){
                bt[0].setVisibility(View.VISIBLE);
                bt[0].setText(nomeDis);

            }
            if(idDis.equals("4")){
                bt[10].setVisibility(View.VISIBLE);
                bt[10].setText(nomeDis);

            }
            if(idDis.equals("5")){
                bt[18].setVisibility(View.VISIBLE);
                bt[18].setText(nomeDis);

            }
            if(idDis.equals("6")){
                bt[26].setVisibility(View.VISIBLE);
                bt[26].setText(nomeDis);

            }
            if(idDis.equals("7")){
                bt[25].setVisibility(View.VISIBLE);
                bt[25].setText(nomeDis);

            }
            if(idDis.equals("8")){
                bt[14].setVisibility(View.VISIBLE);
                bt[14].setText(nomeDis);

            }
            if(idDis.equals("9")){
                bt[11].setVisibility(View.VISIBLE);
                bt[11].setText(nomeDis);

            }
            if(idDis.equals("10")){
                bt[22].setVisibility(View.VISIBLE);
                bt[22].setText(nomeDis);

            }
            if(idDis.equals("11")){
                bt[6].setVisibility(View.VISIBLE);
                bt[6].setText(nomeDis);

            }
            if(idDis.equals("12")){
                bt[30].setVisibility(View.VISIBLE);
                bt[30].setText(nomeDis);

            }
            if(idDis.equals("13")){
                bt[2].setVisibility(View.VISIBLE);
                bt[2].setText(nomeDis);

            }
            if(idDis.equals("14")){
                bt[16].setVisibility(View.VISIBLE);
                bt[16].setText(nomeDis);

            }
            if(idDis.equals("15")){
                bt[17].setVisibility(View.VISIBLE);
                bt[17].setText(nomeDis);

            }
            if(idDis.equals("16")){
                bt[19].setVisibility(View.VISIBLE);
                bt[19].setText(nomeDis);

            }
            if(idDis.equals("17")){
                bt[24].setVisibility(View.VISIBLE);
                bt[24].setText(nomeDis);

            }
            if(idDis.equals("18")){
                bt[12].setVisibility(View.VISIBLE);
                bt[12].setText(nomeDis);

            }
            if(idDis.equals("19")){
                bt[32].setVisibility(View.VISIBLE);
                bt[32].setText(nomeDis);

            }
            if(idDis.equals("20")){
                bt[7].setVisibility(View.VISIBLE);
                bt[7].setText(nomeDis);

            }
            if(idDis.equals("21")){
                bt[13].setVisibility(View.VISIBLE);
                bt[13].setText(nomeDis);

            }
            if(idDis.equals("22")){
                bt[21].setVisibility(View.VISIBLE);
                bt[21].setText(nomeDis);

            }
            if(idDis.equals("23")){
                bt[33].setVisibility(View.VISIBLE);
                bt[33].setText(nomeDis);

            }
            if(idDis.equals("24")){
                bt[31].setVisibility(View.VISIBLE);
                bt[31].setText(nomeDis);

            }
            if(idDis.equals("25")){
                bt[8].setVisibility(View.VISIBLE);
                bt[8].setText(nomeDis);

            }
            if(idDis.equals("26")){
                bt[3].setVisibility(View.VISIBLE);
                bt[3].setText(nomeDis);

            }
            if(idDis.equals("27")){
                bt[34].setVisibility(View.VISIBLE);
                bt[34].setText(nomeDis);

            }
            if(idDis.equals("28")){
                bt[4].setVisibility(View.VISIBLE);
                bt[4].setText(nomeDis);

            }
            if(idDis.equals("29")){
                bt[35].setVisibility(View.VISIBLE);
                bt[35].setText(nomeDis);

            }
            if(idDis.equals("30")){
                bt[28].setVisibility(View.VISIBLE);
                bt[28].setText(nomeDis);

            }
            if(idDis.equals("31")){
                bt[15].setVisibility(View.VISIBLE);
                bt[15].setText(nomeDis);

            }
            if(idDis.equals("32")){
                bt[9].setVisibility(View.VISIBLE);
                bt[9].setText(nomeDis);

            }
            if(idDis.equals("33")){
                bt[36].setVisibility(View.VISIBLE);
                bt[36].setText(nomeDis);

            }
            if(idDis.equals("34")){
                bt[29].setVisibility(View.VISIBLE);
                bt[29].setText(nomeDis);

            }
            if(idDis.equals("35")){
                bt[20].setVisibility(View.VISIBLE);
                bt[20].setText(nomeDis);

            }
            if(idDis.equals("36")){
                bt[37].setVisibility(View.VISIBLE);
                bt[37].setText(nomeDis);

            }
            if(idDis.equals("37")){
                bt[38].setVisibility(View.VISIBLE);
                bt[38].setText(nomeDis);

            }
            if(idDis.equals("38")){
                bt[27].setVisibility(View.VISIBLE);
                bt[27].setText(nomeDis);

            }
            if(idDis.equals("39")){
                bt[39].setVisibility(View.VISIBLE);
                bt[39].setText(nomeDis);

            }
            if(idDis.equals("40")){
                bt[40].setVisibility(View.VISIBLE);
                bt[40].setText(nomeDis);

            }

            ///----

            if(idDis.equals("41")){
                bt[5].setVisibility(View.VISIBLE);
                bt[5].setText(nomeDis);

            }
            if(idDis.equals("42")){
                bt[0].setVisibility(View.VISIBLE);
                bt[0].setText(nomeDis);

            }
            if(idDis.equals("43")){
                bt[1].setVisibility(View.VISIBLE);
                bt[1].setText(nomeDis);

            }
            if(idDis.equals("43")){
                bt[18].setVisibility(View.VISIBLE);
                bt[18].setText(nomeDis);

            }if(idDis.equals("45")){
                bt[14].setVisibility(View.VISIBLE);
                bt[14].setText(nomeDis);

            }
            if(idDis.equals("46")){
                bt[26].setVisibility(View.VISIBLE);
                bt[26].setText(nomeDis);

            }if(idDis.equals("47")){
                bt[1].setVisibility(View.VISIBLE);
                bt[1].setText(nomeDis);

            }
            if(idDis.equals("48")){
                bt[22].setVisibility(View.VISIBLE);
                bt[22].setText(nomeDis);

            }
            if(idDis.equals("49")){
                bt[10].setVisibility(View.VISIBLE);
                bt[10].setText(nomeDis);

            }
            if(idDis.equals("50")){
                bt[20].setVisibility(View.VISIBLE);
                bt[20].setText(nomeDis);

            }
            if(idDis.equals("51")){
                bt[25].setVisibility(View.VISIBLE);
                bt[25].setText(nomeDis);

            }
            if(idDis.equals("52")){
                bt[22].setVisibility(View.VISIBLE);
                bt[22].setText(nomeDis);

            }
            if(idDis.equals("53")){
                bt[6].setVisibility(View.VISIBLE);
                bt[6].setText(nomeDis);

            }
            if(idDis.equals("54")){
                bt[30].setVisibility(View.VISIBLE);
                bt[30].setText(nomeDis);

            }
            if(idDis.equals("55")){
                bt[2].setVisibility(View.VISIBLE);
                bt[2].setText(nomeDis);

            }
            if(idDis.equals("56")){
                bt[17].setVisibility(View.VISIBLE);
                bt[17].setText(nomeDis);

            }
            if(idDis.equals("57")){
                bt[19].setVisibility(View.VISIBLE);
                bt[19].setText(nomeDis);

            }
            if(idDis.equals("58")){
                bt[32].setVisibility(View.VISIBLE);
                bt[32].setText(nomeDis);

            }
            if(idDis.equals("59")){
                bt[12].setVisibility(View.VISIBLE);
                bt[12].setText(nomeDis);

            }
            if(idDis.equals("60")){
                bt[11].setVisibility(View.VISIBLE);
                bt[11].setText(nomeDis);

            }
            if(idDis.equals("61")){
                bt[7].setVisibility(View.VISIBLE);
                bt[7].setText(nomeDis);

            }
            if(idDis.equals("62")){
                bt[33].setVisibility(View.VISIBLE);
                bt[33].setText(nomeDis);

            }
            if(idDis.equals("63")){
                bt[21].setVisibility(View.VISIBLE);
                bt[21].setText(nomeDis);

            }
            if(idDis.equals("64")){
                bt[13].setVisibility(View.VISIBLE);
                bt[13].setText(nomeDis);

            }
            if(idDis.equals("65")){
                bt[8].setVisibility(View.VISIBLE);
                bt[8].setText(nomeDis);

            }
            if(idDis.equals("66")){
                bt[3].setVisibility(View.VISIBLE);
                bt[3].setText(nomeDis);

            }






        }

    }
}
