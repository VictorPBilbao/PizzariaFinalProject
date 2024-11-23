package com.br.pizzaria;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;

import com.br.pizzaria.pizza.Pizza;
import javafx.geometry.Pos;

public class CheckoutController {
    @FXML
    private ListView<Pizza> pizzaListView;

    @FXML
    private Label totalLabel;

    @FXML
    private Button finishOrderButton;

    PedidoSingleton pedido = PedidoSingleton.getInstance();

    @FXML
    public void initialize() {
        pizzaListView.setItems(javafx.collections.FXCollections.observableArrayList(pedido.getPizzas()));
        pizzaListView.setCellFactory(new Callback<ListView<Pizza>, ListCell<Pizza>>() {
            @Override
            public ListCell<Pizza> call(ListView<Pizza> listView) {
                return new ListCell<Pizza>() {
                    private final Button deleteButton = new Button("Delete");
                    private final HBox hBox = new HBox();

                    {
                        deleteButton.setOnAction(event -> {
                            Pizza pizza = getItem();
                            pedido.removePizza(pizza);
                            pizzaListView.getItems().remove(pizza);
                            updateTotal();
                            updateFinishOrderButton();
                        });
                        hBox.getChildren().addAll(deleteButton);
                        hBox.setSpacing(10);
                        hBox.setAlignment(Pos.CENTER_RIGHT);
                    }

                    @Override
                    protected void updateItem(Pizza pizza, boolean empty) {
                        super.updateItem(pizza, empty);
                        if (empty || pizza == null) {
                            setText(null);
                            setGraphic(null);
                        } else {
                            setText(pizza.toString());
                            setGraphic(hBox);
                        }
                    }
                };
            }
        });
        updateTotal();
        updateFinishOrderButton();
    }

    private void updateTotal() {
        double total = pizzaListView.getItems().stream().mapToDouble(Pizza::getPreco).sum();
        totalLabel.setText(String.format("Total: R$ %.2f", total));
    }

    private void updateFinishOrderButton() {
        finishOrderButton.setDisable(pizzaListView.getItems().isEmpty());
    }

    @FXML
    private void handleFinishOrder() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("finalizarPedido.fxml"));
        Parent root = loader.load();

        Stage stage = (Stage) totalLabel.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

    @FXML
    private void handleGoBack() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("adicionarNovaPizza.fxml"));
        Parent root = loader.load();

        Stage stage = (Stage) totalLabel.getScene().getWindow();
        stage.setScene(new Scene(root));
    }
}
