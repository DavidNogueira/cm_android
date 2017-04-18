package com.example.student.studenttool.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.student.studenttool.R;
import com.example.student.studenttool.entities.Ementa;

import java.util.ArrayList;

public class CustomArrayAdapter extends ArrayAdapter<Ementa> {

    public CustomArrayAdapter(Context context, ArrayList<Ementa> users){
        super(context,0,users);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        Ementa p = getItem(position);

        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.layout_linha_ementa, parent, false);
        }

       /* ((TextView) convertView.findViewById(R.id.qtdsaldo)).setText(p.g());
        ((TextView) convertView.findViewById(R.id.morada)).setText(p.getMorada());
        ((TextView) convertView.findViewById(R.id.idade)).setText(""+p.getIdade());

*/

        return convertView;
    }

}
