package com.example.student.fundamentos_inicias_1.adapters;

import android.content.Context;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.student.fundamentos_inicias_1.R;
import com.example.student.fundamentos_inicias_1.entities.Pessoa;

import java.util.ArrayList;

/**
 * Created by david on 29/03/17.
 */
public class CustomArrayAdapter extends ArrayAdapter <Pessoa>{

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
