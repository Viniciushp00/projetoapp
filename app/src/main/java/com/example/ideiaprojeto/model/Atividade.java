package com.example.ideiaprojeto.model;

import java.util.List;

public class Atividade {

    private String nome;

    private Integer peso;

    private Double nota;

    private Atividade(AtividadeBuilder builder) {
        this.nome = builder.nome;
        this.peso = builder.peso;
        this.nota = builder.nota;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getPeso() {
        return peso;
    }

    public void setPeso(Integer peso) {
        this.peso = peso;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    public static AtividadeBuilder builder() {
        return new AtividadeBuilder();
    }

    public static class AtividadeBuilder {

        String nome;
        Integer peso;
        Double nota;

        public AtividadeBuilder nome(String nome) {
            this.nome = nome;
            return this;
        }

        public AtividadeBuilder peso(Integer peso) {
            this.peso = peso;
            return this;
        }

        public AtividadeBuilder nota(Double nota) {
            this.nota = nota;
            return this;
        }

        public Atividade build() {
            return new Atividade(this);
        }

    }

}
