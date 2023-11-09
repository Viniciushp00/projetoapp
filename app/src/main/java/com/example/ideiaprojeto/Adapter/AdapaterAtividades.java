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
import com.example.ideiaprojeto.model.Atividade;
import com.example.ideiaprojeto.model.Materia;
import com.example.ideiaprojeto.state.GerenciamentoEstados;

import org.w3c.dom.Text;

public class AdapaterAtividades extends RecyclerView.Adapter<AdapaterAtividades.AtividadeViewHolder> {

    Materia materia;

    public AdapaterAtividades(Materia materia){
        this.materia = materia;
    }

    @NonNull
    @Override
    public AtividadeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_atividades,parent,false);
        AtividadeViewHolder holder = new AtividadeViewHolder(itemLista);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull AtividadeViewHolder holder, int position) {

        Atividade atividade = materia.getAtividades().get(position);
        holder.nomeAtividade.setText(atividade.getNome());
    }

    @Override
    public int getItemCount() {
        return materia.getAtividades().toArray().length;
    }

    public class AtividadeViewHolder extends  RecyclerView.ViewHolder {
        TextView nomeAtividade = itemView.findViewById(R.id.nome_atividades);
        Button btnConfiguracao = itemView.findViewById(R.id.btnConfiguracao);


        public AtividadeViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
