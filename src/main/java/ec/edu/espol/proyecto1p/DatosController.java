/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ec.edu.espol.proyecto1p;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author leoza
 */
public class DatosController implements Initializable {

    @FXML
    private Button botonregreso;
    @FXML
    private VBox vpaneNombre;
    @FXML
    private VBox vpaneDesc;
    @FXML
    private Button derecha;
    @FXML
    private Button izquierda;

    private int fotoActualIndex = 0; 
    
    
    private MedioDeTransporte selected;
    @FXML
    private HBox hbox;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    public void setSelected(MedioDeTransporte selected) {
        this.selected = selected;
        try {
            mostrarImagen();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    private void mostrarImagen() throws FileNotFoundException  {
        hbox.getChildren().clear(); // Limpiar el HBox antes de agregar la imagen

        // Verificar si el objeto tiene fotos
        if (selected != null && selected.getFotos() != null && !selected.getFotos().isEmpty()) {
            // Obtener la lista de fotos del objeto
            ArrayList<String> fotos = selected.getFotos();
            // Asegurarse de que el índice de la foto actual esté dentro de los límites
            if (fotoActualIndex < 0) {
                fotoActualIndex = fotos.size() - 1; // Reiniciar al final de la lista
            } else if (fotoActualIndex >= fotos.size()) {
                fotoActualIndex = 0; // Reiniciar al principio de la lista
            }
            System.out.println(fotos.get(fotoActualIndex));
            // Crear un ImageView y cargar la imagen correspondiente
            String foto=selected.getFotos().get(fotoActualIndex);
            Image image = new Image(new FileInputStream("img/"+foto));
            ImageView imv = new ImageView(image);
            
            // Configurar el tamaño del ImageView (ajústalo según tus necesidades)
            imv.setFitWidth(300);
            imv.setFitHeight(300);
            // Agregar el ImageView al HBox
            hbox.getChildren().add(imv);
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

    @FXML
    private void clickDerecha(ActionEvent event) {
        fotoActualIndex++; // Incrementar el índice
        try {
            mostrarImagen(); // Mostrar la nueva imagen
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }

    }

    @FXML
    private void clickIzquierda(ActionEvent event) {
        
                fotoActualIndex--; // Decrementar el índice
        try {
            mostrarImagen(); // Mostrar la nueva imagen
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        
    }
    
}
