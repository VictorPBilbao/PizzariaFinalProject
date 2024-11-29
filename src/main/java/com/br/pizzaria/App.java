package com.br.pizzaria;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App {

    private static Scene scene;

    public static void main(String[] args) {
        launchApp();
    }

    private static void launchApp() {
        Application.launch(JavaFXApp.class);
    }

    public static class JavaFXApp extends Application {

        @Override
        public void start(Stage stage) throws IOException {
            scene = new Scene(loadFXML("login"));
            setAppIcon(stage);
            stage.setScene(scene);
            stage.show();
        }

        private void setAppIcon(Stage stage) {
            Image icon = new Image(App.class.getResourceAsStream("logo.png"));
            stage.getIcons().add(icon);
        }

        private Parent loadFXML(String fxml) throws IOException {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
            return fxmlLoader.load();
        }
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }
}