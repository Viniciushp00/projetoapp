package com.example.ideiaprojeto.Adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ideiaprojeto.MainActivity;
import com.example.ideiaprojeto.R;
import com.example.ideiaprojeto.activity_configuracao;
import com.example.ideiaprojeto.listadeAtividades;
import com.example.ideiaprojeto.model.Atividade;
import com.example.ideiaprojeto.model.Materia;
import com.example.ideiaprojeto.state.GerenciamentoEstados;

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
        holder.atividade = atividade;

        holder.btnApagaAtividade.setOnClickListener((View -> {
            materia.getAtividades().remove(position);
            notifyItemRemoved(position);
        }));
    }

    @Override
    public int getItemCount() {
        return materia.getAtividades().toArray().length;
    }

    public class AtividadeViewHolder extends  RecyclerView.ViewHolder {

        Atividade atividade;
        TextView nomeAtividade = itemView.findViewById(R.id.nome_atividades);
        Button btnConfiguracao = itemView.findViewById(R.id.btnConfiguracaoAtividade);

        Button btnApagaAtividade = itemView.findViewById(R.id.btnExcluirAtividade);


        {
            btnConfiguracao.setOnClickListener((View -> {
                Intent telaConfiguracao = new Intent(GerenciamentoEstados.context.context.getApplicationContext(), activity_configuracao.class);
                GerenciamentoEstados.atualAtividade = atividade;
                GerenciamentoEstados.context.context.startActivity(telaConfiguracao);
            }));
        }


        public AtividadeViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
