package ec.edu.espol.proyecto1p;


import java.io.IOException;
import java.net.URL;

import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class PrimaryController {

    private ArrayList<Usuario> users;
    @FXML
    private BorderPane border;
    @FXML
    private Button botonRegreso;
    @FXML
    private VBox vboxPrincipal;
    
    
    private ArrayList<MedioDeTransporte> Lista;
    
    
    
    
    public void initialize(URL url, ResourceBundle rb) {
        
        Lista=Lector.leerArchivo("Datos.csv");
        for(MedioDeTransporte g: Lista){
           System.out.print(g.toString());
           System.out.println("\n");
           
       }
        
    }    

    
    
    
    
    @FXML
    private void regreso(ActionEvent event) {
            abrirVentana("USERS");
            Button b = (Button) event.getSource();
            Stage curr = (Stage) b.getScene().getWindow();
            curr.close();
        
    }
    
    
        /*Comparator <String> cmp=new Comparator<String>(){
            @Override
            public int compare(String o1, String o2) {
                if (o1.equals(o2))
                    return 0;
                else
                    return 1;
            }
           
       };*/
    
    
    
    
        private void abrirVentana(String titulo)
    {
        try
        {
            FXMLLoader fxmlLoader = App.loadFXML("Usuario");
            Scene s = new Scene(fxmlLoader.load(), 810, 440);
            //PrimaryController jc = fxmlLoader.getController();
            Stage stage = new Stage();
            stage.setTitle(titulo);
            stage.setScene(s);
            stage.initModality(Modality.APPLICATION_MODAL);

            stage.show();
            
        }
        catch(IOException ex)
        {
            System.out.println("Error IO Exception");
        }
                
    } 

    
       
}
