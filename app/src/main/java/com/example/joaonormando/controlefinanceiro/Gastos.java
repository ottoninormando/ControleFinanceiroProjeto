package com.example.joaonormando.controlefinanceiro;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Gastos extends AppCompatActivity {

    EditText nomeGasto, valorGasto;
    Button btn_adicionar, btn_cancelar;
    Spinner parcelas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gastos);

        parcelas = (Spinner) findViewById(R.id.qntd_parcelas);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.quantidade_parcelas, android.R.layout.simple_spinner_item);
        parcelas.setAdapter(adapter);

        nomeGasto = findViewById(R.id.editText_nomeGasto);
        valorGasto = findViewById(R.id.editText_valorGasto);

        btn_adicionar = findViewById(R.id.btn_adicionar);
        btn_cancelar = findViewById(R.id.btn_cancelar);

        btn_cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Gastos.this,Main.class);
                startActivity(i);
            }
        });

        btn_adicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insert();
            }
        });

    }

    public void insert(){
        try {
            String gasto = nomeGasto.getText().toString();
            String valor = valorGasto.getText().toString();
            SQLiteDatabase db = openOrCreateDatabase("bd_controleFinanceiro", Context.MODE_PRIVATE, null);
            db.execSQL("CREATE TABLE IF NOT EXISTS gasto(id INTERGER PRIMARY KEY,gasto VARCHAR,valor VARCHAR)");

            String sql = "insert into gasto(gasto,valor)values(?,?)";
            SQLiteStatement statement = db.compileStatement(sql);
            statement.bindString(1,gasto);
            statement.bindString(1,valor);
            statement.execute();
            Toast.makeText(this, "Categoria adicionado com sucesso", Toast.LENGTH_SHORT).show();
            nomeGasto.setText("");
            valorGasto.setText("");
            nomeGasto.requestFocus();
        }catch (Exception ex){
            Toast.makeText(this, "Problema em adicionar", Toast.LENGTH_SHORT).show();
        }

    }

}
