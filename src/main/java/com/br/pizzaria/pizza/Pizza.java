package com.br.pizzaria.pizza;

import java.util.Map;

public abstract class Pizza {
    protected Map<String, PizzaCategorias> sabores;
    protected double preco;
    protected double area;

    protected Pizza(Map<String, PizzaCategorias> sabores) {
        if (sabores.size() < 1 || sabores.size() > 2) {
            throw new IllegalArgumentException("A pizza deve ter entre 1 e 2 sabores.");
        }
        this.sabores = sabores;
    }

    public abstract String getFORMATO();

    public abstract double calcularArea();

    public abstract double calcularPreco();

    public double getPreco() {
        return preco;
    }

    public double getArea() {
        return area;
    }

    public Map<String, PizzaCategorias> getSabores() {
        return sabores;
    }

    @Override
    public String toString() {
        if (sabores.size() == 1) {
            return String.format("1 Pizza %s de %s, Area: %.2f cm² totalizando R$: %.2f", getFORMATO(),
                    sabores.keySet().toArray()[0], area, preco);
        } else {
            Object[] keys = sabores.keySet().toArray();
            return String.format("1 Pizza %s metade %s e metade %s, Area: %.2f cm² totalizando R$: %.2f", getFORMATO(),
                    keys[0], keys[1], area, preco);
        }
    }
}
