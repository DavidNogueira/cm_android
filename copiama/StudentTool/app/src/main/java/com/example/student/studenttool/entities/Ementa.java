package com.example.student.studenttool.entities;

/**
 * Created by david on 14/04/17.
 */

public class Ementa {
    public String nome_refeicao;
    public int id_senha;

    public Ementa(String nome_refeicao, String hometown, int id_senha) {
        this.nome_refeicao = nome_refeicao;
        this.id_senha = id_senha;
    }

    public String getNome_refeicao() {
        return nome_refeicao;
    }

    public void setNome_refeicao(String nome_refeicao) {
        this.nome_refeicao = nome_refeicao;
    }

    public int getId_senha() {
        return id_senha;
    }

    public void setId_senha(int id_senha) {
        this.id_senha = id_senha;
    }
}