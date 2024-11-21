package com.br.pizzaria.pedido;

import java.util.List;

import com.br.pizzaria.cliente.Cliente;
import com.br.pizzaria.pizza.Pizza;

public class Pedido {
    private int id;
    private Cliente cliente;
    private List<Pizza> pizzas;
    private double precoTotal;
    private EstadoPedido estado;

    public Pedido(int id, Cliente cliente, List<Pizza> pizzas, EstadoPedido estado) {
        this.id = id;
        this.cliente = cliente;
        this.pizzas = pizzas;
        this.estado = estado;
        this.precoTotal = calcularPrecoTotal();
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
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
