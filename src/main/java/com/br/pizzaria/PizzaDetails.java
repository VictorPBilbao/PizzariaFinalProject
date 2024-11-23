package com.br.pizzaria;

import com.br.pizzaria.pizza.*;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class PizzaDetails {
    private String pizzaType;
    private String pizzaMetric;
    private double pizzaSize;
    private List<String> flavors;
    Map<String, PizzaCategorias> allSabores = new HashMap<>();

    public PizzaDetails(String pizzaType, String pizzaMetric, double pizzaSize, List<String> flavors) {
        this.pizzaType = pizzaType;
        this.pizzaMetric = pizzaMetric;
        this.pizzaSize = pizzaSize;
        this.flavors = flavors;
        allSabores.put("Strogonoff", PizzaCategorias.NORMAL);
        allSabores.put("Pepperoni", PizzaCategorias.NORMAL);
        allSabores.put("Queijo", PizzaCategorias.NORMAL);
        allSabores.put("Frango com Catupiry", PizzaCategorias.ESPECIAL);
        allSabores.put("Quatro Queijos", PizzaCategorias.ESPECIAL);
        allSabores.put("Portuguesa", PizzaCategorias.ESPECIAL);
        allSabores.put("Mexicana", PizzaCategorias.PREMIUM);
        allSabores.put("Cheddar com Bacon", PizzaCategorias.PREMIUM);
        allSabores.put("Chocolate", PizzaCategorias.PREMIUM);
    }

    public Pizza createPizza() {
        Map<String, PizzaCategorias> selectedFlavors = new HashMap<>();
        for (String flavor : flavors) {
            PizzaCategorias category = allSabores.getOrDefault(flavor, PizzaCategorias.NORMAL);
            selectedFlavors.put(flavor, category);
        }

        Pizza pizza;
        if (pizzaMetric.equals("side")) {
            if (pizzaType.equals("PizzaQuadrada")) {
                pizza = new PizzaQuadrada(selectedFlavors, pizzaSize);
            } else if (pizzaType.equals("PizzaTriangular")) {
                pizza = new PizzaTriangular(selectedFlavors, pizzaSize);
            } else {
                pizza = new PizzaCircular(selectedFlavors, pizzaSize);
            }
        } else {
            if (pizzaType.equals("PizzaQuadrada")) {
                pizza = new PizzaQuadrada(selectedFlavors, (int) pizzaSize);
            } else if (pizzaType.equals("PizzaTriangular")) {
                pizza = new PizzaTriangular(selectedFlavors, (int) pizzaSize);
            } else {
                pizza = new PizzaCircular(selectedFlavors, (int) pizzaSize);
            }
        }

        System.out.println("Pizza created: " + pizza);
        return pizza;
    }
}
