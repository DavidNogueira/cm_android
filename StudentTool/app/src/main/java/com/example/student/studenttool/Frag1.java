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






        bt[0] = (Button)rootView.findViewById(R.id.button13);
        bt[1] = (Button)rootView.findViewById(R.id.button12);
        bt[2] = (Button)rootView.findViewById(R.id.button23);
        bt[3] = (Button)rootView.findViewById(R.id.button36);
        bt[4] = (Button)rootView.findViewById(R.id.button38);

        bt[5] = (Button)rootView.findViewById(R.id.button11);
        bt[6] = (Button)rootView.findViewById(R.id.button21);
        bt[7] = (Button)rootView.findViewById(R.id.button30);
        bt[8] = (Button)rootView.findViewById(R.id.button35);
        bt[9] = (Button)rootView.findViewById(R.id.button42);

        //22222222222222

        bt[10] = (Button)rootView.findViewById(R.id.button14);
        bt[11] = (Button)rootView.findViewById(R.id.button19);
        bt[12] = (Button)rootView.findViewById(R.id.button28);
        bt[13] = (Button)rootView.findViewById(R.id.button31);
        bt[14] = (Button)rootView.findViewById(R.id.button18);
        bt[15] = (Button)rootView.findViewById(R.id.button41);

        bt[16] = (Button)rootView.findViewById(R.id.button24);
        bt[17] = (Button)rootView.findViewById(R.id.button25);
        bt[18] = (Button)rootView.findViewById(R.id.button15);
        bt[19] = (Button)rootView.findViewById(R.id.button26);
        bt[20] = (Button)rootView.findViewById(R.id.button45);
        bt[21] = (Button)rootView.findViewById(R.id.button32);

        //33333333333333

        bt[22] = (Button)rootView.findViewById(R.id.button20);
        bt[23] = (Button)rootView.findViewById(R.id.button112);
        bt[24] = (Button)rootView.findViewById(R.id.button27);
        bt[25] = (Button)rootView.findViewById(R.id.button17);
        bt[26] = (Button)rootView.findViewById(R.id.button16);

        bt[27] = (Button)rootView.findViewById(R.id.button48);
        bt[28] = (Button)rootView.findViewById(R.id.button40);
        bt[29] = (Button)rootView.findViewById(R.id.button44);
        bt[30] = (Button)rootView.findViewById(R.id.button22);
        bt[31] = (Button)rootView.findViewById(R.id.button34);

        //outros
        bt[32] = (Button)rootView.findViewById(R.id.button29);
        bt[33] = (Button)rootView.findViewById(R.id.button33);
        bt[34] = (Button)rootView.findViewById(R.id.button37);
        bt[35] = (Button)rootView.findViewById(R.id.button39);
        bt[36] = (Button)rootView.findViewById(R.id.button43);
        bt[37] = (Button)rootView.findViewById(R.id.button46);
        bt[38] = (Button)rootView.findViewById(R.id.button47);
        bt[39] = (Button)rootView.findViewById(R.id.button49);
        bt[40] = (Button)rootView.findViewById(R.id.button50);


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


        String bla = "SELECT "+ Contrato.Associa.COLUMN_CHECK+ " FROM "+ Contrato.Associa.TABLE_NAME;

        c = db.rawQuery(bla, null);

        String checki;
        for(int i=0; i < 32; i++){

            c.moveToPosition(i);
            checki = c.getString(c.getColumnIndex(Contrato.Associa.COLUMN_CHECK));
            if(checki.equals("1")){
                bt[i].setVisibility(View.VISIBLE);
            }else{
                bt[i].setVisibility(View.INVISIBLE);
            }


        }

    }
}
