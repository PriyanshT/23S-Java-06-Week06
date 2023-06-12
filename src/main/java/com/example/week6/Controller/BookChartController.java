package com.example.week6.Controller;

import com.example.week6.Utilities.DBUtility;
import com.example.week6.Utilities.SceneChanger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.RadioButton;

import java.io.IOException;
import java.net.URL;
import java.security.SecureRandom;
import java.util.ResourceBundle;

public class BookChartController implements Initializable {

    @FXML
    private BarChart<String, Integer> barChart;

    @FXML
    private CategoryAxis categoryAxis;

    @FXML
    private NumberAxis numberAxis;

    @FXML
    private RadioButton availableRadioButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        barChart.getData().addAll(DBUtility.retrieveBookSalesFromDB());
        categoryAxis.setLabel("Book Name");
        numberAxis.setLabel("Units sold");
    }

    @FXML
    void addChartData_onClick(ActionEvent event) {
        XYChart.Series<String, Integer> unitsSold = new XYChart.Series<>();
        SecureRandom secureRandom = new SecureRandom();
        unitsSold.setName(String.valueOf(secureRandom.nextInt(2000, 2022)));

        unitsSold.getData().add(new XYChart.Data<>("A Clash of Kings", secureRandom.nextInt(20, 100)));
        unitsSold.getData().add(new XYChart.Data<>("FakeBook2", secureRandom.nextInt(20, 100)));
        unitsSold.getData().add(new XYChart.Data<>("FakeBook3", secureRandom.nextInt(20, 100)));

        barChart.getData().addAll(unitsSold);
    }

    @FXML
    void availableRadioButton_onClick(ActionEvent event) {
        barChart.getData().clear();
        if(availableRadioButton.isSelected()){
            barChart.getData().addAll(DBUtility.retrieveAvailableBookSalesFromDB());
        }else{
            barChart.getData().addAll(DBUtility.retrieveBookSalesFromDB());
        }
    }

    @FXML
    void viewTable_onClick(ActionEvent event) throws IOException {
        SceneChanger.changeScenes(event, "book-table-view.fxml", "View Book");
    }
}

