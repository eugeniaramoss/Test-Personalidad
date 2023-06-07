module com.example.hoja11 {
    requires javafx.controls;
    requires javafx.fxml;
            
            requires com.dlsc.formsfx;
    requires java.sql;

    opens com.example.hoja11 to javafx.fxml;
    exports com.example.hoja11;
    exports com.example.hoja11.Datos;
    opens com.example.hoja11.Datos to javafx.fxml;
    exports com.example.hoja11.Control;
    opens com.example.hoja11.Control to javafx.fxml;
}