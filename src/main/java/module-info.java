module com.example.assigmentsdj {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;

    opens com.example.assigmentsdj to javafx.fxml;
    exports com.example.assigmentsdj;
}