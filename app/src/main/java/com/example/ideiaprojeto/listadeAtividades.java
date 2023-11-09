package com.example.ideiaprojeto;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.provider.Settings;

import com.example.ideiaprojeto.Adapter.AdapaterAtividades;
import com.example.ideiaprojeto.Adapter.AdapterMateria;
import com.example.ideiaprojeto.model.Atividade;
import com.example.ideiaprojeto.model.Materia;
import com.example.ideiaprojeto.state.GerenciamentoEstados;

import java.util.List;

public class listadeAtividades extends AppCompatActivity {

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
        AdapaterAtividades adapter = new AdapaterAtividades(materia);
        recycleView_atividades.setAdapter(adapter);



    }
}