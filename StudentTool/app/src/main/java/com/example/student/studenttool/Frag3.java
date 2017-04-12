package com.example.student.studenttool;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Frag3 extends Fragment {


    private static final String ARG_SECTION_NUMBER = "section_number";
    public Frag3(){

    }

    public static Frag3 newInstance(){

        Frag3 fragment = new Frag3();
        return fragment;

    }
    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        View rootView = inflater.inflate(R.layout.frag3, container, false);
        return rootView;
    }
}
