/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ec.edu.espol.proyecto1p;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
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
    @FXML
    private Button siguienteVehiculo;
    @FXML
    private Button anteriorVehiculo;

    private int fotoActualIndex = 0; 
    
    
    private MedioDeTransporte selected;
    
    @FXML
    private HBox hbox;
    @FXML
    private Button botonFav;
    @FXML
    private Label infPrincipal;
    
    private List<MedioDeTransporte> vehiculos;
    
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
        hbox.getChildren().clear(); //Limpieza del Hbox

        //Verificar si se tiene fotos
        if (selected != null && selected.getFotos() != null && !selected.getFotos().isEmpty()) {
            //Lista de fotos del vehiculo
            
            /* CAMBIAR
            Redundancia: select fotos for each!?
            */
            DoubleCircularList<String> fotos = selected.getFotos();
            // Asegurarse de que el índice esta en los limites
            if (fotoActualIndex < 0) {
                fotoActualIndex = fotos.size() - 1; //Reiniciar al final de la lista
            } else if (fotoActualIndex >= fotos.size()) {
                fotoActualIndex = 0; //Reiniciar al principio de la lista
            }
            System.out.println(fotos.getCurrent());
            //Se crea la imagen
            String foto=selected.getFotos().getCurrent();
            Image image = new Image(new FileInputStream("img/"+foto));
            ImageView imv = new ImageView(image);
          
            imv.setFitWidth(300);
            imv.setFitHeight(300);
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
    private void anteriorVehiculo(ActionEvent event) {
        if (MenuController.Lista.moveToPrev()){
            this.selected = MenuController.Lista.getHead().data;
            if (this.selected!=null) {
                try {
                    mostrarImagen();
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
    
    @FXML
    private void siguienteVehiculo(ActionEvent event) {
        if(MenuController.Lista.moveToNext()){
            this.selected = MenuController.Lista.getHead().data;
            if (this.selected!=null) {
                try {
                    mostrarImagen();
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
    
    
    @FXML
    private void clickDerecha(ActionEvent event) {
        selected.getFotos().moveToNext();

        try {
            mostrarImagen(); 
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }

    }

    @FXML
    private void clickIzquierda(ActionEvent event) {
        selected.getFotos().moveToPrev();
        
        try {
            mostrarImagen(); 
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        
    }

    @FXML
    private void favorito(ActionEvent event) {
        vehiculos=Lector.leerArchivo("Datos.csv");
        
        if(!(Lector.igualdad(UserManager.getUsuario().getFavoritos(),selected))){
            
            UserManager.getUsuario().getFavoritos().add(selected);
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
        else{
            showAlert("FAVORITO YA AGREGADO","BUSQUE OTRO VEHICULO");
        }
        
        
        System.out.println(UserManager.getUsuario().getFavoritos().get(0));
        
    }
    
    
      private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
      
      private void cargarInfo() {
        vpaneNombre.getChildren().clear();
        Label nameLabel = new Label("Nombre: " + selected.getNombre());
        Label costLabel = new Label("Costo: " + selected.getPrecio());
        Label modeloLabel = new Label("Modelo: " + selected.getModelo());
        Label kmLabel = new Label("Kilometraje: " + selected.getKilometraje());
        Label descLabel = new Label("Descripción: " + selected.getDescripcion());
        VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10)); 
        vbox.getChildren().add(nameLabel);
        vbox.getChildren().add(costLabel);
        vbox.getChildren().add(modeloLabel);
        vbox.getChildren().add(kmLabel);
        vbox.getChildren().add(descLabel);
        
        vbox.setAlignment(Pos.CENTER);
        vbox.setFillWidth(true);
        
        vpaneNombre.getChildren().add(vbox);
              
    }

}
