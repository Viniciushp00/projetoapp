package com.example.ideiaprojeto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.ideiaprojeto.model.Atividade;
import com.example.ideiaprojeto.state.GerenciamentoEstados;

import org.w3c.dom.Text;

public class activity_configuracao extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracao);

        Atividade atividade = GerenciamentoEstados.atualAtividade;

        EditText nomeAtividade = findViewById(R.id.nomeatividade);

        EditText pesoAtividade = findViewById(R.id.pesoatividade);

        Button btnSalvar = findViewById(R.id.btnSalvarAlteracaoAtividade);

        TextView tituloPagina = findViewById(R.id.textprincconfig);

        String nomeAtv = atividade.getNome();

        tituloPagina.setText(nomeAtv);
        nomeAtividade.setText(atividade.getNome());
        pesoAtividade.setText(String.valueOf(atividade.getPeso()));

        btnSalvar.setOnClickListener((View -> {

            String nome = String.valueOf(nomeAtividade.getText());
            Integer peso = Integer.parseInt(pesoAtividade.getText().toString());

            atividade.setNome(nome);
            atividade.setPeso(peso);

            finish();
        }));

    }
}