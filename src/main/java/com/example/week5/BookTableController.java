package com.example.week5;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.io.IOException;

public class BookTableController {
    @FXML
    private TableView<Book> tableView;

    @FXML
    private TableColumn<Book, String> authorColumn;

    @FXML
    private TableColumn<Book, Boolean> availableColumn;

    @FXML
    private TableColumn<Book, Integer> booksSoldColumn;

    @FXML
    private TableColumn<Book, String> genreColumn;

    @FXML
    private TableColumn<Book, Integer> idColumn;

    @FXML
    private TableColumn<Book, String> nameColumn;

    @FXML
    private TableColumn<Book, Double> priceColumn;


    @FXML
    void addNewBook_onClick(ActionEvent event) throws IOException {
        SceneChanger.changeScenes(event, "create-book-view.fxml", "Save Book!");
    }

    @FXML
    void viewChart_onClick(ActionEvent event) {

    }

}
