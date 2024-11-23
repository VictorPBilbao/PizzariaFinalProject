package com.br.pizzaria;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class AdicionarNovaPizzaController {

    PedidoSingleton pedido = PedidoSingleton.getInstance();

    @FXML
    private Button FinalizaPedido;

    @FXML
    private Button AdicionarNovaPizza;

    @FXML
    private void handleAdicionarNovaPizza() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("selecionarFormatoPizza.fxml"));
        Parent root = loader.load();

        Stage stage = (Stage) AdicionarNovaPizza.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

    @FXML
    void handleFinalizarPedido() throws IOException {
        System.out.println(pedido.getPizzas());

        FXMLLoader loader = new FXMLLoader(getClass().getResource("checkout.fxml"));
        Parent root = loader.load();

        Stage stage = (Stage) FinalizaPedido.getScene().getWindow();
        stage.setScene(new Scene(root));
    }
}
