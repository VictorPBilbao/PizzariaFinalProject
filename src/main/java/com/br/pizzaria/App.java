package com.br.pizzaria;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.br.pizzaria.pizza.Pizza;
import com.br.pizzaria.pizza.PizzaQuadrada;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("login"));
        applyStylesheet(scene);
        setAppIcon(stage);
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
        applyStylesheet(scene);
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    private static void applyStylesheet(Scene scene) {
        scene.getStylesheets().add(App.class.getResource("styles.css").toExternalForm());
    }

    private void setAppIcon(Stage stage) {
        Image icon = new Image(App.class.getResourceAsStream("logo.png"));
        stage.getIcons().add(icon);
    }

    public static void main(String[] args) {
        launch();
    }

}