package com.br.pizzaria.pizza;

public enum PizzaCategorias {
    NORMAL(0.05),
    ESPECIAL(0.08),
    PREMIUM(0.10);

    private double valor;

    PizzaCategorias(double valor) {
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}