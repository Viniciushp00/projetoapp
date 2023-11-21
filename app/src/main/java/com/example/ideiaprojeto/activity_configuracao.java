package com.example.ideiaprojeto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import com.example.ideiaprojeto.model.Atividade;
import com.example.ideiaprojeto.state.GerenciamentoEstados;

public class activity_configuracao extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracao);

        Atividade atividade = GerenciamentoEstados.atualAtividade;

        EditText nomeAtividade = findViewById(R.id.nomeatividade);

        EditText pesoAtividade = findViewById(R.id.pesoatividade);



    }
}