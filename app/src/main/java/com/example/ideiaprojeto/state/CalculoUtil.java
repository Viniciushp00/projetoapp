package com.example.ideiaprojeto.state;

import com.example.ideiaprojeto.model.Materia;

public final class CalculoUtil {

    private CalculoUtil (){
    }

    public static Double calcularMediaFinal(Materia materia){

        return calcularMediaN1(materia) + calcularMediaN2(materia);
    }

    private static Double calcularMediaN1(Materia materia){

        return (materia.getAtividades().stream().map(atividade -> atividade.getPeso() * atividade.getNota()).reduce((atual,somatorio) ->
            somatorio += atual).orElse(0.0d)/materia.getAtividades().stream().map(atividade -> atividade.getPeso()).reduce((atual,somatorio) ->
                somatorio += atual).orElse(0)) * 0.4;
    }

    private static Double calcularMediaN2(Materia materia){

        return ((materia.getNotaN2() * 0.9) + (materia.getAps() * 0.1)) * 0.6;
    }



}
