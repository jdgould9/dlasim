module app.dlav3 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.sql;
    requires javafx.graphics;
    requires javafx.base;


    opens app.dlav3 to javafx.fxml;
    exports app.dlav3.view;
    opens app.dlav3.view to javafx.fxml;
    exports app.dlav3.config;
    opens app.dlav3.config to javafx.fxml;
    exports app.dlav3.model;
    opens app.dlav3.model to javafx.fxml;
    exports app.dlav3;
    exports app.dlav3.view.panels;
    opens app.dlav3.view.panels to javafx.fxml;
}