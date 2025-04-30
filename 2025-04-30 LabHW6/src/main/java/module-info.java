module com.example.hw5play {
    requires javafx.controls;
    requires javafx.fxml;
    requires junit;


    opens edu.wpi.hw6 to javafx.fxml;
    exports edu.wpi.hw6;
}