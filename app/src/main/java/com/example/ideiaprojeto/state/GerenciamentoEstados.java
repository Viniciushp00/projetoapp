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
                                List.of(new Atividade())
                        )
        );
    }

    public static List<Materia> getMaterias() {
        return materias;
    }

}
