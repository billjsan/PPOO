package com.ifpe.ppro.decorator;

public abstract class Bebida {
    private final String descricao;

    public Bebida(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao(){
        return descricao;
    }

    public abstract double getPreco();
}
