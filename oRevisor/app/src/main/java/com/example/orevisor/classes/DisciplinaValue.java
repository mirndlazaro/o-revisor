package com.example.orevisor.classes;

public class DisciplinaValue implements java.io.Serializable {

    private Long id;
    private String nome;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String toString(){
        return this.id + " " + this.nome;
    }

}
