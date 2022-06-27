module lab5.demchuk.client.clientjavafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
  //  requires lab5.demchuk.server;
    requires lab4.demchuk.phone.phone;
    requires com.google.gson;

    opens lab5.demchuk.client.clientjavafx.clientveb to javafx.fxml;
    exports lab5.demchuk.client.clientjavafx.clientveb;
    opens lab5.demchuk.client.clientjavafx.model to com.google.gson;
    opens lab5.demchuk.client.clientjavafx.model.Factory to com.google.gson;
    opens Demchuck.lab5.ru to com.google.gson;
}