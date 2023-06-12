package com.example.week6;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class BookChartController implements Initializable {

    @FXML
    private BarChart<String, Integer> barChart;

    @FXML
    private CategoryAxis categoryAxis;

    @FXML
    private NumberAxis numberAxis;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        barChart.getData().addAll(DBUtility.retrieveBookSalesFromDB());
    }

    @FXML
    void addChartData_onClick(ActionEvent event) {
        XYChart.Series<String, Integer> unitsSold = new XYChart.Series<>();
        unitsSold.getData().add(new XYChart.Data<>("A Clash of Kings", 20));
        unitsSold.getData().add(new XYChart.Data<>("FakeBook2", 40));
        unitsSold.getData().add(new XYChart.Data<>("FakeBook3", 60));

        barChart.getData().addAll(unitsSold);
    }

    @FXML
    void viewTable_onClick(ActionEvent event) throws IOException {
        SceneChanger.changeScenes(event, "book-table-view.fxml", "View Book");
    }
}

