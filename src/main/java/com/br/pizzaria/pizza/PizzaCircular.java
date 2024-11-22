package com.br.pizzaria.pizza;

import java.util.List;

public class PizzaCircular extends Pizza {
    private static final double MIN_RAIO = 7.0;
    private static final double MAX_RAIO = 23.0;
    private static final double MIN_AREA = Math.PI * MIN_RAIO * MIN_RAIO;
    private static final double MAX_AREA = Math.PI * MAX_RAIO * MAX_RAIO;
    private double raio;

    public PizzaCircular(List<String> sabores, double raio) {
        super(sabores);
        if (raio < MIN_RAIO || raio > MAX_RAIO) {
            throw new IllegalArgumentException("Raio deve estar entre " + MIN_RAIO + " e " + MAX_RAIO + " cm.");
        }
        this.raio = raio;
        this.area = calcularArea();
        if (area < MIN_AREA || area > MAX_AREA) {
            throw new IllegalArgumentException("Área deve estar entre " + MIN_AREA + " e " + MAX_AREA + " cm².");
        }
        this.preco = calcularPreco();
    }

    public PizzaCircular(List<String> sabores, int tamanho) {
        super(sabores);
        this.raio = Math.sqrt(tamanho / Math.PI);
        if (raio < MIN_RAIO || raio > MAX_RAIO) {
            throw new IllegalArgumentException("Raio deve estar entre " + MIN_RAIO + " e " + MAX_RAIO + " cm.");
        }
        this.area = calcularArea();
        if (area < MIN_AREA || area > MAX_AREA) {
            throw new IllegalArgumentException("Área deve estar entre " + MIN_AREA + " e " + MAX_AREA + " cm².");
        }
        this.preco = calcularPreco();
    }

    public static double getMinRaio() {
        return MIN_RAIO;
    }

    public static double getMaxRaio() {
        return MAX_RAIO;
    }

    public static double getMinArea() {
        return MIN_AREA;
    }

    public static double getMaxArea() {
        return MAX_AREA;
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
