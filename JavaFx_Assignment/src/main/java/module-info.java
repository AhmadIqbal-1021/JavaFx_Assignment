module com.example.javafx_assignment {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.javafx_assignment to javafx.fxml;
    exports com.example.javafx_assignment;
}