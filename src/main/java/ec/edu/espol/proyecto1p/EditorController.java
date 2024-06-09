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
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author leoza
 */



public class EditorController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    ArrayList<MedioDeTransporte> Lista;
    @FXML
    private VBox vpane;
    
    ArrayList<String> nameImages=ImageFunction.cargarImagenes("img");
    private MedioDeTransporte selected;
    @FXML
    private Button botonRegreso;
    @FXML
    private ScrollPane Scroll;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Lista=UserManager.getUsuario().getAutos();
        CargaInicial(Lista);
        vpane.setAlignment(Pos.CENTER);
        Scroll.setFitToWidth(true);
    }
    
    
    
    private void CargaInicial(ArrayList<MedioDeTransporte> t){
        
        vpane.getChildren().clear();
        for(MedioDeTransporte m:t){
            
                
            try {
                m.setFotos(Lector.filtrar(nameImages, m.getId()));
                String foto=m.getFotos().getCurrent();
                Image image = new Image(new FileInputStream("img/"+foto));
                ImageView imv = new ImageView(image);
                
                imv.addEventHandler(MouseEvent.MOUSE_CLICKED,(MouseEvent j) -> {
                    selected = m;
                    cargarVentana();
                    ImageView b = (ImageView)j.getSource();
                    Stage s = (Stage) b.getScene().getWindow();
                    s.close();
                });
               
                
                imv.setFitWidth(300);
                imv.setFitHeight(300);

                    // labels para el nombre y el costo
                Label nameLabel = new Label("Nombre: " + m.getNombre());
                Label costLabel = new Label("Costo: " + m.getPrecio());

                 
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
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
                
        }
    }
    
    
        public void cargarVentana()
    {
         try {
            FXMLLoader fxml = App.loadFXML("Cambios");
            Scene sc = new Scene(fxml.load(),600,600);
            CambiosController hc = fxml.getController();
            hc.setT1(selected);
            Stage st = new Stage();
            st.setScene(sc);
            st.show();
        } catch (IOException ex) {
            Alert a = new Alert(Alert.AlertType.ERROR,"No se pudo abrir el fxml");
            a.show();
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
    
}
