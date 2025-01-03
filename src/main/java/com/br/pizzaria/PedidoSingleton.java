package com.br.pizzaria;

import com.br.pizzaria.cliente.Cliente;
import com.br.pizzaria.pedido.EstadoPedido;
import com.br.pizzaria.pedido.Pedido;
import com.br.pizzaria.pizza.Pizza;
import java.util.ArrayList;
import java.util.List;

public class PedidoSingleton {
    private static final PedidoSingleton INSTANCE = new PedidoSingleton();

    private Cliente cliente;
    private List<Pizza> pizzas;
    private Pedido pedido;

    private PedidoSingleton() {
        pizzas = new ArrayList<>();
    }

    public static PedidoSingleton getInstance() {
        return INSTANCE;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setPedido() {
        this.pedido = new Pedido(cliente, pizzas, EstadoPedido.ABERTO);
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public void addPizza(Pizza pizza) {
        this.pizzas.add(pizza);
    }

    public void removePizza(Pizza pizza) {
        this.pizzas.remove(pizza);
    }

    public void removePizza(int index) {
        if (index >= 0 && index < pizzas.size()) {
            pizzas.remove(index);
        }
    }

    public void clearPizzas() {
        pizzas.clear();
    }

    public void clearCurrentPizzas() {
        this.pizzas = new ArrayList<>();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<Pizza> getPizzas() {
        return pizzas;
    }

    public Pedido getPedido() {
        return pedido;
    }

}
