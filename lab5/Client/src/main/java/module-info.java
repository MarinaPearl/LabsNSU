module demchuk.lab5.client {
    requires javafx.controls;
    requires javafx.fxml;
        requires javafx.web;
            
        requires org.controlsfx.controls;
            requires com.dlsc.formsfx;
            requires validatorfx;
            requires org.kordamp.ikonli.javafx;
            requires org.kordamp.bootstrapfx.core;
            requires eu.hansolo.tilesfx;
    requires lab5.demchuk.server;

    opens lab5.demchuk.server to javafx.fxml;
    exports lab5.demchuk.server;
}