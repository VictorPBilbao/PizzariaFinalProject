package com.br.pizzaria.pizza;

import java.util.List;

public class PizzaTriangular extends Pizza {
    private double lado;

    public PizzaTriangular(List<String> sabores, double lado) {
        super(sabores);
        this.lado = lado;
        this.area = calcularArea();
        this.preco = calcularPreco();
    }

    public PizzaTriangular(List<String> sabores, int tamanho) {
        super(sabores);
        this.lado = (2 * Math.sqrt(tamanho)) / Math.pow(3, 1.0 / 4.0);
        this.area = calcularArea();
        this.preco = calcularPreco();
    }

    @Override
    public double calcularArea() {
        return lado * lado * (Math.sqrt(3) / 4);
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
