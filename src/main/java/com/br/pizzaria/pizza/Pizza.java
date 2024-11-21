package com.br.pizzaria.pizza;

import java.util.List;

public abstract class Pizza {
    protected List<String> sabores;
    protected double preco;
    protected double area;

    protected Pizza(List<String> sabores) {
        this.sabores = sabores;
    }

    public abstract double calcularArea();

    public abstract double calcularPreco();

    public double getPreco() {
        return preco;
    }

    public double getArea() {
        return area;
    }

    public List<String> getSabores() {
        return sabores;
    }
}
