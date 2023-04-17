module com.example.gui_project0 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.FlipEndChars to javafx.fxml;
    exports com.example.FlipEndChars;
}