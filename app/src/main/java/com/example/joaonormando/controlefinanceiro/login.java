package com.example.joaonormando.controlefinanceiro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class login extends AppCompatActivity {
    EditText editText_usuario, editText_senha;
    Button btn_login, btn_sair;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        editText_usuario = findViewById(R.id.editText_usuario);
        editText_senha   = findViewById(R.id.editText_senha);

        btn_login = findViewById(R.id.btn_login);
        btn_sair  = findViewById(R.id.btn_sair);

        btn_sair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Login();
            }
        });
    }

    public void Login(){
        String username = editText_usuario.getText().toString();
        String senha    = editText_senha.getText().toString();

        if(username.equals("") || senha.equals("")){
            Toast.makeText(this, "Preencha os dois campos", Toast.LENGTH_SHORT).show();
        }
        else if(username.equals("joao") && senha.equals("1234")){
            Toast.makeText(this, "Logado com sucesso!", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "Usuário ou senha errados", Toast.LENGTH_SHORT).show();
        }
    }
}
