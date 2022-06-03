module lab4.demchuk.phone.phone {
    requires javafx.controls;
    requires javafx.fxml;
        requires javafx.web;
            
        requires org.controlsfx.controls;
            requires com.dlsc.formsfx;
            requires validatorfx;
            requires org.kordamp.ikonli.javafx;
            requires org.kordamp.bootstrapfx.core;
            requires eu.hansolo.tilesfx;
            requires com.google.gson;

    opens lab4.demchuk.phone.phone to javafx.fxml, com.google.gson;
    exports lab4.demchuk.phone.phone;
  //  opens lab4.demchuk.phone.phone.Factory to javafx.fxml;
}