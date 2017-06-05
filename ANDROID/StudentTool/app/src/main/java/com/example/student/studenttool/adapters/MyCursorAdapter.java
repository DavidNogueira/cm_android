package com.example.student.studenttool.adapters;


import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;



import com.example.student.studenttool.R;
import com.example.student.studenttool.db.Contrato;

import java.util.ArrayList;
import java.util.HashMap;


/**
 * Created by david on 31/03/17.
 */
public class MyCursorAdapter extends CursorAdapter {

    private ArrayList<Boolean> status = new ArrayList<Boolean>();
    private static LayoutInflater inflater = null;
    private ArrayList<HashMap<String, String>> data;
    Activity activity;



    //----
    boolean [] checkbox;



    private Context mContext;
    private int id;
    private Cursor mCursor;

    public MyCursorAdapter (Context context, Cursor c){

        super(context, c, 0);
        mContext = context;
        mCursor = c;

        //----
        checkbox = new boolean[c.getCount()];
    }


    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent){

        return LayoutInflater.from(context).inflate(R.layout.linha, parent, false);
    }

    @Override
    public void bindView(View mView, Context context, Cursor cursor){
        final int position=cursor.getPosition();

        CheckBox ch1 = (CheckBox) mView.findViewById(R.id.ch);
       // TextView text1 = (TextView) mView.findViewById(R.id.nomedisciplina);
        TextView text2 = (TextView) mView.findViewById(R.id.iddisciplina);



        ch1.setText(mCursor.getString(cursor.getColumnIndexOrThrow(Contrato.Disciplina.COLUMN_NOME_DISCIPLINA)));
        text2.setText(String.valueOf(mCursor.getString(cursor.getColumnIndexOrThrow(Contrato.Associa.COLUMN_ID_DISCIPLINA))));
        if(String.valueOf(mCursor.getString(cursor.getColumnIndexOrThrow(Contrato.Associa.COLUMN_CHECK))).equals("1")){
            ch1.setChecked(true);
        }else{
            ch1.setChecked(false);
        }


        //ch1.setChecked(checkbox[position]);

        ch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                checkbox[position] = isChecked;

            }});


    }



/*


    @Override
    public void bindView(View mView, Context context, Cursor cursor){
        CheckBox ch1 = (CheckBox) mView.findViewById(R.id.ch);
        // TextView text1 = (TextView) mView.findViewById(R.id.nomedisciplina);
        TextView text2 = (TextView) mView.findViewById(R.id.iddisciplina);


        ch1.setText(mCursor.getString(cursor.getColumnIndexOrThrow(Contrato.Disciplina.COLUMN_NOME_DISCIPLINA)));
        text2.setText(String.valueOf(mCursor.getString(cursor.getColumnIndexOrThrow(Contrato.Associa.COLUMN_ID_DISCIPLINA))));




    }
*/






}
