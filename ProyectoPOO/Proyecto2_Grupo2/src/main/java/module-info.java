module com.mycompany.proyecto2_grupo2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mycompany.proyecto2_grupo2 to javafx.fxml;
    exports com.mycompany.proyecto2_grupo2;
    requires mail;
}
