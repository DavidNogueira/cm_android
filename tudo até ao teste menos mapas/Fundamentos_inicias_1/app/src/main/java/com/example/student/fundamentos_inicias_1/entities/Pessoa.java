package com.example.student.fundamentos_inicias_1.entities;

/**
 * Created by david on 29/03/17.
 */
public class Pessoa {
    public String nome;
    public String morada;
    public int idade;

    public Pessoa(String name, String hometown, int age) {
        this.nome = name;
        this.morada = hometown;
        this.idade = age;
    }

    public String getNome() {
        return nome;
    }

    public String getMorada() {
        return morada;
    }

    public int getIdade() {
        return idade;
    }


}
