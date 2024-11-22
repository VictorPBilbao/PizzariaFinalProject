package com.br.pizzaria;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;

public class SelecionarSaborPizzaController {

    @FXML
    private CheckBox calabresaCheckBox;
    @FXML
    private CheckBox mussarelaCheckBox;
    @FXML
    private CheckBox portuguesaCheckBox;
    @FXML
    private CheckBox frangoCheckBox;
    @FXML
    private CheckBox margueritaCheckBox;

    @FXML
    public void initialize() {
        CheckBox[] checkBoxes = {
                calabresaCheckBox,
                mussarelaCheckBox,
                portuguesaCheckBox,
                frangoCheckBox,
                margueritaCheckBox };

        for (CheckBox checkBox : checkBoxes) {
            checkBox.setOnAction(event -> handleCheckBoxSelection(checkBoxes));
        }
    }

    private void handleCheckBoxSelection(CheckBox[] checkBoxes) {
        int selectedCount = 0;
        for (CheckBox checkBox : checkBoxes) {
            if (checkBox.isSelected()) {
                selectedCount++;
            }
            System.out.println(selectedCount);
        }

        for (CheckBox checkBox : checkBoxes) {
            if (!checkBox.isSelected() && selectedCount >= 2) {
                checkBox.setDisable(true);
            } else {
                checkBox.setDisable(false);
            }
        }
    }
}
