/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ec.edu.espol.proyecto1p;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author leoza
 */
public class CreacionController implements Initializable {

    @FXML
    private Button botonImagen;
    @FXML
    private VBox vpane;
    @FXML
    private Button botonRegreso;
    @FXML
    private TextField TextoNombre;
    @FXML
    private TextField textoId;
    @FXML
    private ScrollPane Scroll;
    @FXML
    private TextField textoFecha;
    @FXML
    private TextField textoMarca;
    @FXML
    private TextField textoModelo;
    @FXML
    private TextField textoKilometraje;
    @FXML
    private TextField textoMotor;
    @FXML
    private TextField textoTransmision;
    @FXML
    private TextField textoPrecio;
    @FXML
    private TextField textoProvinicia;
    @FXML
    private TextField textoDesc;
    @FXML
    private Button botonCrear;
    @FXML
    private ScrollPane Scroll2;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
    
    @FXML
    private void crearBoton(ActionEvent event) {
        vpane.setAlignment(Pos.CENTER);
        Scroll2.setFitToWidth(true);
                if (!validarCampos()) {
            return;
        }
        // Crear el objeto MedioTransporte con los datos ingresados
        MedioDeTransporte nuevoMedio = crearMedioTransporte();
        System.out.println(nuevoMedio);
        Lector.escribirEnCSV(nuevoMedio);
        try {
            FXMLLoader fxml = App.loadFXML("Menu");
            Scene sc = new Scene(fxml.load(),600,600);
            Stage st = new Stage();
            st.setScene(sc);
            st.show();
            
            Button b = (Button)event.getSource();
            Stage s = (Stage) b.getScene().getWindow();
            s.close();
        } catch (IOException ex) {
            Alert a = new Alert(Alert.AlertType.ERROR,"No se pudo abrir el fxml");
            a.show();
        }
    }

    @FXML
    private void subirImagen(ActionEvent event) {
        vpane.setAlignment(Pos.CENTER);
        Scroll2.setFitToWidth(true);
            // Validar que todos los campos estén llenos
    if (!camposLlenos()) {
        // Mostrar un mensaje de error
        System.out.println("Por favor, complete todos los campos antes de subir una imagen.");
        return;
    }
    
    try {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select Image");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.jpg"));

        Stage stage = (Stage) vpane.getScene().getWindow();
        List<File> files = fileChooser.showOpenMultipleDialog(stage);

        if (files != null) {
            for (File file : files) {
                if (file.getName().toLowerCase().endsWith(".jpg")) {
                    try {
                        // Obtener la ruta de la carpeta "img"
                        String imgFolderPath = System.getProperty("user.dir") + File.separator + "img";

                        // Crear la carpeta "img" si no existe
                        File imgFolder = new File(imgFolderPath);
                        if (!imgFolder.exists()) {
                            imgFolder.mkdir();
                        }

                        // Generar el nuevo nombre del archivo
                        String newFileName = textoId.getText() + "-" + System.currentTimeMillis() + ".jpg";

                        // Crear un nuevo archivo en la carpeta "img" con el nuevo nombre
                        File imgFile = new File(imgFolderPath, newFileName);
                        if (imgFile.createNewFile()) {
                            // Copiar la imagen seleccionada al archivo creado
                            Files.copy(file.toPath(), imgFile.toPath(), StandardCopyOption.REPLACE_EXISTING);

                            // Mostrar la imagen en el VBox
                            Image image = new Image(imgFile.toURI().toString());
                            ImageView imageView = new ImageView(image);
                            imageView.setFitWidth(400);
                            imageView.setFitHeight(400);
                            imageView.setPreserveRatio(true);
                            vpane.getChildren().add(imageView);
                        } else {
                            System.out.println("No se pudo crear el archivo: " + imgFile.getName());
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("El archivo " + file.getName() + " no es un archivo .jpg");
                }
            }
        } else {
            System.out.println("No se seleccionaron archivos.");
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    }

    @FXML
    private void regresar(ActionEvent event) {
            try {
            FXMLLoader fxml = App.loadFXML("Menu");
            Scene sc = new Scene(fxml.load(),600,600);
            Stage st = new Stage();
            st.setScene(sc);
            st.show();
            
            Button b = (Button)event.getSource();
            Stage s = (Stage) b.getScene().getWindow();
            s.close();
        } catch (IOException ex) {
            Alert a = new Alert(Alert.AlertType.ERROR,"No se pudo abrir el fxml");
            a.show();
        }
    }

    
    
    
        private boolean validarCampos() {
                if (textoFecha.getText().isEmpty() || textoMarca.getText().isEmpty() || textoModelo.getText().isEmpty() ||
                        textoKilometraje.getText().isEmpty() || textoMotor.getText().isEmpty() ||
                        textoTransmision.getText().isEmpty() || textoPrecio.getText().isEmpty() ||
                        textoProvinicia.getText().isEmpty() || textoDesc.getText().isEmpty() ||
                        TextoNombre.getText().isEmpty() || textoId.getText().isEmpty()) {
                    showAlert("Campos vacíos", "Por favor, complete todos los campos.");
                    return false;
        }

        if (!esNumero(textoKilometraje.getText()) || !esNumero(textoMotor.getText()) || !esNumero(textoPrecio.getText())) {
            showAlert("Entrada inválida", "Los campos Kilometraje, Motor y Precio deben ser números.");
            return false;
        }

       

        return true;
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private boolean esNumero(String texto) {
        return texto.matches("\\d+");
    }

    private MedioDeTransporte crearMedioTransporte() {
        // Aquí puedes crear un nuevo objeto MedioTransporte con los datos ingresados en los campos de texto
        // Ejemplo:
        String fecha = textoFecha.getText();
        String marca = textoMarca.getText();
        String modelo = textoModelo.getText();
        int kilometraje = Integer.parseInt(textoKilometraje.getText());
        int motor = Integer.parseInt(textoMotor.getText());
        String transmision = textoTransmision.getText();
        int precio = Integer.parseInt(textoPrecio.getText());
        String provincia = textoProvinicia.getText();
        String descripcion = textoDesc.getText();
        String nombre = TextoNombre.getText();
        String id = textoId.getText();

        // Aquí puedes crear un nuevo objeto MedioTransporte con los datos obtenidos
        // y retornarlo
        return new MedioDeTransporte(fecha, marca, modelo, kilometraje, motor, transmision, precio, provincia, descripcion, nombre, id);
    }

    
    
    private boolean camposLlenos() {
        return !textoFecha.getText().isEmpty() &&
                !textoMarca.getText().isEmpty() &&
                !textoModelo.getText().isEmpty() &&
                !textoKilometraje.getText().isEmpty() &&
                !textoMotor.getText().isEmpty() &&
                !textoTransmision.getText().isEmpty() &&
                !textoPrecio.getText().isEmpty() &&
                !textoProvinicia.getText().isEmpty() &&
                !textoDesc.getText().isEmpty() &&
                !TextoNombre.getText().isEmpty() &&
                !textoId.getText().isEmpty();
    }

    
}
