package com.example.ideiaprojeto.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Materia implements Serializable {

    String nome;

    List<Atividade> atividades;

    Double notaN2;
    Double aps;

    private Materia(MateriaBuilder builder) {
        this.nome = builder.nome;
        this.atividades = builder.atividades;
        this.notaN2 = builder.notaN2;
        this.aps = builder.aps;
    }
    public String getNome() {
        return nome;
    }

    public void setNotaN2(Double notaN2) {
        this.notaN2 = notaN2;
    }

    public void setAps(Double aps) {
        this.aps = aps;
    }

    public Double getAps() {
        return aps;
    }

    public List<Atividade> getAtividades() {
        return atividades;
    }

    public Double getNotaN2() {
        return notaN2;
    }

    public static MateriaBuilder builder() {
        return new MateriaBuilder();
    }

    public static class MateriaBuilder {

        String nome;

        List<Atividade> atividades;

        Double notaN2;

        Double aps;

        public MateriaBuilder nome(String nome) {
            this.nome = nome;
            return this;
        }

        public MateriaBuilder atividades(List<Atividade> atividades) {
            this.atividades = atividades;
            return this;
        }

        public MateriaBuilder notaN2 (Double notaN2){
            this.notaN2 = notaN2;
            return this;
        }

        public MateriaBuilder aps (Double aps){
            this.aps = aps;
            return this;
        }

        public Materia build() {
            return new Materia(this);
        }

    }



}
