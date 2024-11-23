package com.br.pizzaria.pizza;

public enum PizzaCategorias {
    NORMAL(0.03),
    ESPECIAL(0.6),
    PREMIUM(0.08);

    private double valor;

    PizzaCategorias(double valor) {
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }
}