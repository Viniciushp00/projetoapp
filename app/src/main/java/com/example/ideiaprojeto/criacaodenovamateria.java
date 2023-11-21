package com.example.ideiaprojeto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.ideiaprojeto.state.GerenciamentoEstados;

public class criacaodenovamateria extends AppCompatActivity {

    EditText nomeMateria;

    EditText valortAtividade;

    Button btnSalvar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criacaodenovamateria);


        nomeMateria = findViewById(R.id.nomeMateria);
        valortAtividade = findViewById(R.id.valorAtt1);
        btnSalvar = findViewById(R.id.btnSalvar);

        btnSalvar.setOnClickListener((View -> {

            String nome = String.valueOf(nomeMateria.getText());

            GerenciamentoEstados.addMateria(nome);

            Intent telaInicial = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(telaInicial);
        }));



    }
}