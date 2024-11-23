package com.br.pizzaria.pizza;

import java.util.Map;

public class PizzaTriangular extends Pizza {
    private static final double MIN_LADO = 20.0;
    private static final double MAX_LADO = 60.0;
    private static final double MIN_AREA = MIN_LADO * MIN_LADO * (Math.sqrt(3) / 4);
    private static final double MAX_AREA = MAX_LADO * MAX_LADO * (Math.sqrt(3) / 4);
    private static final String FORMATO = "Triangular";
    private double lado;

    public PizzaTriangular(Map<String, PizzaCategorias> sabores, double lado) {
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

    public PizzaTriangular(Map<String, PizzaCategorias> sabores, int tamanho) {
        super(sabores);
        this.lado = (2 * Math.sqrt(tamanho)) / Math.pow(3, 1.0 / 4.0);
        if (lado < MIN_LADO || lado > MAX_LADO) {
            throw new IllegalArgumentException("Lado deve estar entre " + MIN_LADO + " e " + MAX_LADO + " cm.");
        }
        this.area = calcularArea();
        if (area < MIN_AREA || area > MAX_AREA) {
            throw new IllegalArgumentException("Área deve estar entre " + MIN_AREA + " e " + MAX_AREA + " cm².");
        }
        this.preco = calcularPreco();
    }

    public String getFORMATO() {
        return FORMATO;
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
        return lado * lado * (Math.sqrt(3) / 4);
    }

    @Override
    public double calcularPreco() {
        double valorTotal = 0.0;
        for (PizzaCategorias categoria : sabores.values()) {
            valorTotal += categoria.getValor();
        }
        return area * (valorTotal / sabores.size());
    }

    public double getLado() {
        return lado;
    }
}
