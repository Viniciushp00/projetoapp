package com.example.ideiaprojeto.Adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ideiaprojeto.R;
import com.example.ideiaprojeto.listadeAtividades;
import com.example.ideiaprojeto.model.Materia;
import com.example.ideiaprojeto.state.GerenciamentoEstados;

public class AdapterMateria extends RecyclerView.Adapter<AdapterMateria.MateriaViewHolder> {


    @NonNull
    @Override
    public MateriaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_materias,parent,false);
        MateriaViewHolder holder = new MateriaViewHolder(itemLista);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MateriaViewHolder holder, int position) {

        Materia materia = GerenciamentoEstados.getMaterias().get(position);
        holder.nome.setText(materia.getNome());
        holder.materia = materia;
    }

    @Override
    public int getItemCount() {
        return GerenciamentoEstados.getMaterias().toArray().length;
    }

    public class MateriaViewHolder extends  RecyclerView.ViewHolder {

        Materia materia;
        TextView nome = itemView.findViewById(R.id.nome_atividades);
        Button btnConfiguracao = itemView.findViewById(R.id.btnConfiguracao);
        Button btnCalculo = itemView.findViewById(R.id.btnCalcular);

        {
            btnConfiguracao.setOnClickListener((View -> {
                Intent telaListAtividades = new Intent(GerenciamentoEstados.context.context.getApplicationContext(), listadeAtividades.class);
                GerenciamentoEstados.atualMateria = materia;
                GerenciamentoEstados.context.context.startActivity(telaListAtividades);
            }));
        }

        public MateriaViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
