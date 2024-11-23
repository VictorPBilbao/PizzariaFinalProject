package com.br.pizzaria;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.CheckBox;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SelecionarSaborPizzaController {

    @FXML
    private CheckBox flavor1;
    @FXML
    private CheckBox flavor2;
    @FXML
    private CheckBox flavor3;
    @FXML
    private CheckBox flavor4;
    @FXML
    private CheckBox flavor5;
    @FXML
    private CheckBox flavor6;
    @FXML
    private CheckBox flavor7;
    @FXML
    private CheckBox flavor8;
    @FXML
    private CheckBox flavor9;
    @FXML
    private Button NextButton;

    PedidoSingleton pedido = PedidoSingleton.getInstance();

    private List<CheckBox> checkBoxes;
    private String pizzaType;
    private double pizzaSize;
    private String pizzaMetric;

    @FXML
    public void initialize() {
        checkBoxes = new ArrayList<>();
        checkBoxes.add(flavor1);
        checkBoxes.add(flavor2);
        checkBoxes.add(flavor3);
        checkBoxes.add(flavor4);
        checkBoxes.add(flavor5);
        checkBoxes.add(flavor6);
        checkBoxes.add(flavor7);
        checkBoxes.add(flavor8);
        checkBoxes.add(flavor9);

        for (CheckBox checkBox : checkBoxes) {
            checkBox.setOnAction(event -> handleCheckBoxSelection());
        }

        // Initially disable the NextButton
        NextButton.setDisable(true);
    }

    private void handleCheckBoxSelection() {
        long selectedCount = checkBoxes.stream().filter(CheckBox::isSelected).count();
        boolean disable = selectedCount >= 2;

        for (CheckBox checkBox : checkBoxes) {
            if (!checkBox.isSelected()) {
                checkBox.setDisable(disable);
            }
        }

        // Enable NextButton if at least one checkbox is selected
        NextButton.setDisable(selectedCount == 0);
    }

    public void setPizzaDetails(String pizzaType, double pizzaSize, String pizzaMetric) {
        this.pizzaType = pizzaType;
        this.pizzaSize = pizzaSize;
        if (pizzaMetric.equals("cm")) {
            this.pizzaMetric = "side";
        } else {
            this.pizzaMetric = "area";
        }
    }

    @FXML
    private void handleNextButton() throws IOException {
        List<String> selectedFlavors = new ArrayList<>();
        for (CheckBox checkBox : checkBoxes) {
            if (checkBox.isSelected()) {
                selectedFlavors.add(checkBox.getText());
            }
        }

        PizzaDetails pizzaDetails = new PizzaDetails(pizzaType, pizzaMetric, pizzaSize, selectedFlavors);
        pedido.addPizza(pizzaDetails.createPizza());

        FXMLLoader loader = new FXMLLoader(getClass().getResource("adicionarNovaPizza.fxml"));
        Parent root = loader.load();

        Stage stage = (Stage) NextButton.getScene().getWindow();
        stage.setScene(new Scene(root));

    }
}
