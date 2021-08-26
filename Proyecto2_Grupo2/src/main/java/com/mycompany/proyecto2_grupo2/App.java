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

    static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("VistaPrincipal.fxml"));
            Parent root = fxmlLoader.load();
            scene = new Scene(root, 590, 490);
            stage.setScene(scene);
            stage.show();
        }catch(IOException ex){
            ex.printStackTrace();
        }
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