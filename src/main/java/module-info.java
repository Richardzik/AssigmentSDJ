module com.example.assigmentsdj {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;

    opens com.example.assigmentssdj to javafx.fxml;
    opens com.example.assigmentsdj to javafx.fxml;
    opens com.example.assigmentsdj.View to javafx.fxml;
    exports com.example.assigmentsdj;
}