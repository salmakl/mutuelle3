package com.example.brief3;

import com.example.brief3.controllers.LoginController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.log4j.Logger;

import java.io.IOException;

public class Mutuelle extends Application {
    static final Logger log = Logger.getLogger(LoginController.class.getName());

    private static Stage stg;
    @Override
    public void start(Stage stage) throws IOException {
        stg=stage;
        stage.setResizable(false);

        FXMLLoader fxmlLoader = new FXMLLoader(Mutuelle.class.getResource("login-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Mutuelle");
        stage.setScene(scene);
        stage.show();
    }
    public void chaneScene(String fxml) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(fxml));
        stg.setScene(new Scene(root));
    }

    public static void main(String[] args) {
        log.info("Starting application");
        launch();
    }
}