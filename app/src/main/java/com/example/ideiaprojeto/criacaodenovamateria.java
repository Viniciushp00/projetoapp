package com.example.ideiaprojeto;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.ideiaprojeto.state.GerenciamentoEstados;

public class criacaodenovamateria extends AppCompatActivity {

    EditText nomeMateria;
    Button btnSalvar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criacaodenovamateria);
        nomeMateria = findViewById(R.id.nomeMateria);
        btnSalvar = findViewById(R.id.btnSalvar);

        btnSalvar.setOnClickListener((View -> {

            String nome = String.valueOf(nomeMateria.getText());

            GerenciamentoEstados.addMateria(nome);

            finish();
        }));



    }
}