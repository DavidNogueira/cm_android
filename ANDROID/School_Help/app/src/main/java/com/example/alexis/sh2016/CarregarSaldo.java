package com.example.alexis.sh2016;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.OutputStreamWriter;

public class CarregarSaldo extends AppCompatActivity {


    private Button confirma;
    private Button cancela;
    private EditText saldomais;
    private TextView numSaldo;
    private Double tot;

    private final static String STORETEXT="storetext8.txt";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carregar_saldo);


        numSaldo = (TextView) findViewById(R.id.textView90);
        numSaldo.setText(getIntent().getExtras().getString("num"));
        tot = Double.parseDouble(getIntent().getExtras().getString("num"));
        saldomais = (EditText) findViewById(R.id.editText);

        confirma = (Button) findViewById(R.id.button10);
        confirma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    OutputStreamWriter out= new OutputStreamWriter(openFileOutput(STORETEXT, 0));

                    tot = tot + Double.parseDouble(saldomais.getText().toString());
                    out.write(String.valueOf(tot));
                    out.close();
                    //Toast.makeText(getApplicationContext(),"The contents are saved in the file.", Toast.LENGTH_LONG).show();
                }
                catch (Throwable t) {
                   // Toast.makeText(getApplicationContext(),"Exception: "+t.toString(), Toast.LENGTH_LONG).show();
                }

                Toast.makeText(getApplicationContext(), "Carregamento feito com sucesso!", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(v.getContext(), Tabbed.class);

                intent.putExtra("num2", saldomais.getText().toString());
                setResult(RESULT_OK, intent);
                finish();

            }
        });


        cancela = (Button) findViewById(R.id.button9);
        cancela.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();


            }
        });

    }


}