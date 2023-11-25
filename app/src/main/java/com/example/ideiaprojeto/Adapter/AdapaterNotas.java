package com.example.ideiaprojeto.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ideiaprojeto.R;
import com.example.ideiaprojeto.model.Atividade;
import com.example.ideiaprojeto.model.Materia;

public class AdapaterNotas extends RecyclerView.Adapter<AdapaterNotas.NotasViewHolder> {

    Materia materia;

    public AdapaterNotas(Materia materia){
        this.materia = materia;
    }

    @NonNull
    @Override
    public NotasViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.notas,parent,false);
        NotasViewHolder holder = new NotasViewHolder(itemLista);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull NotasViewHolder holder, int position) {

        Atividade atividade = materia.getAtividades().get(position);
        holder.nmAtividade.setText(atividade.getNome());
        holder.ntValor.setText(String.valueOf(atividade.getNota()));
        holder.atividade = atividade;

        holder.ntValor.setOnFocusChangeListener((view, hasfocus) -> {
            if(!hasfocus){
                atividade.setNota( new Double(String.valueOf(holder.ntValor.getText())));
            }
        });
    }

    @Override
    public int getItemCount() {
        return materia.getAtividades().toArray().length;
    }

    public class NotasViewHolder extends  RecyclerView.ViewHolder {

        Atividade atividade;
        TextView nmAtividade = itemView.findViewById(R.id.nmAtividade);

        EditText ntValor = itemView.findViewById(R.id.ntValor);


        public NotasViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
