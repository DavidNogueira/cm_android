package com.example.student.nogueiradavid;


        import android.content.ContentValues;
        import android.database.sqlite.SQLiteDatabase;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.EditText;
        import android.widget.Toast;

        import com.example.student.nogueiradavid.db.Contrato;
        import com.example.student.nogueiradavid.db.DB;

public class Atividade4 extends AppCompatActivity {


    DB mDbHelper;
    SQLiteDatabase db;

    public EditText editNome;
    public EditText editIdade;
    public EditText editIdCidade;

    public String nome;
    public int idade;
    public int id_cidade;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atividade4);



        mDbHelper = new DB(this);
        db = mDbHelper.getReadableDatabase();//declaração da bd


        editNome = (EditText) findViewById(R.id.edit1);
        editIdade = (EditText) findViewById(R.id.edit2);//para a pass
        editIdCidade = (EditText) findViewById(R.id.edit3);




    }



    public void botaoinsert(View v) {

        nome = editNome.getText().toString();
        idade = Integer.parseInt(editIdade.getText().toString());
        id_cidade = Integer.parseInt(editIdCidade.getText().toString());

        ContentValues cv = new ContentValues();
        //cv.put(Contrato.Pessoa._ID, 7);
        cv.put(Contrato.Pessoa.COLUMN_NOME, nome);
        cv.put(Contrato.Pessoa.COLUMN_IDADE, idade);
        cv.put(Contrato.Pessoa.COLUMN_ID_CIDADE, id_cidade);
        db.insert(Contrato.Pessoa.TABLE_NAME, null, cv);

        finish();

    }

    @Override
    protected void onDestroy(){
        super.onDestroy();


        if (db.isOpen()){
            db.close();
            db = null;
        }

    }
}