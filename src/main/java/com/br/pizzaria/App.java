package com.br.pizzaria;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.br.pizzaria.pizza.PizzaCategorias;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("login"));
        setAppIcon(stage);
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    private void setAppIcon(Stage stage) {
        Image icon = new Image(App.class.getResourceAsStream("logo.png"));
        stage.getIcons().add(icon);
    }

    public static void main(String[] args) {
        // create flavor of pizzas and their categories ( 3 each )
        Map<String, PizzaCategorias> allSabores = new HashMap<>();
        allSabores.put("Margherita", PizzaCategorias.NORMAL);
        allSabores.put("Pepperoni", PizzaCategorias.NORMAL);
        allSabores.put("Queijo", PizzaCategorias.NORMAL);
        allSabores.put("Camarão", PizzaCategorias.ESPECIAL);
        allSabores.put("Quatro Queijos", PizzaCategorias.ESPECIAL);
        allSabores.put("Portuguesa", PizzaCategorias.ESPECIAL);
        allSabores.put("Frango com Catupiry", PizzaCategorias.PREMIUM);
        allSabores.put("Cheddar com Bacon", PizzaCategorias.PREMIUM);
        allSabores.put("Calabresa", PizzaCategorias.PREMIUM);

        launch();
    }

}