package com.example.alexis.sh2016;

/**
 * Created by alexis on 11/06/16.
 */


import android.app.Dialog;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//import info.androidhive.materialtabs.R;


public class ThreeFragment extends Fragment{


    private TextView saldoAcivity;
    private TextView saldo;
    private String stredittext;
    private Double tot ;
    private Double tot2 = 0.0;
    private Button btn;
    private Dialog dialog;


    Button[] bt = new Button[30];
    int num=0;

    int x, t;
    int i =0;
    private final static String STORETEXT="storetext8.txt";


    //  File file = new File(context.getFilesDir(), filename);



    public ThreeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        initializeDB();

        View rootView = inflater.inflate(R.layout.fragment_three, container, false);



        bt[0] = (Button)rootView.findViewById(R.id.button51);
        bt[1] = (Button)rootView.findViewById(R.id.button52);
        bt[2] = (Button)rootView.findViewById(R.id.button53);
        bt[3] = (Button)rootView.findViewById(R.id.button54);
        bt[4] = (Button)rootView.findViewById(R.id.button55);
        bt[5] = (Button)rootView.findViewById(R.id.button56);
        bt[6] = (Button)rootView.findViewById(R.id.button57);
        bt[7] = (Button)rootView.findViewById(R.id.button58);
        bt[8] = (Button)rootView.findViewById(R.id.button59);
        bt[9] = (Button)rootView.findViewById(R.id.button60);
        bt[10] = (Button)rootView.findViewById(R.id.button61);
        bt[11] = (Button)rootView.findViewById(R.id.button62);
        bt[12] = (Button)rootView.findViewById(R.id.button63);
        bt[13] = (Button)rootView.findViewById(R.id.button64);
        bt[14] = (Button)rootView.findViewById(R.id.button65);
        bt[15] = (Button)rootView.findViewById(R.id.button66);
        bt[16] = (Button)rootView.findViewById(R.id.button67);
        bt[17] = (Button)rootView.findViewById(R.id.button68);
        bt[18] = (Button)rootView.findViewById(R.id.button69);
        bt[19] = (Button)rootView.findViewById(R.id.button70);
        bt[20] = (Button)rootView.findViewById(R.id.button71);
        bt[21] = (Button)rootView.findViewById(R.id.button72);
        bt[22] = (Button)rootView.findViewById(R.id.button73);
        bt[23] = (Button)rootView.findViewById(R.id.button74);
        bt[24] = (Button)rootView.findViewById(R.id.button75);
        bt[25] = (Button)rootView.findViewById(R.id.button76);
        bt[26] = (Button)rootView.findViewById(R.id.button77);
        bt[27] = (Button)rootView.findViewById(R.id.button78);
        bt[28] = (Button)rootView.findViewById(R.id.button79);
        bt[29] = (Button)rootView.findViewById(R.id.button80);




        for(x=33;x<64;x++){
            String file2_ = getData(x);


            if(file2_.equals("error")){
                num=x;
                updateTable3();
            }
        }


        for(x =0; x<30;x++){
            x=x+33;
            t = Integer.parseInt(getData(x));
            x=x-33;
            if(t==0){
                bt[x].setBackgroundColor(0xffff8800);
            }else{
                bt[x].setBackgroundColor(Color.RED);
            }

        }


        btn = (Button) rootView.findViewById(R.id.button7);
        btn.setText(getData(34));


        bt[0].setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                naVenda(0);
                return true;
            }
        });
        bt[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                naCompra(0);
            }
        });

        bt[1].setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                naVenda(1);
                return true;
            }
        });
        bt[1].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                naCompra(1);
            }
        });

        bt[2].setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                naVenda(2);
                return true;
            }
        });
        bt[2].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                naCompra(2);
            }
        });

        bt[3].setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                naVenda(3);
                return true;
            }
        });
        bt[3].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                naCompra(3);
            }
        });

        bt[4].setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                naVenda(4);
                return true;
            }
        });
        bt[4].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                naCompra(4);
            }
        });

        bt[5].setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                naVenda(5);
                return true;
            }
        });
        bt[5].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                naCompra(5);
            }
        });

        bt[6].setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                naVenda(6);
                return true;
            }
        });
        bt[6].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                naCompra(6);
            }
        });

        bt[7].setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                naVenda(7);
                return true;
            }
        });
        bt[7].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                naCompra(7);
            }
        });

        bt[8].setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                naVenda(8);
                return true;
            }
        });
        bt[8].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                naCompra(8);
            }
        });

        bt[9].setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                naVenda(9);
                return true;
            }
        });
        bt[9].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                naCompra(9);
            }
        });

        bt[10].setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                naVenda(10);
                return true;
            }
        });
        bt[10].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                naCompra(10);
            }
        });

        bt[11].setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                naVenda(11);
                return true;
            }
        });
        bt[11].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                naCompra(11);
            }
        });

        bt[12].setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                naVenda(12);
                return true;
            }
        });
        bt[12].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                naCompra(12);
            }
        });

        bt[13].setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                naVenda(13);
                return true;
            }
        });
        bt[13].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                naCompra(13);
            }
        });

        bt[14].setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                naVenda(14);
                return true;
            }
        });
        bt[14].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                naCompra(14);
            }
        });

        bt[15].setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                naVenda(15);
                return true;
            }
        });
        bt[15].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                naCompra(15);
            }
        });

        bt[16].setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                naVenda(16);
                return true;
            }
        });
        bt[16].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                naCompra(16);
            }
        });

        bt[17].setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                naVenda(17);
                return true;
            }
        });
        bt[17].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                naCompra(17);
            }
        });

        bt[18].setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                naVenda(18);
                return true;
            }
        });
        bt[18].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                naCompra(18);
            }
        });

        bt[19].setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                naVenda(19);
                return true;
            }
        });
        bt[19].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                naCompra(19);
            }
        });

        bt[20].setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                naVenda(20);
                return true;
            }
        });
        bt[20].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                naCompra(20);
            }
        });

        bt[21].setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                naVenda(21);
                return true;
            }
        });
        bt[21].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                naCompra(21);
            }
        });

        bt[22].setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                naVenda(22);
                return true;
            }
        });
        bt[22].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                naCompra(22);
            }
        });

        bt[23].setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                naVenda(23);
                return true;
            }
        });
        bt[23].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                naCompra(23);
            }
        });

        bt[24].setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                naVenda(24);
                return true;
            }
        });
        bt[24].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                naCompra(24);
            }
        });

        bt[25].setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                naVenda(25);
                return true;
            }
        });
        bt[25].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                naCompra(25);
            }
        });

        bt[26].setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                naVenda(26);
                return true;
            }
        });
        bt[26].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                naCompra(26);
            }
        });

        bt[27].setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                naVenda(27);
                return true;
            }
        });
        bt[27].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                naCompra(27);
            }
        });

        bt[28].setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                naVenda(28);
                return true;
            }
        });
        bt[28].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                naCompra(28);
            }
        });

        bt[29].setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                naVenda(29);
                return true;
            }
        });
        bt[29].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                naCompra(29);
            }
        });








        saldo = (TextView) rootView.findViewById(R.id.textView88);
        readFileInEditor();

        saldoAcivity = (TextView) rootView.findViewById(R.id.textView86);
        saldoAcivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                //getActivity().finish();

                Intent intent = new Intent(v.getContext(), CarregarSaldo.class);

                intent.putExtra("num", saldo.getText().toString());
                startActivityForResult(intent, 1);

            }
        });





        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_three, container, false);
        return rootView;
    }



    public void naVenda(final int k){
        int tt = 0;
        int hh;

        tt = k + 33;
        hh=Integer.parseInt(getData(tt));
        if(hh>0 ){
            dialog = new Dialog(getActivity());
            dialog.setTitle("VENDER SENHA");
            dialog.setContentView(R.layout.vender_senha);
            dialog.show();
            Button okButton = (Button) dialog.findViewById(R.id.button83);
            Button cancelButton = (Button) dialog.findViewById(R.id.button84);
            okButton.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    dialog.cancel();
                    num = k + 33;
                    updateTable2();


                    try {
                        OutputStreamWriter out = new OutputStreamWriter(getActivity().openFileOutput(STORETEXT, 0));

                        tot2 = 2.4 + Double.parseDouble(saldo.getText().toString());
                        out.write(String.valueOf(tot2));
                        out.close();
                        //Toast.makeText(getActivity().getApplicationContext(),"The contents are saved in the file.", Toast.LENGTH_LONG).show();
                        readFileInEditor();
                        bt[k].setBackgroundColor(0xffff8800);


                    }
                    catch (Throwable t) {
                       // Toast.makeText(getActivity().getApplicationContext(),"Exception: "+t.toString(), Toast.LENGTH_LONG).show();
                    }


                }
            });
            cancelButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.cancel();
                }
            });
        }


    }




    public void naCompra(final int k){
        int tt = 0;
        int hh;
        double qq;
        tt = k + 33;
        hh=Integer.parseInt(getData(tt));
        qq=Double.parseDouble(saldo.getText().toString());
        if(hh==0 && qq>=2.4) {
            dialog = new Dialog(getActivity());
            dialog.setTitle("COMPRAR SENHA");
            dialog.setContentView(R.layout.comprar_senha);
            dialog.show();
            Button okButton = (Button) dialog.findViewById(R.id.button81);
            Button cancelButton = (Button) dialog.findViewById(R.id.button82);
            okButton.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    dialog.cancel();
                    num = k + 33;
                    updateTable();
                    try {
                        OutputStreamWriter out = new OutputStreamWriter(getActivity().openFileOutput(STORETEXT, 0));

                        tot2 = Double.parseDouble(saldo.getText().toString()) - 2.4;
                        out.write(String.valueOf(tot2));
                        out.close();
                       // Toast.makeText(getActivity().getApplicationContext(), "The contents are saved in the file.", Toast.LENGTH_LONG).show();
                        readFileInEditor();
                        bt[k].setBackgroundColor(Color.RED);
                    }
                    catch (Throwable t) {
                      //  Toast.makeText(getActivity().getApplicationContext(),"Exception: "+t.toString(), Toast.LENGTH_LONG).show();
                    }
                }
            });
            cancelButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.cancel();
                }
            });
        }

    }







    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if(resultCode == getActivity().RESULT_OK){
                String stredittext=data.getStringExtra("num2");
                saldo = (TextView) getActivity().findViewById(R.id.textView88);
                tot = Double.parseDouble(stredittext) + Double.parseDouble(saldo.getText().toString());
                saldo.setText(String.valueOf(tot));

            }
        }

    }

    public void readFileInEditor() {

        try {

            InputStream in = getActivity().openFileInput(STORETEXT);

            if (in != null) {
                InputStreamReader tmp=new InputStreamReader(in);
                BufferedReader reader=new BufferedReader(tmp);
                String str;
                StringBuilder buf=new StringBuilder();

                while ((str = reader.readLine()) != null) {


                    buf.append(str);
                }
                in.close();
                saldo.setText(buf.toString());
            }
        }

        catch (java.io.FileNotFoundException e) {
            // that's OK, we probably haven't created it yet
        }

        catch (Throwable t) {
           // Toast.makeText(getActivity(), "Exception: " + t.toString(), Toast.LENGTH_LONG).show();

        }

    }








    public  void initializeDB(){
        MyTable user = new MyTable();
        String[] tableCreateArray = { user.getDatabaseCreateQuery() };
        dbOperation operation = new dbOperation(getActivity(),tableCreateArray);
        operation.open();
        operation.close();
    }

    public  void saveData(){
        int m=0;
        dbOperation operationObj = new dbOperation(getActivity());
        operationObj.open();
        MyTable Fields = new MyTable();
        ContentValues initialValues = new ContentValues();

        m = Integer.parseInt(getData(num));
        m = m + 1;
        initialValues.put(Fields.getScore(), m);
        operationObj.insertTableData(Fields.getTableName(), initialValues);

        operationObj.close();
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


    public void updateTable(){
        int m=0;
        dbOperation operationObj = new dbOperation(getActivity());
        operationObj.open();
        MyTable Fields = new MyTable();
        //check for the value to update if no value then insert.
            String file_ = getData(num);

            if (file_.equals("error")) {
                saveData();
            } else {
                String condition = Fields.getID() + " = '" + num + "'";
                ContentValues initialValues = new ContentValues();
                m = Integer.parseInt(getData(num));
                m = m + 1;
                initialValues.put(Fields.getScore(), m);
                operationObj.updateTable(Fields.getTableName(), initialValues, condition);
            }


        operationObj.close();
    }



    public void updateTable2(){
        int m=0;
        dbOperation operationObj = new dbOperation(getActivity());
        operationObj.open();
        MyTable Fields = new MyTable();
        //check for the value to update if no value then insert.

        String file_ = getData(num);
       // Toast.makeText(getActivity().getApplicationContext(),"file : "+num, Toast.LENGTH_LONG).show();

        if(file_.equals("error")){
            saveData2();
        }else{
            String condition = Fields.getID() + " = '" +num+ "'";
            ContentValues initialValues = new ContentValues();
            m = Integer.parseInt(getData(num));
            m = m - 1;
           // Toast.makeText(getActivity().getApplicationContext(),"numero senhas : "+m, Toast.LENGTH_LONG).show();
            initialValues.put(Fields.getScore(), m);
            operationObj.updateTable(Fields.getTableName(), initialValues, condition);
        }


        operationObj.close();
    }


    public  void saveData2(){
        int m=0;
        dbOperation operationObj = new dbOperation(getActivity());
        operationObj.open();
        MyTable Fields = new MyTable();
        ContentValues initialValues = new ContentValues();

        m = Integer.parseInt(getData(num));
        m = m + 1;
        initialValues.put(Fields.getScore(), m);
        operationObj.insertTableData(Fields.getTableName(), initialValues);

        operationObj.close();
    }






    public void updateTable3(){
        int m=0;
        dbOperation operationObj = new dbOperation(getActivity());
        operationObj.open();
        MyTable Fields = new MyTable();
        //check for the value to update if no value then insert.

        String file_ = getData(num);
        // Toast.makeText(getActivity().getApplicationContext(),"file : "+num, Toast.LENGTH_LONG).show();

        if(file_.equals("error")){
            saveData3();
        }else{
            String condition = Fields.getID() + " = '" +num+ "'";
            ContentValues initialValues = new ContentValues();


            // Toast.makeText(getActivity().getApplicationContext(),"numero senhas : "+m, Toast.LENGTH_LONG).show();
            initialValues.put(Fields.getScore(), m);
            operationObj.updateTable(Fields.getTableName(), initialValues, condition);
        }


        operationObj.close();
    }



    public  void saveData3(){
        int m=0;
        dbOperation operationObj = new dbOperation(getActivity());
        operationObj.open();
        MyTable Fields = new MyTable();
        ContentValues initialValues = new ContentValues();

        initialValues.put(Fields.getScore(), m);
        operationObj.insertTableData(Fields.getTableName(), initialValues);

        operationObj.close();
    }



    /*
    public File getTempFile(Context context, String url) {
        File file;
        try {
            String fileName = Uri.parse(url).getLastPathSegment();
            file = File.createTempFile(fileName, null, context.getCacheDir());
            catch (IOException e) {
                // Error while creating file
            }
            return file;
        }


*/
}