package com.example.joaonormando.controlefinanceiro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class Main extends AppCompatActivity {

    Button btn_lancar_gastos, btn_visualizar_gastos, btn_configuracoes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_lancar_gastos = findViewById(R.id.btn_lancar_gastos);
        btn_visualizar_gastos = findViewById(R.id.btn_visualizar_gastos);
        btn_configuracoes = findViewById(R.id.btn_configuracoes);

        btn_lancar_gastos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Main.this,Gastos.class);
                startActivity(i);
            }
        });
    }

}
