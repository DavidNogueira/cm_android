package com.example.student.studenttool;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Frag2 extends Fragment {

    private Button button;

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



        Button btn = (Button) rootView.findViewById(R.id.button52);



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                //getActivity().finish();

                Intent intent = new Intent(v.getContext(), Mapa.class);
                startActivityForResult(intent, 1);

            }
        });




        return rootView;
    }






}
