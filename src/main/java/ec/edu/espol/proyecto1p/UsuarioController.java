/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ec.edu.espol.proyecto1p;

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
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author leoza
 */
public class UsuarioController implements Initializable {

    @FXML
    private HBox hbox;
    @FXML
    private TextField nameUsuario;
    @FXML
    private TextField contrasenaUsuario;
    @FXML
    private VBox vbox1;
    @FXML
    private VBox vbox2;
    @FXML
    private Button boton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void registro(ActionEvent event) {
        
        if(nameUsuario.getText().isEmpty() || contrasenaUsuario.getText().isEmpty()){
            showAlert("ERROR DE BUSQUEDA", "Porfavor llene los dos campos de texto");
        }
        else{
            
                   String username = nameUsuario.getText();
        String password = contrasenaUsuario.getText();

        if (UserManager.getInstance().userExists(username)) {
            showAlert("ERROR DE REGISTRO", "El usuario ya existe");
        } else {
            Usuario u = new Usuario(username, password, new ArrayList<>());
            UserManager.getInstance().addUser(u);
            abrirVentana("AUTOS");
            Button b = (Button) event.getSource();
            Stage curr = (Stage) b.getScene().getWindow();
            curr.close();
        }

        }
    }
    
    
      
    private void abrirVentana(String titulo)
    {
        try
        {
            FXMLLoader fxmlLoader = App.loadFXML("primary");
            Scene s = new Scene(fxmlLoader.load(), 810, 440);
            PrimaryController jc = fxmlLoader.getController();
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
    
        private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    
    
    
}
