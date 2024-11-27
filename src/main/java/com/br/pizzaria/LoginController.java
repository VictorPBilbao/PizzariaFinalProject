package com.br.pizzaria;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import com.br.pizzaria.cliente.Cliente;
import com.br.pizzaria.pedido.Pedido;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    private TextField nomeCliente;

    @FXML
    private TextField sobrenomeCliente;

    @FXML
    private TextField telefoneCliente;

    @FXML
    private TextField CEPCliente;

    @FXML
    private TextField numeroDaCasaCliente;

    @FXML
    private TextField identificadorPedidoField;

    @FXML
    private Label errorMessage;

    PedidosSingleton pedidos = PedidosSingleton.getInstance();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        errorMessage.setVisible(false);
    }

    PedidoSingleton pedido = PedidoSingleton.getInstance();

    @FXML
    private void handleLogin() throws IOException {
        String nome = nomeCliente.getText();
        String sobrenome = sobrenomeCliente.getText();
        String telefone = telefoneCliente.getText();
        String CEP = CEPCliente.getText();
        String numeroDaCasa = numeroDaCasaCliente.getText();

        // if (nome.isEmpty() || sobrenome.isEmpty() || telefone.isEmpty() ||
        // CEP.isEmpty() || numeroDaCasa.isEmpty()) {
        // errorMessage.setText("Todos os campos devem ser preenchidos.");
        // errorMessage.setVisible(true);
        // return;
        // }

        // if (!telefone.matches("\\d{11}")) {
        // errorMessage.setText("O telefone deve conter 11 dígitos numéricos.");
        // errorMessage.setVisible(true);
        // return;
        // }

        // if (!CEP.matches("\\d{8}")) {
        // errorMessage.setText("O CEP deve conter 8 dígitos numéricos.");
        // errorMessage.setVisible(true);
        // return;
        // }

        // errorMessage.setVisible(false);

        Cliente cliente = new Cliente(nome, sobrenome, telefone, CEP, numeroDaCasa);
        pedido.setCliente(cliente);
        System.out.println(pedido.getCliente());

        FXMLLoader loader = new FXMLLoader(getClass().getResource("selecionarFormatoPizza.fxml"));
        Parent root = loader.load();

        Stage stage = (Stage) nomeCliente.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

    @FXML
    private void handleIdentificadorPedido() throws IOException {
        String identificadorPedido = identificadorPedidoField.getText();
        errorMessage.setVisible(false);
        if (identificadorPedido.isEmpty()) {
            errorMessage.setText("O identificador do pedido deve ser preenchido.");
            errorMessage.setVisible(true);
            return;
        }

        boolean pedidoExiste = pedidos.getPedidos().stream()
                .anyMatch(p -> p.getId().equals(identificadorPedido));

        // get the pedido and save it in the PedidoSingleton
        Pedido pedidoEncontrado = pedidos.getPedidos().stream()
                .filter(p -> p.getId().equals(identificadorPedido))
                .findFirst()
                .orElse(null);

        pedido.setPedido(pedidoEncontrado);

        if (!pedidoExiste) {
            errorMessage.setText("Pedido não encontrado.");
            errorMessage.setVisible(true);
            return;
        }

        FXMLLoader loader = new FXMLLoader(getClass().getResource("detalharPedido.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) identificadorPedidoField.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

    @FXML
    private void handleAcessarAdmin() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("acessarAdmin.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) identificadorPedidoField.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

}
