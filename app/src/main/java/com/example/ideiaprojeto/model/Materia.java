package com.example.ideiaprojeto.model;

import java.io.Serializable;
import java.util.List;

public class Materia implements Serializable {

    String nome;

    List<Atividade> atividades;

    private Materia(MateriaBuilder builder) {
        this.nome = builder.nome;
        this.atividades = builder.atividades;
    }
    public String getNome() {
        return nome;
    }

    public List<Atividade> getAtividades() {
        return atividades;
    }

    public static MateriaBuilder builder() {
        return new MateriaBuilder();
    }

    public static class MateriaBuilder {

        String nome;

        List<Atividade> atividades;

        public MateriaBuilder nome(String nome) {
            this.nome = nome;
            return this;
        }

        public MateriaBuilder atividades(List<Atividade> atividades) {
            this.atividades = atividades;
            return this;
        }

        public Materia build() {
            return new Materia(this);
        }

    }

}
