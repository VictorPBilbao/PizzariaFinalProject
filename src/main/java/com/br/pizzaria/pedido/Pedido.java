package com.br.pizzaria.pedido;

import java.util.List;

import com.br.pizzaria.cliente.Cliente;
import com.br.pizzaria.pizza.Pizza;
import java.util.Random;

public class Pedido {
    private String id;
    private Cliente cliente;
    private List<Pizza> pizzas;
    private double precoTotal;
    private EstadoPedido estado;

    public Pedido(Cliente cliente, List<Pizza> pizzas, EstadoPedido estado) {
        this.id = gerarIdAleatorio();
        this.cliente = cliente;
        this.pizzas = pizzas;
        this.estado = estado;
        this.precoTotal = calcularPrecoTotal();
    }

    public static String gerarIdAleatorio() {
        int length = 7;
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuilder id = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            id.append(chars.charAt(random.nextInt(chars.length())));
        }
        return id.toString();
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Pizza> getPizzas() {
        return pizzas;
    }

    public void setPizzas(List<Pizza> pizzas) {
        this.pizzas = pizzas;
    }

    public double getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(double precoTotal) {
        this.precoTotal = precoTotal;
    }

    public EstadoPedido getEstado() {
        return estado;
    }

    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
    }

    public double calcularPrecoTotal() {
        double total = 0;
        for (Pizza pizza : pizzas) {
            total += pizza.calcularPreco();
        }
        return total;
    }
}
