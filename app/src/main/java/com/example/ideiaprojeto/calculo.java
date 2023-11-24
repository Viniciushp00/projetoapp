package com.example.ideiaprojeto;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.ideiaprojeto.Adapter.AdapaterAtividades;
import com.example.ideiaprojeto.Adapter.AdapaterNotas;
import com.example.ideiaprojeto.model.Materia;
import com.example.ideiaprojeto.state.GerenciamentoEstados;

public class calculo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculo);

        Materia materia = GerenciamentoEstados.atualMateria;

        RecyclerView recycleView_atividades = findViewById(R.id.recyclerviewAtividadeCalc);
        recycleView_atividades.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        //Para dar mais desempenho a lista
        recycleView_atividades.setHasFixedSize(true);

        //Configuração do Adapter
        AdapaterNotas adapter = new AdapaterNotas(materia);
        recycleView_atividades.setAdapter(adapter);

    }
}