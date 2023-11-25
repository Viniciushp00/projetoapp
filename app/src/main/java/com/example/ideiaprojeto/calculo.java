package com.example.ideiaprojeto;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.ideiaprojeto.Adapter.AdapaterAtividades;
import com.example.ideiaprojeto.Adapter.AdapaterNotas;
import com.example.ideiaprojeto.model.Atividade;
import com.example.ideiaprojeto.model.Materia;
import com.example.ideiaprojeto.state.CalculoUtil;
import com.example.ideiaprojeto.state.GerenciamentoEstados;

public class calculo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculo);

        Materia materia = GerenciamentoEstados.atualMateria;

        Button btnCalcularNota = findViewById(R.id.btnCalcularNota);

        TextView apresentaNota = findViewById(R.id.NotaFinal);

        EditText aps = findViewById(R.id.notaAPS);

        EditText notaN2 = findViewById(R.id.NotaN2);


        aps.setText(String.format("%.2f",materia.getAps()));
        notaN2.setText(String.format("%.2f",materia.getNotaN2()));


        aps.setOnFocusChangeListener((view, hasfocus) -> {
            if(!hasfocus){
                materia.setAps( new Double(String.valueOf(aps.getText())));
            }
        });

        notaN2.setOnFocusChangeListener((view, hasfocus) -> {
            if(!hasfocus){
                materia.setNotaN2( new Double(String.valueOf(notaN2.getText())));
            }
        });



        RecyclerView recycleView_atividades = findViewById(R.id.recyclerviewAtividadeCalc);
        recycleView_atividades.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        //Para dar mais desempenho a lista
        recycleView_atividades.setHasFixedSize(true);

        //Configuração do Adapter
        AdapaterNotas adapter = new AdapaterNotas(materia);
        recycleView_atividades.setAdapter(adapter);

        btnCalcularNota.setOnClickListener((View -> {

            apresentaNota.setText(String.format("Sua nota foi %.2f",CalculoUtil.calcularMediaFinal(materia) ) );

        }));

    }
}