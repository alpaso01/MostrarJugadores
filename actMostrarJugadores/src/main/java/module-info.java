module com.example.actmostrarjugadores {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.xml;
    requires java.compiler;


    opens com.example.actmostrarjugadores to javafx.fxml;
    exports com.example.actmostrarjugadores;
}