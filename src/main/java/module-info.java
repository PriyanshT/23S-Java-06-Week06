module com.example.week5 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.week6 to javafx.fxml;
    exports com.example.week6;
}