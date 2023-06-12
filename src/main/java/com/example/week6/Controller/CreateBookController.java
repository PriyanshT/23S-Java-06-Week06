package com.example.week6.Controller;

import com.example.week6.Utilities.DBUtility;
import com.example.week6.Model.Book;
import com.example.week6.Utilities.SceneChanger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CreateBookController implements Initializable {

    @FXML
    private TextField authorTextField;

    @FXML
    private CheckBox availibilityCheckBox;

    @FXML
    private TextField bookNameTextField;

    @FXML
    private Label finalLabel;

    @FXML
    private ComboBox<String> genreComboBox;

    @FXML
    private Spinner<Double> priceSpinner;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        finalLabel.setVisible(false);
        genreComboBox.getItems().addAll(Book.findGenres());
        SpinnerValueFactory<Double> spinnerValueFactory = new SpinnerValueFactory.DoubleSpinnerValueFactory(20.00, 200.00, 2.00, 5);
        priceSpinner.setValueFactory(spinnerValueFactory);
        priceSpinner.setEditable(true);

        TextField spinnerTextField = priceSpinner.getEditor();

        // anonymous inner class
//        spinnerTextField.textProperty().addListener(new ChangeListener<String>() {
//            @Override
//            public void changed(ObservableValue<? extends String> observableValue, String oldValue, String newValue) {
//                try {
//                    Double.parseDouble(newValue);
//                }catch (Exception e){
//                    finalLabel.setVisible(true);
//                    finalLabel.setText("Only double values allowed for price");
//                }
//            }
//        });

        // lambda function
        spinnerTextField.textProperty().addListener((observable,oldValue,newValue) -> {
            try {
                Double.parseDouble(newValue);
            }catch (Exception e){
                finalLabel.setVisible(true);
                finalLabel.setText("Only double values allowed for price");
                spinnerTextField.setText(oldValue);
            }
        });

    }

    @FXML
    void saveBook(ActionEvent event) {
        try {
            // System.out.println("I am here");
            String bookName = bookNameTextField.getText();
            String author = authorTextField.getText();
            String genre = genreComboBox.getSelectionModel().getSelectedItem();
            double price = priceSpinner.getValue();
            boolean availability = availibilityCheckBox.isSelected();

            Book book1 = new Book(bookName, author, genre, price, availability);
            finalLabel.setVisible(true);
            finalLabel.setText(book1.toString());

            // add book1 to db
            System.out.println("Book with ID " + DBUtility.insertBookIntoDB(book1) + " stored.");

        } catch (Exception e){
            finalLabel.setVisible(true);
            finalLabel.setText(e.getMessage());
        }
    }

    @FXML
    void viewTable_onClick(ActionEvent event) throws IOException {
        SceneChanger.changeScenes(event, "book-table-view.fxml", "View Book");
    }
}
