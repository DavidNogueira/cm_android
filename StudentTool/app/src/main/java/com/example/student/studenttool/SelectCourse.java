package com.example.student.studenttool;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class SelectCourse extends FragmentActivity implements AdapterView.OnItemSelectedListener {


    Spinner spinner;
    ImageView imgViewHorario;
    ImageView imgViewPlantaZero;
    ImageView imgEmenta;

    Button ok;
    Button cancela;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_select_course);

        spinner = (Spinner) findViewById(R.id.spinner);

        ArrayAdapter adapter = ArrayAdapter.createFromResource(this,R.array.Curso,android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);


        ok = (Button) findViewById(R.id.button);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                //temos que mudar isto
                        Intent intent = new Intent(v.getContext(), MainActivity_tabs.class);
                startActivityForResult(intent, 0);

            }
        });

        cancela = (Button) findViewById(R.id.button6);
        cancela.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                //temos que mudar isto
                Intent intent = new Intent(v.getContext(), MainActivity_tabs.class);
                startActivityForResult(intent, 0);

            }
        });



        // Log.d("David", "Bem-Vindo");
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        TextView myText = (TextView) view;
        Toast.makeText(this,"Seleccionas-te " + myText.getText(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
