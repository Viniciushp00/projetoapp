package com.example.ideiaprojeto.model;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class AppContext  {
    public AppCompatActivity context;

    public List<Materia> materias;

    private AppContext(AppContextBuilder builder) {
        this.context = builder.context;
        this.materias = builder.materias;
    }

    public static AppContext.AppContextBuilder builder() {
        return new AppContext.AppContextBuilder();
    }

    public static class AppContextBuilder {

        AppCompatActivity context;

        List<Materia> materias;

        public AppContext.AppContextBuilder context(AppCompatActivity context) {
            this.context = context;
            return this;
        }

        public AppContext.AppContextBuilder atividades(List<Materia> materias) {
            this.materias = materias;
            return this;
        }

        public AppContext build() {
            return new AppContext(this);
        }

    }
}

