package com.example.student.navdrawer;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Frag1 extends Fragment {


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
        TextView textView = (TextView) rootView.findViewById(R.id.section_label);
        //textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
        textView.setText("tesxtinho");

        return rootView;
    }
}
