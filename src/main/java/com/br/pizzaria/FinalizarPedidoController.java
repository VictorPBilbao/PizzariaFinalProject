package com.br.pizzaria;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;

public class FinalizarPedidoController {
    @FXML
    private Button voltarMenuButton;

    @FXML
    private Button copyCodeButton;

    @FXML
    private Text codigoPedidoText;

    @FXML
    private Label copySuccessLabel;

    PedidoSingleton pedido = PedidoSingleton.getInstance();
    PedidosSingleton pedidos = PedidosSingleton.getInstance();

    @FXML
    public void initialize() {
        pedido.setPedido();
        pedidos.addPedido(pedido.getPedido());
        System.out.println("Pedido finalizado: " + pedido.getPedido().getId());
        System.out.println("Pedidos: " + pedidos.getPedidos().size());

        codigoPedidoText.setText(String.valueOf(pedido.getPedido().getId()));
    }

    @FXML
    public void handleVoltarMenu() throws IOException {
        pedido.clearCurrentPizzas();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));
        Parent root = loader.load();

        Stage stage = (Stage) codigoPedidoText.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

    @FXML
    public void handleCopyCode() {
        Clipboard clipboard = Clipboard.getSystemClipboard();
        ClipboardContent content = new ClipboardContent();
        content.putString(codigoPedidoText.getText());
        clipboard.setContent(content);

        copySuccessLabel.setVisible(true);
    }
}
