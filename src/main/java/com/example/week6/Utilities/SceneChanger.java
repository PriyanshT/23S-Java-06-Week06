package com.example.week6.Utilities;

import com.example.week6.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneChanger {
    /*
    This will change the scene when called
     */
    public static void changeScenes(ActionEvent actionEvent, String fxmlFileName, String viewTitle) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("View/" + fxmlFileName));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        stage.setTitle(viewTitle);
        stage.setScene(scene);
        stage.show();
    }
}
