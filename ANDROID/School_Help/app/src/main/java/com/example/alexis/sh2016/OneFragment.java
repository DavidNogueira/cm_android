package com.example.alexis.sh2016;

/**
 * Created by alexis on 11/06/16.
 */


import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;

//import info.androidhive.materialtabs.R;


public class OneFragment extends Fragment{

    private Dialog dialog;
    Button[] bt = new Button[41];
   // int check[]=new int[32];
    public OneFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {

        initializeDB();

        View rootView = inflater.inflate(R.layout.fragment_one, container, false);

        //111111111111111

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



        for(int i = 0; i<32; i++) {
            if (getData(i+1).equalsIgnoreCase("0")){
                bt[i].setVisibility(View.INVISIBLE);
            }
            if(getData(i+1).equalsIgnoreCase("1")){
                bt[i].setVisibility(View.VISIBLE);
            }
        }

        if(getData(1).equalsIgnoreCase("0")){
            bt[32].setVisibility(View.INVISIBLE);
        }else {
            bt[32].setVisibility(View.VISIBLE);

        }
        if(getData(19).equalsIgnoreCase("0")){
            bt[33].setVisibility(View.INVISIBLE);
        }else {
            bt[33].setVisibility(View.VISIBLE);

        }
        if(getData(18).equalsIgnoreCase("0")){
            bt[34].setVisibility(View.INVISIBLE);
        }else {
            bt[34].setVisibility(View.VISIBLE);

        }
        if(getData(25).equalsIgnoreCase("0")){
            bt[35].setVisibility(View.INVISIBLE);
        }else {
            bt[35].setVisibility(View.VISIBLE);

        }
        if(getData(6).equalsIgnoreCase("0")){
            bt[36].setVisibility(View.INVISIBLE);
        }else {
            bt[36].setVisibility(View.VISIBLE);

        }
        if(getData(2).equalsIgnoreCase("0")){
            bt[37].setVisibility(View.INVISIBLE);
        }else {
            bt[37].setVisibility(View.VISIBLE);

        }
        if(getData(17).equalsIgnoreCase("0")){
            bt[38].setVisibility(View.INVISIBLE);
        }else {
            bt[38].setVisibility(View.VISIBLE);

        }
        if(getData(5).equalsIgnoreCase("0")){
            bt[39].setVisibility(View.INVISIBLE);
        }else {
            bt[39].setVisibility(View.VISIBLE);

        }
        if(getData(9).equalsIgnoreCase("0")){
            bt[40].setVisibility(View.INVISIBLE);
        }else {
            bt[40].setVisibility(View.VISIBLE);

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

                        Intent intent = new Intent(v.getContext(), MainActivity.class);

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

        return rootView;

    }


    public  void initializeDB(){
        MyTable user = new MyTable();
        String[] tableCreateArray = { user.getDatabaseCreateQuery() };
        dbOperation operation = new dbOperation(getActivity(),tableCreateArray);
        operation.open();
        operation.close();
    }
    /*** GET THE DATA FROM DB ,PARAMS - FILENAME -> GET THE DATA ***/
    public String getData(int id){
        String _data = "";
        dbOperation operationObj = new dbOperation(getActivity());
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


}