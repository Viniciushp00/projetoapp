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

    Button btnAddMateria;

    RecyclerView recycleView_materias;

    AdapterMateria adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GerenciamentoEstados.setContext(this);

        btnAddMateria = findViewById(R.id.addMateria);
        recycleView_materias = findViewById(R.id.recycleView_materias);

        recycleView_materias.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));
        //Para dar mais desempenho a lista
        recycleView_materias.setHasFixedSize(true);

        //Configuração do Adapter
        adapter = new AdapterMateria();
        recycleView_materias.setAdapter(adapter);

        btnAddMateria.setOnClickListener((View -> {
            Intent telaCriacaoMateria = new Intent(this, criacaodenovamateria.class);
            telaCriacaoMateria.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(telaCriacaoMateria);
        }));
    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter.notifyDataSetChanged();
    }
}