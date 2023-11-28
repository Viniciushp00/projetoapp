package com.example.ideiaprojeto;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ideiaprojeto.Adapter.AdapaterAtividades;
import com.example.ideiaprojeto.Adapter.AdapaterNotas;
import com.example.ideiaprojeto.model.Atividade;
import com.example.ideiaprojeto.model.Materia;
import com.example.ideiaprojeto.state.CalculoUtil;
import com.example.ideiaprojeto.state.GerenciamentoEstados;

public class calculo extends AppCompatActivity {

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            View v = getCurrentFocus();
            if ( v instanceof EditText) {
                Rect outRect = new Rect();
                v.getGlobalVisibleRect(outRect);
                if (!outRect.contains((int)event.getRawX(), (int)event.getRawY())) {
                    Log.d("focus", "touchevent");
                    v.clearFocus();
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                }
            }
        }
        return super.dispatchTouchEvent(event);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculo);

        Materia materia = GerenciamentoEstados.atualMateria;

        Button btnCalcularNota = findViewById(R.id.btnCalcularNota);

        TextView apresentaNota = findViewById(R.id.NotaFinal);

        EditText aps = findViewById(R.id.notaAPS);

        EditText notaN2 = findViewById(R.id.NotaN2);


        aps.setText(String.format("%.1f",materia.getAps()));
        notaN2.setText(String.format("%.1f",materia.getNotaN2()));


        aps.setOnFocusChangeListener((view, hasfocus) -> {

            if(!hasfocus){
                Double nota = new Double(String.valueOf(aps.getText()));
                if(nota<=10 && nota>=0) {
                    materia.setAps(nota);
                }
                else{
                    aps.setText(String.valueOf(materia.getAps()));
                    Toast notificacao = Toast.makeText(this,"Nota da APS invalida\nInsira um valor de 0 a 10", Toast.LENGTH_LONG);
                    notificacao.show();
                }
            }
        });

        notaN2.setOnFocusChangeListener((view, hasfocus) -> {
            if(!hasfocus){
                Double nota = new Double(String.valueOf(notaN2.getText()));
                if(nota<=10 && nota>=0) {
                    materia.setNotaN2(nota);
                }
                else{
                    notaN2.setText(String.valueOf(materia.getNotaN2()));
                    Toast notificacao = Toast.makeText(this,"Nota Prova Final invalida\nInsira um valor de 0 a 10", Toast.LENGTH_LONG);
                    notificacao.show();
                }
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