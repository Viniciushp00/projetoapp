package com.example.ideiaprojeto;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.ideiaprojeto.Adapter.AdapterMateria;
import com.example.ideiaprojeto.state.GerenciamentoEstados;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GerenciamentoEstados.setContext(this);

        RecyclerView recycleView_materias = findViewById(R.id.recycleView_materias);
        recycleView_materias.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));
        //Para dar mais desempenho a lista
        recycleView_materias.setHasFixedSize(true);

        //Configuração do Adapter
        AdapterMateria adapter = new AdapterMateria();
        recycleView_materias.setAdapter(adapter);
    }
}