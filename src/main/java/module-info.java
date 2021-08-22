module net.noncore.fdx {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;

    opens net.noncore.fdx to javafx.base, javafx.fxml;
    opens net.noncore.fdx.views to javafx.base, javafx.fxml;
    opens net.noncore.fdx.views.components to javafx.base, javafx.fxml;
    exports net.noncore.fdx;
}