module com.example.week5 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.week6 to javafx.fxml;
    exports com.example.week6;
    exports com.example.week6.Model;
    opens com.example.week6.Model to javafx.fxml;
    exports com.example.week6.Controller;
    opens com.example.week6.Controller to javafx.fxml;
    exports com.example.week6.Utilities;
    opens com.example.week6.Utilities to javafx.fxml;
}