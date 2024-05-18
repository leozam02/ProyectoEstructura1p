module ec.edu.espol.proyecto1p {
    requires javafx.controls;
    requires javafx.fxml;

    opens ec.edu.espol.proyecto1p to javafx.fxml;
    exports ec.edu.espol.proyecto1p;
}
