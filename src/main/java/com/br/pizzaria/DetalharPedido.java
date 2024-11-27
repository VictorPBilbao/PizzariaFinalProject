package com.br.pizzaria;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.beans.property.SimpleStringProperty;

import java.io.IOException;

import com.br.pizzaria.pedido.Pedido;
import com.br.pizzaria.pizza.Pizza;

public class DetalharPedido {

    @FXML
    private TableColumn<Pizza, String> colunaArea;

    @FXML
    private TableColumn<Pizza, String> colunaFormato;

    @FXML
    private TableColumn<Pizza, String> colunaLado;

    @FXML
    private TableColumn<Pizza, String> colunaPreco;

    @FXML
    private TableColumn<Pizza, String> colunaSabor1;

    @FXML
    private TableColumn<Pizza, String> colunaSabor2;

    @FXML
    private Text pedidoCodigo;

    @FXML
    private Text pedidoStatus;

    @FXML
    private TableView<Pizza> pizzasTable;

    PedidoSingleton pedidoSingleton = PedidoSingleton.getInstance();

    @FXML
    public void initialize() {
        Pedido pedido = pedidoSingleton.getPedido();
        // statusPedidoText.setText("Pedido " + pedido.getId() + ": Status " +
        // pedido.getEstado().toString().toLowerCase());

        pedidoCodigo.setText(pedido.getId());
        pedidoStatus.setText(pedido.getEstado().toString());

        colunaFormato.setCellValueFactory(new PropertyValueFactory<>("FORMATO"));
        colunaLado.setCellValueFactory(new PropertyValueFactory<>("lado"));
        colunaArea.setCellValueFactory(cellData -> {
            double area = cellData.getValue().getArea();
            return new SimpleStringProperty(String.format("%.2f", area));
        });
        colunaSabor1.setCellValueFactory(new PropertyValueFactory<>("sabor1"));
        colunaSabor2.setCellValueFactory(new PropertyValueFactory<>("sabor2"));
        colunaPreco.setCellValueFactory(cellData -> {
            double preco = cellData.getValue().getPreco();
            return new SimpleStringProperty(String.format("%.2f", preco));
        });

        ObservableList<Pizza> pizzas = FXCollections.observableArrayList(pedido.getPizzas());
        pizzasTable.setItems(pizzas);
    }

    @FXML
    private void handleVoltar() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) pizzasTable.getScene().getWindow();
        stage.setScene(new Scene(root));
    }
}
