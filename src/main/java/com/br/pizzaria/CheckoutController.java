package com.br.pizzaria;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.util.Callback;
import com.br.pizzaria.pizza.Pizza;
import javafx.geometry.Pos;

public class CheckoutController {
    @FXML
    private ListView<Pizza> pizzaListView;

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
    }
}
