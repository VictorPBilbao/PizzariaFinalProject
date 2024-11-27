package com.br.pizzaria;

import com.br.pizzaria.pedido.Pedido;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class AcessarAdminController {

    @FXML
    private TableView<Pedido> ordersTable;

    @FXML
    private TableColumn<Pedido, String> colunaNome;

    @FXML
    private TableColumn<Pedido, String> colunaSobrenome;

    @FXML
    private TableColumn<Pedido, String> colunaStatus;

    @FXML
    private TableColumn<Pedido, Void> colunaDetalhes;

    @FXML
    private TextField filterField;

    private final PedidosSingleton pedidosSingleton = PedidosSingleton.getInstance();

    @FXML
    public void initialize() {

    }
}
