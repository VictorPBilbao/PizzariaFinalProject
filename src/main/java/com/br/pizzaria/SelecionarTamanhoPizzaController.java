package com.br.pizzaria;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class SelecionarTamanhoPizzaController {

    @FXML
    private Slider sizeSlider;

    @FXML
    private ImageView pizzaImageView;

    @FXML
    private Label sliderValueLabel; // Add a label to display the slider value

    @FXML
    public void initialize() {
        sizeSlider.setValue(sizeSlider.getMax() / 2); // Set slider to the middle
        pizzaImageView.setFitHeight(sizeSlider.getValue() + 200);
        pizzaImageView.setFitWidth(sizeSlider.getValue() + 200);
        sliderValueLabel.setText(String.format("%.0f", sizeSlider.getValue())); // Display initial value

        sizeSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            pizzaImageView.setFitHeight(newValue.doubleValue() + 200);
            pizzaImageView.setFitWidth(newValue.doubleValue() + 200);
            sliderValueLabel.setText(String.format("%.0f", newValue.doubleValue())); // Update label with new value
        });
    }

    public void setPizzaType(String pizzaType) {
        pizzaImageView.setImage(new Image(getClass().getResourceAsStream(pizzaType + ".png")));
    }
}
