package com.example.ideiaprojeto;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.widget.Button;

import com.example.ideiaprojeto.Adapter.AdapaterAtividades;
import com.example.ideiaprojeto.Adapter.AdapterMateria;
import com.example.ideiaprojeto.model.Atividade;
import com.example.ideiaprojeto.model.Materia;
import com.example.ideiaprojeto.state.GerenciamentoEstados;

import java.util.List;

public class listadeAtividades extends AppCompatActivity {


    AdapaterAtividades adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listade_atividades);

        Materia materia = GerenciamentoEstados.atualMateria;

        RecyclerView recycleView_atividades = findViewById(R.id.recyclerView_atividades);
        recycleView_atividades.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        //Para dar mais desempenho a lista
        recycleView_atividades.setHasFixedSize(true);

        //Configuração do Adapter
        adapter = new AdapaterAtividades(materia);
        recycleView_atividades.setAdapter(adapter);

        Button btnAddAtividade = findViewById(R.id.btnAddAtividade);


        btnAddAtividade.setOnClickListener((View -> {

            Atividade atividade = Atividade.builder()
                    .nome("Nova Materia")
                    .peso(1)
                    .nota(0.0)
                    .build();

            materia.getAtividades().add(atividade);
            adapter.notifyItemInserted(materia.getAtividades().indexOf(atividade));
        }));

    }

    @Override
    protected void onResume() {
        super.onResume();

        adapter.notifyDataSetChanged();
    }
}