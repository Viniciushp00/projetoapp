package com.example.ideiaprojeto.state;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ideiaprojeto.model.AppContext;
import com.example.ideiaprojeto.model.Atividade;
import com.example.ideiaprojeto.model.Materia;

import java.util.ArrayList;
import java.util.List;

public class GerenciamentoEstados {
    public static final AppContext context;

    public static Materia atualMateria;

    public static Atividade atualAtividade;

    static {
        context = AppContext.builder().context(null).atividades(new ArrayList<Materia>()).build();
        context.materias.add(
                Materia.builder()
                        .nome("Sistemas")
                        .atividades(
                                List.of(
                                        Atividade.builder()
                                            .nome("A1")
                                            .peso(2)
                                            .nota(6.0)
                                            .build()
                                        ,Atividade.builder()
                                                .nome("A2")
                                                .peso(4)
                                                .nota(8.0)
                                                .build()
                                )

                        )
                        .build()
        );
        context.materias.add(
                Materia.builder()
                        .nome("Linguagem de Automatos")
                        .atividades(
                                List.of(
                                        Atividade.builder()
                                                .nome("Dahora")
                                                .peso(2)
                                                .nota(6.0)
                                                .build()
                                        ,Atividade.builder()
                                                .nome("Funciona")
                                                .peso(4)
                                                .nota(8.0)
                                                .build()
                                )

                        )
                        .build()
        );

        context.materias.add(
                Materia.builder()
                        .nome("Matematica")
                        .atividades(
                                List.of(
                                        Atividade.builder()
                                                .nome("A1")
                                                .peso(2)
                                                .nota(6.0)
                                                .build()
                                        ,Atividade.builder()
                                                .nome("A2")
                                                .peso(4)
                                                .nota(8.0)
                                                .build()
                                )

                        )
                        .build()
        );
        context.materias.add(
                Materia.builder()
                        .nome("Matematica")
                        .atividades(
                                List.of(
                                        Atividade.builder()
                                                .nome("A1")
                                                .peso(2)
                                                .nota(6.0)
                                                .build()
                                        ,Atividade.builder()
                                                .nome("A2")
                                                .peso(4)
                                                .nota(8.0)
                                                .build()
                                )

                        )
                        .build()
        );
        context.materias.add(
                Materia.builder()
                        .nome("Matematica")
                        .atividades(
                                List.of(
                                        Atividade.builder()
                                                .nome("A1")
                                                .peso(2)
                                                .nota(6.0)
                                                .build()
                                        ,Atividade.builder()
                                                .nome("A2")
                                                .peso(4)
                                                .nota(8.0)
                                                .build()
                                )

                        )
                        .build()
        );
        context.materias.add(
                Materia.builder()
                        .nome("Matematica")
                        .atividades(
                                List.of(
                                        Atividade.builder()
                                                .nome("A1")
                                                .peso(2)
                                                .nota(6.0)
                                                .build()
                                        ,Atividade.builder()
                                                .nome("A2")
                                                .peso(4)
                                                .nota(8.0)
                                                .build()
                                )

                        )
                        .build()
        );
    }

    public static List<Materia> getMaterias() {
        return context.materias;
    }

    public static void setContext(AppCompatActivity cont){
        context.context = cont;
    }

    public static void addMateria(String nomeMateria){
        context.materias.add(
                Materia.builder().
                        nome(nomeMateria).
                        atividades(
                                List.of(

                                )
                        ).build()
        );
    }


}
