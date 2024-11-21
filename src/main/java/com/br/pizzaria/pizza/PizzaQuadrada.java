package com.br.pizzaria.pizza;

import java.util.List;

public class PizzaQuadrada extends Pizza {
    private double lado;

    public PizzaQuadrada(List<String> sabores, double lado) {
        super(sabores);
        this.lado = lado;
        this.area = calcularArea();
        this.preco = calcularPreco();
    }

    public PizzaQuadrada(List<String> sabores, int tamanho) {
        super(sabores);
        this.lado = Math.sqrt(tamanho);
        this.area = calcularArea();
        this.preco = calcularPreco();
    }

    @Override
    public double calcularArea() {
        return lado * lado;
    }

    @Override
    public double calcularPreco() {
        // Implement price calculation logic based on area and sabores
        return area * 1.0; // Example calculation
    }

    public double getLado() {
        return lado;
    }
}
