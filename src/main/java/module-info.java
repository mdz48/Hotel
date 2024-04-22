module com.mdz.application.hotel {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.mdz.application.hotel to javafx.fxml;
    exports com.mdz.application.hotel;
    exports com.mdz.application.hotel.controllers;
    opens com.mdz.application.hotel.controllers to javafx.fxml;
}