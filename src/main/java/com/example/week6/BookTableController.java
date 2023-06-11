package com.example.week6;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class BookTableController implements Initializable {
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


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // System.out.println(DBUtility.retrieveBooksFromDB());

        idColumn.setCellValueFactory(new PropertyValueFactory<>("bookID"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("bookName"));
        authorColumn.setCellValueFactory(new PropertyValueFactory<>("author"));
        genreColumn.setCellValueFactory(new PropertyValueFactory<>("genre"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        availableColumn.setCellValueFactory(new PropertyValueFactory<>("available"));
        booksSoldColumn.setCellValueFactory(new PropertyValueFactory<>("booksSold"));

        tableView.getItems().addAll(DBUtility.retrieveBooksFromDB());
    }

    @FXML
    void addNewBook_onClick(ActionEvent event) throws IOException {
        SceneChanger.changeScenes(event, "create-book-view.fxml", "Save Book!");
    }

    @FXML
    void viewChart_onClick(ActionEvent event) {

    }
}
