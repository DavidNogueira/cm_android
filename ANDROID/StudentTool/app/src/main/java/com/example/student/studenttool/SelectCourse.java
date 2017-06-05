package com.example.student.studenttool;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.student.studenttool.db.Contrato;
import com.example.student.studenttool.db.DB;

import java.util.List;

public class SelectCourse extends FragmentActivity implements AdapterView.OnItemSelectedListener {



    TextView myTextSelected;
    int idSelected;



    Spinner spinner;
    ImageView imgViewHorario;
    ImageView imgViewPlantaZero;
    ImageView imgEmenta;

    Button ok;
    Button cancela;


    DB mDbHelper;
    SQLiteDatabase db;

    Cursor c, c_pessoas;
    ListView lista, lista2;
    SimpleCursorAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_select_course);

        spinner = (Spinner) findViewById(R.id.spinner);

//possivelmente
   //     mDbHelper = new DB(SelectCourse.this);

        mDbHelper = new DB(this);
        db = mDbHelper.getReadableDatabase();//declaração da bd

        loadSpinnerData();


        //ArrayAdapter adapter = ArrayAdapter.createFromResource(this,R.array.Curso,android.R.layout.simple_spinner_item);
        //spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);


        ok = (Button) findViewById(R.id.button);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();



                String bla = "SELECT "+ Contrato.Curso.TABLE_NAME +"."+ Contrato.Curso._ID +
                        " FROM "+ Contrato.Curso.TABLE_NAME +
                        " WHERE " + Contrato.Curso.COLUMN_NOME_CURSO + " = '" + myTextSelected.getText() + "'";

                c = db.rawQuery(bla, null);

                c.moveToPosition(0);

                int idCurso = c.getInt(0);


               // int idCurso = c.getInt(c.getColumnIndex(Contrato.Curso._ID));




                Intent i = new Intent(SelectCourse.this, SelectSubjects.class);

                String k = String.valueOf(idCurso);
                i.putExtra(Utils.CURSO, k);

                Toast.makeText(SelectCourse.this,  myTextSelected.getText() + " " + idCurso, Toast.LENGTH_SHORT).show();
                startActivity(i);

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





    }









    private void loadSpinnerData() {//preenche spinner

        DB dbb = new DB(getApplicationContext());
        List<String> lables = dbb.getAllLabels();

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, lables);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);
    }







    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        TextView myText = (TextView) view;
        Toast.makeText(this,"Seleccionas-te " + myText.getText(), Toast.LENGTH_SHORT).show();
        myTextSelected = (TextView) view;

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {


    }
}
