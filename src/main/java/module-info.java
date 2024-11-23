module com.br.pizzaria {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;

    opens com.br.pizzaria to javafx.fxml;

    exports com.br.pizzaria.cliente;
    exports com.br.pizzaria.pizza;
    exports com.br.pizzaria.pedido;
    exports com.br.pizzaria;
}
