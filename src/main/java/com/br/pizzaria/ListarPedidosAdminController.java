package com.br.pizzaria;

import java.io.IOException;

import com.br.pizzaria.pedido.Pedido;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.transformation.FilteredList;

public class ListarPedidosAdminController {

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

    PedidoSingleton pedido = PedidoSingleton.getInstance();

    private FilteredList<Pedido> filteredData;

    @FXML
    public void initialize() {
        colunaId.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getId()));
        colunaNome.setCellValueFactory(
                cellData -> new SimpleStringProperty(cellData.getValue().getCliente().getNome()));
        colunaSobrenome.setCellValueFactory(
                cellData -> new SimpleStringProperty(cellData.getValue().getCliente().getSobrenome()));
        colunaStatus
                .setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEstado().toString()));
        colunaDetalhes.setCellFactory(col -> new TableCell<Pedido, Void>() {
            private final Button detailsButton = new Button("Detalhes");

            {
                detailsButton.setOnAction(event -> {
                    Pedido pedidoSelecionado = getTableView().getItems().get(getIndex());
                    // Handle details button action
                    pedido.setPedido(pedidoSelecionado);
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("detalharPedidoAdmin.fxml"));
                    Parent root;
                    try {
                        root = loader.load();
                        Stage stage = (Stage) ordersTable.getScene().getWindow();
                        stage.setScene(new Scene(root));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

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

        filteredData = new FilteredList<>(FXCollections.observableArrayList(pedidosSingleton.getPedidos()), p -> true);
        ordersTable.setItems(filteredData);
    }

    @FXML
    private void filterOrders() {
        String filterText = filterField.getText().toLowerCase();
        filteredData.setPredicate(pedido -> {
            if (filterText == null || filterText.isEmpty()) {
                return true;
            }
            return pedido.getCliente().getNome().toLowerCase().contains(filterText) ||
                    pedido.getCliente().getSobrenome().toLowerCase().contains(filterText) ||
                    pedido.getEstado().toString().toLowerCase().contains(filterText) ||
                    pedido.getId().toLowerCase().contains(filterText);
        });
    }

    @FXML
    private void handleBack() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) ordersTable.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

    @FXML
    private void handleEditarValores() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("editarValores.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) ordersTable.getScene().getWindow();
        stage.setScene(new Scene(root));
    }
}
