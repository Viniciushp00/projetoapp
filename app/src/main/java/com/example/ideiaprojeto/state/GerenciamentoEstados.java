package com.example.ideiaprojeto.state;

import com.example.ideiaprojeto.model.Atividade;
import com.example.ideiaprojeto.model.Materia;

import java.util.ArrayList;
import java.util.List;

public class GerenciamentoEstados {

    private static final List<Materia> materias = new ArrayList<>();

    static {
        materias.add(
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
        materias.add(
                Materia.builder()
                        .nome("Linguagem de Automatos")
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
        return materias;
    }

}
