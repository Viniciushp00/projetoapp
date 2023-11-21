package com.example.ideiaprojeto;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.ideiaprojeto.Adapter.AdapterMateria;
import com.example.ideiaprojeto.state.GerenciamentoEstados;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GerenciamentoEstados.setContext(this);

        Button btnAddMateria = findViewById(R.id.addMateria);

        RecyclerView recycleView_materias = findViewById(R.id.recycleView_materias);
        recycleView_materias.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));
        //Para dar mais desempenho a lista
        recycleView_materias.setHasFixedSize(true);

        //Configuração do Adapter
        AdapterMateria adapter = new AdapterMateria();
        recycleView_materias.setAdapter(adapter);

        btnAddMateria.setOnClickListener((View -> {
            Intent telaCriacaoMateria = new Intent(getApplicationContext(), criacaodenovamateria.class);
            startActivity(telaCriacaoMateria);
        }));
    }
}