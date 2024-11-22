package com.br.pizzaria;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SelecionarFormatoPizzaController {

    @FXML
    private Button circularButton;

    @FXML
    private Button quadradaButton;

    @FXML
    private Button triangularButton;

    @FXML
    private VBox rootVBox;

    @FXML
    void handleButtonAction(ActionEvent event) throws IOException {
        String pizzaType = "";
        if (event.getSource() == circularButton) {
            pizzaType = "PizzaRedonda";
        } else if (event.getSource() == quadradaButton) {
            pizzaType = "PizzaQuadrada";
        } else if (event.getSource() == triangularButton) {
            pizzaType = "PizzaTriangular";
        }

        FXMLLoader loader = new FXMLLoader(getClass().getResource("selecionarTamanhoPizza.fxml"));
        Parent root = loader.load();

        SelecionarTamanhoPizzaController controller = loader.getController();
        controller.setPizzaType(pizzaType);
        controller.init();

        Stage stage = (Stage) rootVBox.getScene().getWindow();

        stage.setScene(new Scene(root));
    }
}
