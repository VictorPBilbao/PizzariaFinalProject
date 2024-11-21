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

    @Override
    public double calcularArea() {
        return (Math.sqrt(3) / 4) * lado * lado;
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
