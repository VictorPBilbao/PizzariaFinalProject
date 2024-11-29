package com.br.pizzaria;

import com.br.pizzaria.pedido.Pedido;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.collections.FXCollections;
import javafx.beans.property.SimpleStringProperty;

public class ListarPizzasAdminController {

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
    private TableColumn<Pedido, String> colunaId;

    @FXML
    private TextField filterField;

    private final PedidosSingleton pedidosSingleton = PedidosSingleton.getInstance();

    @FXML
    public void initialize() {
        colunaId.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getId()));
        colunaNome
                .setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCliente().getNome()));
        colunaSobrenome.setCellValueFactory(
                cellData -> new SimpleStringProperty(cellData.getValue().getCliente().getSobrenome()));
        colunaStatus
                .setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEstado().toString()));
        colunaDetalhes.setCellFactory(col -> new TableCell<Pedido, Void>() {
            private final Button detailsButton = new Button("Detalhes");

            {
                detailsButton.setOnAction(event -> {
                    Pedido pedido = getTableView().getItems().get(getIndex());
                    // Handle details button action
                });
            }

            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    setGraphic(detailsButton);
                }
            }
        });

        ordersTable.setItems(FXCollections.observableArrayList(pedidosSingleton.getPedidos()));
    }
}
