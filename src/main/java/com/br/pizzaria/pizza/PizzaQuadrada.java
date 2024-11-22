package com.br.pizzaria.pizza;

import java.util.List;

public class PizzaQuadrada extends Pizza {
    private static final double MIN_LADO = 10.0;
    private static final double MAX_LADO = 40.0;
    private static final double MIN_AREA = MIN_LADO * MIN_LADO;
    private static final double MAX_AREA = MAX_LADO * MAX_LADO;
    private double lado;

    public PizzaQuadrada(List<String> sabores, double lado) {
        super(sabores);
        if (lado < MIN_LADO || lado > MAX_LADO) {
            throw new IllegalArgumentException("Lado deve estar entre " + MIN_LADO + " e " + MAX_LADO + " cm.");
        }
        this.lado = lado;
        this.area = calcularArea();
        if (area < MIN_AREA || area > MAX_AREA) {
            throw new IllegalArgumentException("Área deve estar entre " + MIN_AREA + " e " + MAX_AREA + " cm².");
        }
        this.preco = calcularPreco();
    }

    public PizzaQuadrada(List<String> sabores, int tamanho) {
        super(sabores);
        this.lado = Math.sqrt(tamanho);
        if (lado < MIN_LADO || lado > MAX_LADO) {
            throw new IllegalArgumentException("Lado deve estar entre " + MIN_LADO + " e " + MAX_LADO + " cm.");
        }
        this.area = calcularArea();
        if (area < MIN_AREA || area > MAX_AREA) {
            throw new IllegalArgumentException("Área deve estar entre " + MIN_AREA + " e " + MAX_AREA + " cm².");
        }
        this.preco = calcularPreco();
    }

    public static double getMinLado() {
        return MIN_LADO;
    }

    public static double getMaxLado() {
        return MAX_LADO;
    }

    public static double getMinArea() {
        return MIN_AREA;
    }

    public static double getMaxArea() {
        return MAX_AREA;
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
