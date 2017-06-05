package com.example.alexis.sh2016;

/**
 * Created by alexis on 11/06/16.
 */


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

//import info.androidhive.materialtabs.R;


public class TwoFragment extends Fragment{

    private ImageView button;
    private ImageView button2;
    private ImageView button3;


    public TwoFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View rootView = inflater.inflate(R.layout.fragment_two, container, false);




//________________________
        button = (ImageView) rootView.findViewById(R.id.imageView1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(v.getContext(), ViewPagerExampleActivity.class);
                startActivityForResult(intent, 0);

            }
        });


//_______________________
        button2 = (ImageView) rootView.findViewById(R.id.imageView2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(v.getContext(), ViewPagerExampleActivityDois.class);
                startActivityForResult(intent, 0);

/*


                final Animation zoomAnimation = AnimationUtils.loadAnimation(getActivity(), R.anim.zoom);
                button2.startAnimation(zoomAnimation);
                final Animation zoomAnimation2 = AnimationUtils.loadAnimation(getActivity(), R.anim.zoom2);
                button2.startAnimation(zoomAnimation2);
*/
            }
        });

//_______________________






        // Inflate the layout for this fragment

        //comentei isto
        //return inflater.inflate(R.layout.fragment_two, container, false);
        return rootView;
    }

}