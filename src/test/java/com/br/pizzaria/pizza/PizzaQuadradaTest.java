package com.br.pizzaria.pizza;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;

class PizzaQuadradaTest {

    Map<String, PizzaCategorias> allSabores = new HashMap<>();

    @BeforeEach
    public void setUp() {
        // Populate the general list of all flavours and their categories
        allSabores.put("Margherita", PizzaCategorias.NORMAL);
        allSabores.put("Pepperoni", PizzaCategorias.ESPECIAL);
        allSabores.put("Camarão", PizzaCategorias.PREMIUM);
        allSabores.put("Quatro Queijos", PizzaCategorias.ESPECIAL);
    }

    private Map<String, PizzaCategorias> selectFlavours(String flavour1, String flavour2) {
        Map<String, PizzaCategorias> selectedSabores = new HashMap<>();
        selectedSabores.put(flavour1, allSabores.get(flavour1));
        if (flavour2 != null) {
            selectedSabores.put(flavour2, allSabores.get(flavour2));
        }
        return selectedSabores;
    }

    @Test
    void testPizzaCreationWithOneFlavour() {
        // Select one flavour to create the pizza
        Map<String, PizzaCategorias> selectedSabores = selectFlavours("Camarão", null);

        // Create a PizzaQuadrada instance
        PizzaQuadrada pizza = new PizzaQuadrada(selectedSabores, 20.0);

        // Assertions to verify the pizza properties
        assertEquals(20, pizza.getLado(), 0.001);
        assertEquals(400, pizza.getArea(), 0.001);
        // assertEquals(400.0 + PizzaCategorias.PREMIUM.getValor(), pizza.getPreco(),
        // 0.001);
        assertEquals(400, pizza.calcularPreco());
        assertEquals(selectedSabores, pizza.getSabores());
    }

    @Test
    void testPizzaCreationWithTwoFlavours() {
        // Select two flavours to create the pizza
        Map<String, PizzaCategorias> selectedSabores = selectFlavours("Margherita", "Pepperoni");

        // Create a PizzaQuadrada instance
        PizzaQuadrada pizza = new PizzaQuadrada(selectedSabores, 25.0);

        // Assertions to verify the pizza properties
        assertEquals(25.0, pizza.getLado(), 0.001);
        assertEquals(625.0, pizza.getArea(), 0.001);

        assertEquals(234.375, pizza.calcularPreco(), 1);
        assertEquals(selectedSabores, pizza.getSabores());
    }
}