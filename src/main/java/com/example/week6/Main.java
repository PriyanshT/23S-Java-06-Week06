package com.example.week6;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("create-book-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Save Book!");
        stage.getIcons().add(new Image("file:src/main/resources/com/example/week6/favicon.png"));
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}