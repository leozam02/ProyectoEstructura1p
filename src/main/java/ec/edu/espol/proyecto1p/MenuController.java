/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ec.edu.espol.proyecto1p;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author leoza
 */
public class MenuController implements Initializable {

    @FXML
    private VBox vpane;
    private ArrayList<MedioDeTransporte> Lista;
    ArrayList<String> nameImages=ImageFunction.cargarImagenes("img");
    @FXML
    private ScrollPane Scroll;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
     vpane.setAlignment(Pos.CENTER);
     Scroll.setFitToWidth(true);
     Lista=Lector.leerArchivo("Datos.csv");
     CargaInicial(Lista);
    }


    private void CargaInicial(List<MedioDeTransporte> t){
        
        vpane.getChildren().clear();
        for(MedioDeTransporte m:t){
            
                
            try {
                m.setFotos(Lector.filtrar(nameImages, m.getId()));
                String foto=m.getFotos().get(0);
                Image image = new Image(new FileInputStream("img/"+foto));
                ImageView imv = new ImageView(image);
               
                
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
    
}
