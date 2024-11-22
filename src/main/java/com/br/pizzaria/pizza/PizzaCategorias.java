package com.br.pizzaria.pizza;

public enum PizzaCategorias {
    NORMAL(0.25),
    ESPECIAL(0.5),
    PREMIUM(1);

    private double valor;

    PizzaCategorias(double valor) {
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }
}
