/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ec.edu.espol.proyecto1p;

import java.io.IOException;
import static java.lang.System.console;
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
    
    public static String welcome;
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
    ArrayList<Usuario> Lista;
    
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void registro(ActionEvent event) {
        
        if(nameUsuario.getText().isEmpty() || contrasenaUsuario.getText().isEmpty()){
            showAlert("ERROR DE BUSQUEDA", "Porfavor llene los dos campos de texto");
        }
        else{
            
            DoubleLinkedList<MedioDeTransporte> f = new DoubleLinkedList<>();
            String username = nameUsuario.getText();
            welcome=username;
            String password = (contrasenaUsuario.getText());
            Usuario u = new Usuario(username, password, new ArrayList<>(),f);
            //UserManager.escribirUsuarioCSV(u, "Usuarios.csv");
            UserManager.setUsuario(u);
            abrirVentana("AUTOS");
                Button b = (Button) event.getSource();
                Stage curr = (Stage) b.getScene().getWindow();
                curr.close();
            /*String username = nameUsuario.getText();
            String password = contrasenaUsuario.getText();
                Usuario u = new Usuario(username, password, new ArrayList<>(),new ArrayList<>());
                Lista.add(u);
                UserManager.guardarUsuario(Lista);
                abrirVentana("AUTOS");
                Button b = (Button) event.getSource();
                Stage curr = (Stage) b.getScene().getWindow();
                curr.close();

            if (UserManager.userExists(username,password)) {
                showAlert("ERROR DE REGISTRO", "El usuario ya existe");
            } else {
                Usuario u = new Usuario(username, password, new ArrayList<>(),new ArrayList<>());
                UserManager.guardarUsuario(u);
                
            }*/
        

        }
        
    }
    
    
    
      
    private void abrirVentana(String titulo)
    {
        try
        {
            FXMLLoader fxmlLoader = App.loadFXML("Menu");
            Scene s = new Scene(fxmlLoader.load(), 1510, 900);
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
    
        private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    
    
    
}
