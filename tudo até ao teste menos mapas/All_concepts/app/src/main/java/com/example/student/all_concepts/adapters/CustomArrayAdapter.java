package com.example.student.all_concepts.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.student.all_concepts.R;
import com.example.student.all_concepts.entities.Pessoa;

import java.util.ArrayList;

public class CustomArrayAdapter extends ArrayAdapter<Pessoa> {

    public CustomArrayAdapter(Context context, ArrayList<Pessoa> users){
        super(context,0,users);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        Pessoa p = getItem(position);

        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.layout_linha, parent, false);
        }

        ((TextView) convertView.findViewById(R.id.nome)).setText(p.getNome());
        ((TextView) convertView.findViewById(R.id.morada)).setText(p.getMorada());
        ((TextView) convertView.findViewById(R.id.idade)).setText(""+p.getIdade());



        return convertView;
    }

}