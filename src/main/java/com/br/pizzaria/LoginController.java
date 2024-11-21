package com.br.pizzaria;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import com.br.pizzaria.cliente.Cliente;

public class LoginController {

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
    private void handleLogin() throws IOException {
        String nome = nomeCliente.getText();
        String sobrenome = sobrenomeCliente.getText();
        String telefone = telefoneCliente.getText();
        String CEP = CEPCliente.getText();
        String numeroDaCasa = numeroDaCasaCliente.getText();

        Cliente cliente = new Cliente(nome, sobrenome, telefone, CEP, numeroDaCasa);
        System.out.println(cliente);
        App.setRoot("selecionarFormatoPizza");
    }

    @FXML
    private void handleOrder() throws IOException {
        // App.setRoot("secondary");
    }
}
