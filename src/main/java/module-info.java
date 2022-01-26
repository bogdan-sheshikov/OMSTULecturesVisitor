module visitor.omstulecturesvisitor {
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
    requires org.seleniumhq.selenium.chrome_driver;

    opens visitor.omstulecturesvisitor to javafx.fxml;
    exports visitor.omstulecturesvisitor;
}