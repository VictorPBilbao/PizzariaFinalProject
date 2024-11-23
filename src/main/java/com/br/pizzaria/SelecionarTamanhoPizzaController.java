package com.br.pizzaria;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SelecionarTamanhoPizzaController {

    private double minSizeSide;
    private double maxSizeSide;
    private double minSizeArea;
    private double maxSizeArea;
    private String pizzaType;
    private boolean selectByArea = false;
    private String pizzaMetric;
    private double selectedSize;

    @FXML
    private Slider sizeSlider;

    @FXML
    private ImageView pizzaImageView;

    @FXML
    private Label sliderValueLabel;

    @FXML
    private MenuButton menuButton;

    public void setPizzaType(String pizzaType) {
        this.pizzaType = pizzaType;
    }

    public void init() {
        setPizzaSizeBounds();
        setSizeSlider();
        setPizzaImage(); // Move this line after setSizeSlider to ensure the image size is set correctly
        selectBySide();
    }

    public void setSizeSlider() {
        sizeSlider.setBlockIncrement(4); // Ensure the slider increases by 1 unit
        sizeSlider.setMajorTickUnit(4); // Set major tick unit to 1
        sizeSlider.setSnapToTicks(true); // Snap to the nearest tick
        if (selectByArea) {
            sizeSlider.setMin(minSizeArea);
            sizeSlider.setMax(maxSizeArea);
        } else {
            sizeSlider.setMin(minSizeSide);
            sizeSlider.setMax(maxSizeSide);
        }
        sizeSlider.setValue((sizeSlider.getMax() - sizeSlider.getMin()) / 2 + sizeSlider.getMin()); // Set slider to the
                                                                                                    // middle
        sliderValueLabel.setText(String.format("%.0f %s", sizeSlider.getValue(), pizzaMetric)); // Display initial value

        sizeSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            sliderValueLabel.setText(String.format("%.0f %s", newValue.doubleValue(), pizzaMetric));
            adjustPizzaImageSize(newValue.doubleValue());
        });

    }

    @FXML
    private void selectBySide() {
        selectByArea = false;
        menuButton.setText("Selecionar por Lado ou Raio");
        pizzaMetric = "cm";
        setSizeSlider();
    }

    @FXML
    private void selectByArea() {
        selectByArea = true;
        menuButton.setText("Selecionar por Área");
        pizzaMetric = "cm²";
        setSizeSlider();
    }

    private void adjustPizzaImageSize(double sliderValue) {
        double minImageSize = 150; // Minimum image size
        double maxImageSize = 300; // Maximum image size
        double percentage = (sliderValue - sizeSlider.getMin()) / (sizeSlider.getMax() - sizeSlider.getMin());
        double newSize = minImageSize + (maxImageSize - minImageSize) * percentage;
        pizzaImageView.setFitHeight(newSize);
        pizzaImageView.setFitWidth(newSize);
    }

    public void setPizzaSizeBounds() {
        System.out.println("Ajustando tamanho");
        if (this.pizzaType.equals("PizzaQuadrada")) {
            this.minSizeSide = 10;
            this.maxSizeSide = 40;
            this.minSizeArea = 100;
            this.maxSizeArea = 1600;
        } else if (pizzaType.equals("PizzaTriangular")) {
            this.minSizeSide = 20;
            this.maxSizeSide = 60;
            this.minSizeArea = 174;
            this.maxSizeArea = 1558;
        } else if (pizzaType.equals("PizzaRedonda")) {
            this.minSizeSide = 7;
            this.maxSizeSide = 23;
            this.minSizeArea = 153;
            this.maxSizeArea = 1661;
        }
    }

    public void setPizzaImage() {
        System.out.println("Ajustando Imagem");
        pizzaImageView.setImage(new Image(getClass().getResourceAsStream(this.pizzaType + ".png")));
        adjustPizzaImageSize(sizeSlider.getValue()); // Adjust image size based on the current slider value
    }

    public double getSelectedSize() {
        return selectedSize;
    }

    @FXML
    private void handleNextButton() throws IOException {
        selectedSize = sizeSlider.getValue();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("selecionarSaborPizza.fxml"));
        Parent root = loader.load();

        SelecionarSaborPizzaController controller = loader.getController();
        controller.setPizzaDetails(pizzaType, selectedSize, pizzaMetric);

        Stage stage = (Stage) sizeSlider.getScene().getWindow();
        stage.setScene(new Scene(root));
    }
}
