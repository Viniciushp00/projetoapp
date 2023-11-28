package com.example.ideiaprojeto.Adapter;

import android.app.Notification;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ideiaprojeto.R;
import com.example.ideiaprojeto.model.Atividade;
import com.example.ideiaprojeto.model.Materia;
import com.example.ideiaprojeto.state.GerenciamentoEstados;

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
                Double nota = new Double(String.valueOf(holder.ntValor.getText()));
                if(nota<=10.0 && nota>=0.0) {
                    atividade.setNota(nota);
                }
                else{
                    holder.ntValor.setText(String.valueOf(atividade.getNota()));
                    Toast notificacao = Toast.makeText(GerenciamentoEstados.context.context,String.format("Nota %s invalida\n Insira um valor de 0 a 10",atividade.getNome()), Toast.LENGTH_LONG);
                    notificacao.show();
                }
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
