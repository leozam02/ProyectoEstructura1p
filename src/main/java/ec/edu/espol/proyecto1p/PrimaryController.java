package ec.edu.espol.proyecto1p;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class PrimaryController {

    private ArrayList<Usuario> users;
    @FXML
    private BorderPane border;
    @FXML
    private Button botonRegreso;
    
    
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    


    @FXML
    private void regreso(ActionEvent event) {
            abrirVentana("USERS");
            Button b = (Button) event.getSource();
            Stage curr = (Stage) b.getScene().getWindow();
            curr.close();
        
    }
    
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
