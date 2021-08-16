package com.mycompany.proyecto2_grupo2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        Parent vista= loadFXML("/com/mycompany/proyecto2_grupo2/vistaPrincipal.fxml");
        
        scene = new Scene(vista, 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    public static void setRoot(Parent root) {
        scene.setRoot(root);
    }

    private static Parent loadFXML(String fxmlfile) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxmlfile));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}