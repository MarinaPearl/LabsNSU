module lab5.demchuk.server {
    requires javafx.controls;
    requires javafx.fxml;
        requires javafx.web;
            
        requires org.controlsfx.controls;
            requires com.dlsc.formsfx;
            requires validatorfx;
            requires org.kordamp.ikonli.javafx;
            requires org.kordamp.bootstrapfx.core;
            requires eu.hansolo.tilesfx;
    requires lab4.demchuk.phone.phone;
    requires com.google.gson;

    opens lab5.demchuk.server to javafx.fxml, com.google.gson;
    opens lab5.demchuk.server.Factory to com.google.gson;
    exports lab5.demchuk.server;
    opens Demchuck.lab5.ru to com.google.gson;
}