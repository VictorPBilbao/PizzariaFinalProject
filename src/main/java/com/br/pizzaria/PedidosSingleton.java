package com.br.pizzaria;

import com.br.pizzaria.pedido.Pedido;
import java.util.ArrayList;
import java.util.List;

public class PedidosSingleton {
    private static final PedidosSingleton INSTANCE = new PedidosSingleton();

    private List<Pedido> pedidos;

    private PedidosSingleton() {
        pedidos = new ArrayList<>();
    }

    public static PedidosSingleton getInstance() {
        return INSTANCE;
    }

    public void addPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    public void removePedido(Pedido pedido) {
        pedidos.remove(pedido);
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }
}
