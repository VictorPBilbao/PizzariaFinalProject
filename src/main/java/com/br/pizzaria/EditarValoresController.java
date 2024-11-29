package com.br.pizzaria;

import java.io.IOException;

import com.br.pizzaria.pizza.PizzaCategorias;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EditarValoresController {

    @FXML
    private TextField normalField;

    @FXML
    private TextField especialField;

    @FXML
    private TextField premiumField;

    @FXML
    public void initialize() {
        normalField.setText(String.valueOf(PizzaCategorias.NORMAL.getValor()));
        especialField.setText(String.valueOf(PizzaCategorias.ESPECIAL.getValor()));
        premiumField.setText(String.valueOf(PizzaCategorias.PREMIUM.getValor()));
    }

    @FXML
    private void handleSave() throws IOException {
        PizzaCategorias.NORMAL.setValor(Double.parseDouble(normalField.getText()));
        PizzaCategorias.ESPECIAL.setValor(Double.parseDouble(especialField.getText()));
        PizzaCategorias.PREMIUM.setValor(Double.parseDouble(premiumField.getText()));

        FXMLLoader loader = new FXMLLoader(getClass().getResource("listarPedidosAdmin.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) especialField.getScene().getWindow();
        stage.setScene(new Scene(root));
    }
}
