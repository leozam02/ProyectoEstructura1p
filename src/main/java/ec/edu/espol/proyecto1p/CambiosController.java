/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ec.edu.espol.proyecto1p;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author leoza
 */
public class CambiosController implements Initializable {

    @FXML
    private Button botonEliminar;
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
    private TextField textoProvincia;
    @FXML
    private Label T;
    @FXML
    private TextField textoDesc;
    @FXML
    private VBox vpane;
    @FXML
    private TextField textoNombre;
    @FXML
    private Button botonEditar;
    ArrayList<String> nameImages=ImageFunction.cargarImagenes("img");
    MedioDeTransporte t1;

    
    
    
    private ArrayList<MedioDeTransporte> Lista;
    @FXML
    private Button botonImagen;
    @FXML
    private ScrollPane Scroll;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         
       
    }    
    
    
private boolean camposLlenos() {
    return !textoFecha.getText().isEmpty() &&
           !textoMarca.getText().isEmpty() &&
           !textoModelo.getText().isEmpty() &&
           !textoKilometraje.getText().isEmpty() &&
           !textoMotor.getText().isEmpty() &&
           !textoTransmision.getText().isEmpty() &&
           !textoPrecio.getText().isEmpty() &&
           !textoProvincia.getText().isEmpty() && 
           !textoDesc.getText().isEmpty() &&
           !textoNombre.getText().isEmpty();
}

    

        private boolean validarCampos() {
                if (textoFecha.getText().isEmpty() || textoMarca.getText().isEmpty() || textoModelo.getText().isEmpty() ||
                        textoKilometraje.getText().isEmpty() || textoMotor.getText().isEmpty() ||
                        textoTransmision.getText().isEmpty() || textoPrecio.getText().isEmpty() ||
                        textoProvincia.getText().isEmpty() || textoDesc.getText().isEmpty() ||
                        textoNombre.getText().isEmpty() ) {
                    showAlert("Campos vacíos", "Por favor, complete todos los campos.");
                    return false;
        }

        if (!esNumero(textoKilometraje.getText()) || !esNumero(textoMotor.getText()) || !esNumero(textoPrecio.getText())) {
            showAlert("Entrada inválida", "Los campos Kilometraje, Motor y Precio deben ser números.");
            return false;
        }

       

        return true;
    }
    
    private void CargaInicial() throws FileNotFoundException{
        System.out.println(UserManager.getUsuario().getAutos().size());
        //t1.setFotos();
        for (int i=0; i<t1.getFotos().size();i++){
        String foto=t1.getFotos().getCurrent();
        Image image = new Image(new FileInputStream("img/"+foto));
                ImageView imv = new ImageView(image);
                
                imv.addEventHandler(MouseEvent.MOUSE_CLICKED,(MouseEvent j) -> {
                          System.out.println("Clic detectado en la imagen: " + "img/" + foto);
                boolean deleted = ImageFunction.deleteImage("img/" + foto);
                if (deleted) {
                    System.out.println("La imagen fue eliminada exitosamente.");
                } else {
                    System.err.println("No se pudo eliminar la imagen.");
                }
                });
               
                
                imv.setFitWidth(200);
                imv.setFitHeight(200);

                    // labels para el nombre y el costo
                Label nameLabel = new Label("Nombre: " + t1.getNombre());
                Label costLabel = new Label("Costo: " + t1.getPrecio());

                 
                VBox vbox = new VBox();
                vbox.setSpacing(5);
                vbox.setPadding(new Insets(10)); 
                vbox.getChildren().add(imv);
                vbox.getChildren().add(nameLabel);
                vbox.getChildren().add(costLabel);
                vbox.setAlignment(Pos.CENTER);
                vbox.setFillWidth(true);

                // Añado el VBox al HBox inicial
                vpane.getChildren().add(vbox);
                t1.getFotos().moveToNext();
        
    }
        
    }

    @FXML
    private void Eliminar(ActionEvent event) {
          for (MedioDeTransporte vehiculo : UserManager.getUsuario().getAutos()) {
                if (vehiculo.getId().equals(t1.getId())) {
            UserManager.getUsuario().getAutos().remove(vehiculo);
            return; // Salir del bucle cuando se elimine el carro
        }
    }
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
            System.out.println(UserManager.getUsuario().getAutos().size());
        
    }

    @FXML
    private void editarCambios(ActionEvent event) {
        
        if (!validarCampos()) {
                return;
        }

        // Se elimina el vehículo antiguo 
        Usuario usuarioActual = UserManager.getUsuario();
        for (MedioDeTransporte vehiculo : usuarioActual.getAutos()) {
            if (vehiculo.getId().equals(t1.getId())) {
                usuarioActual.getAutos().remove(vehiculo);
                break; // Salir del bucle
            }
        }
        System.out.println(UserManager.getUsuario().getAutos().size());

        //Editar el vehículo y agregarlo a la lista del usuario
        EditarMedioTransporte();
        usuarioActual.getAutos().add(t1);

        //Escribir los cambios en el archivo CSV
        Lector.escribirEnCSV(t1);
        
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
        System.out.println(UserManager.getUsuario().getAutos().size());
      
    }
    
 
    private void EditarMedioTransporte() {
        
        String fecha = textoFecha.getText();
        String marca = textoMarca.getText();
        String modelo = textoModelo.getText();
        int kilometraje = Integer.parseInt(textoKilometraje.getText());
        int motor = Integer.parseInt(textoMotor.getText());
        String transmision = textoTransmision.getText();
        int precio = Integer.parseInt(textoPrecio.getText());
        String provincia = textoProvincia.getText();
        String descripcion = textoDesc.getText();
        String nombre = textoNombre.getText();
        t1.setFecha(fecha);
        t1.setDescripcion(descripcion);
        t1.setMarca(marca);
        t1.setKilometraje(kilometraje);
        t1.setModelo(modelo);
        t1.setMotor(motor);
        t1.setNombre(nombre);
        t1.setProvincia(provincia);
                t1.setPrecio(precio);
                
               t1.setTransmision(transmision);
  
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

    public void setT1(MedioDeTransporte t1) {
        this.t1 = t1;
        try {
            CargaInicial();
            System.out.println(UserManager.getUsuario().getAutos().size());
            
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        
        Lector.eliminarLineaPorID("Datos.csv", t1.getId());
        //Se elimina el vehiculo cuando acceda a esta interfaz 
    }

    @FXML
    private void subirImagen(ActionEvent event) {
        vpane.setAlignment(Pos.CENTER);
        Scroll.setFitToWidth(true);
       //Validar que todos los campos estén llenos
        /*if (!camposLlenos()) {
            // Mostrar un mensaje de error
            System.out.println("Por favor, complete todos los campos antes de subir una imagen.");
            return;
        }*/
            //FileChooser para agregar la imagen
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
                            String newFileName = t1.getId() + "-" + System.currentTimeMillis() + ".jpg";

                            // Crear un nuevo archivo en la carpeta "img" con el nuevo nombre
                            File imgFile = new File(imgFolderPath, newFileName);
                            if (imgFile.createNewFile()) {
                                // Copiar la imagen seleccionada al archivo creado
                                Files.copy(file.toPath(), imgFile.toPath(), StandardCopyOption.REPLACE_EXISTING);

                                // Mostrar la imagen en el VBox
                                Image image = new Image(imgFile.toURI().toString());
                                ImageView imageView = new ImageView(image);
                                imageView.setFitWidth(200);
                                imageView.setFitHeight(200);
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

}
