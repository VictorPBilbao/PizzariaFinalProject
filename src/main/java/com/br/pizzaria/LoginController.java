package com.br.pizzaria;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import com.br.pizzaria.cliente.Cliente;
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
    private Label errorMessage;

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
        App.setRoot("selecionarFormatoPizza");
    }
}
