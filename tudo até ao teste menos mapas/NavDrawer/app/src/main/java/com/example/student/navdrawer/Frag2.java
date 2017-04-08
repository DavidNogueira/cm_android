package com.example.student.navdrawer;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Frag2 extends Fragment {


    private static final String ARG_SECTION_NUMBER = "section_number";
    public Frag2(){

    }

    public static Frag2 newInstance(){

        Frag2 fragment = new Frag2();
        return fragment;

    }
    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        View rootView = inflater.inflate(R.layout.frag2, container, false);
        TextView textView = (TextView) rootView.findViewById(R.id.section_label);
        textView.setText("TEXTO DO CRL");
        return rootView;
    }
}
