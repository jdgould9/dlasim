module app.dlav3 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.sql;
    requires javafx.graphics;
    requires javafx.base;


    opens app.dlav3 to javafx.fxml;
    exports app.dlav3;
}