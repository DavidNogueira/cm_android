package com.example.student.studenttool.adapters;


import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;



import com.example.student.studenttool.R;
import com.example.student.studenttool.db.Contrato;

/**
 * Created by david on 31/03/17.
 */
public class MyCursorAdapter extends CursorAdapter {

    private Context mContext;
    private int id;
    private Cursor mCursor;

    public MyCursorAdapter (Context context, Cursor c){

        super(context, c, 0);
        mContext = context;
        mCursor = c;
    }


    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent){

        return LayoutInflater.from(context).inflate(R.layout.linha, parent, false);
    }

    @Override
    public void bindView(View mView, Context context, Cursor cursor){

        TextView text1 = (TextView) mView.findViewById(R.id.nome);
        TextView text2 = (TextView) mView.findViewById(R.id.cidade);
        TextView text3 = (TextView) mView.findViewById(R.id.idade);

        text1.setText(mCursor.getString(cursor.getColumnIndexOrThrow(Contrato.Disciplina.COLUMN_NOME_DISCIPLINA)));
        text2.setText(mCursor.getString(cursor.getColumnIndexOrThrow(Contrato.Disciplina.COLUMN_NOME_DISCIPLINA)));
        text3.setText(String.valueOf(mCursor.getString(cursor.getColumnIndexOrThrow(Contrato.Associa.COLUMN_ID_DISCIPLINA))));

    }

}
