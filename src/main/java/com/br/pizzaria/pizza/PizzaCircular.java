package com.br.pizzaria.pizza;

import java.util.List;

public class PizzaCircular extends Pizza {
    private double raio;

    public PizzaCircular(List<String> sabores, double raio) {
        super(sabores);
        this.raio = raio;
        this.area = calcularArea();
        this.preco = calcularPreco();
    }

    @Override
    public double calcularArea() {
        return Math.PI * raio * raio;
    }

    @Override
    public double calcularPreco() {
        // Implement price calculation logic based on area and sabores
        return area * 1.0; // Example calculation
    }

    public double getRaio() {
        return raio;
    }
}
