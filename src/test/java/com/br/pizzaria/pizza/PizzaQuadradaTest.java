package com.br.pizzaria.pizza;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;

class PizzaQuadradaTest {

    private PizzaQuadrada pizza;

    @BeforeEach
    public void setUp() {
        List<String> sabores = Arrays.asList("Mussarela", "Calabresa");
        pizza = new PizzaQuadrada(sabores, 4.0);
    }

    @Test
    void testCalcularArea() {
        assertEquals(16.0, pizza.calcularArea(), 0.001);
    }

    @Test
    void testCalcularPreco() {
        assertEquals(16.0, pizza.calcularPreco(), 0.001); // Assuming price calculation is area * 1.0
    }

    @Test
    void testGetLado() {
        assertEquals(4.0, pizza.getLado(), 0.001);
    }

    @Test
    void testSetLado() {
        pizza = new PizzaQuadrada(Arrays.asList("Mussarela"), 5.0);
        assertEquals(5.0, pizza.getLado(), 0.001);
        assertEquals(25.0, pizza.calcularArea(), 0.001);
        assertEquals(25.0, pizza.calcularPreco(), 0.001);
    }

    @Test
    void testMultipleSabores() {
        List<String> sabores = Arrays.asList("Mussarela", "Calabresa", "Frango");
        pizza = new PizzaQuadrada(sabores, 3.0);
        assertEquals(9.0, pizza.calcularArea(), 0.001);
        assertEquals(9.0, pizza.calcularPreco(), 0.001);
        assertEquals(3.0, pizza.getLado(), 0.001);
    }

    @Test
    void testEmptySabores() {
        pizza = new PizzaQuadrada(Arrays.asList(), 2.0);
        assertEquals(4.0, pizza.calcularArea(), 0.001);
        assertEquals(4.0, pizza.calcularPreco(), 0.001);
        assertEquals(2.0, pizza.getLado(), 0.001);
    }
}
