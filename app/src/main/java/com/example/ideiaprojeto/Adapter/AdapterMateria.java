package com.example.ideiaprojeto.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ideiaprojeto.R;
import com.example.ideiaprojeto.model.Materia;
import com.example.ideiaprojeto.state.GerenciamentoEstados;

import java.util.List;

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
    }

    @Override
    public int getItemCount() {
        return GerenciamentoEstados.getMaterias().toArray().length;
    }

    public class MateriaViewHolder extends  RecyclerView.ViewHolder {
        TextView nome = itemView.findViewById(R.id.nome_materia);

        public MateriaViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
