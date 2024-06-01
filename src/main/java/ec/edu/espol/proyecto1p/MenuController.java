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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
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
public class MenuController implements Initializable {

    @FXML
    private VBox vpane;
    private ArrayList<MedioDeTransporte> Lista;
    ArrayList<String> nameImages=ImageFunction.cargarImagenes("img");
    @FXML
    private ScrollPane Scroll;
    @FXML
    private ComboBox<?> ComboModelos;
    @FXML
    private TextField TextoPrecioInicial;
    @FXML
    private Button botonRegreso;
    @FXML
    private TextField TextoPrecioFInal;
    @FXML
    private TextField TextoKmDesde;
    @FXML
    private TextField TextoKMhasta;
    @FXML
    private Button BotonBuscar;
    @FXML
    private ComboBox<?> comboOrden;
    @FXML
    private Button botonCreacion;
    
    private MedioDeTransporte selected=null;
    
    
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


    private void CargaInicial(ArrayList<MedioDeTransporte> t){
        
        vpane.getChildren().clear();
        for(MedioDeTransporte m:t){
            
                
            try {
                m.setFotos(Lector.filtrar(nameImages, m.getId()));
                String foto=m.getFotos().get(0);
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
    
    
     private ArrayList<MedioDeTransporte> filtrarMediosTransporte(ArrayList<MedioDeTransporte> lista) {
        ArrayList<MedioDeTransporte> resultados = new ArrayList<>();

        for (MedioDeTransporte transporte : lista) {
            boolean cumplePrecio = true;
            boolean cumpleKm = true;

            // Filtrar por precio
            if (!TextoPrecioInicial.getText().isEmpty() || !TextoPrecioFInal.getText().isEmpty()) {
                if (!TextoPrecioInicial.getText().isEmpty()) {
                    double precioDesde = Double.parseDouble(TextoPrecioInicial.getText());
                    if (transporte.getPrecio() < precioDesde) {
                        cumplePrecio = false;
                    }
                }
                if (!TextoPrecioFInal.getText().isEmpty()) {
                    double precioHasta = Double.parseDouble(TextoPrecioFInal.getText());
                    if (transporte.getPrecio() > precioHasta) {
                        cumplePrecio = false;
                    }
                }
            }

            // Filtrar por kilometraje
            if (!TextoKmDesde.getText().isEmpty() || !TextoKMhasta.getText().isEmpty()) {
                if (!TextoKmDesde.getText().isEmpty()) {
                    double kmDesde = Double.parseDouble(TextoKmDesde.getText());
                    if (transporte.getKilometraje() < kmDesde) {
                        cumpleKm = false;
                    }
                }
                if (!TextoKMhasta.getText().isEmpty()) {
                    double kmHasta = Double.parseDouble(TextoKMhasta.getText());
                    if (transporte.getKilometraje() > kmHasta) {
                        cumpleKm = false;
                    }
                }
            }

            if (cumplePrecio && cumpleKm) {
                resultados.add(transporte);
            }
        }

        return resultados;
    }
    
    
    
        private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
       
        private boolean validarPrecios() {
        if (!TextoPrecioInicial.getText().isEmpty() && !TextoPrecioFInal.getText().isEmpty()) {
            double precioDesde = Double.parseDouble(TextoPrecioInicial.getText());
            double precioHasta = Double.parseDouble(TextoPrecioFInal.getText());
            if (precioDesde > precioHasta) {
                showAlert("Error", "El valor en \"Precio Desde\" debe ser menor o igual que el valor en \"Precio Hasta\".");
                return false;
            }
        }
        return true;
    }

    private boolean validarKilometros() {
        if (!TextoKmDesde.getText().isEmpty() && !TextoKMhasta.getText().isEmpty()) {
            double kmDesde = Double.parseDouble(TextoKmDesde.getText());
            double kmHasta = Double.parseDouble(TextoKMhasta.getText());
            if (kmDesde > kmHasta) {
                showAlert("Error", "El valor en \"Km Desde\" debe ser menor o igual que el valor en \"Km Hasta\".");
                return false;
            }
        }
        return true;
    }
        
        
        private boolean validarCampos() {
        // Verificacion que al menos un campo contenga un número válido
        boolean alMenosUnCampoValido =
                (TextoPrecioInicial.getText().matches("\\d+") || TextoPrecioFInal.getText().matches("\\d+")) ||
                (TextoKmDesde.getText().matches("\\d+") || TextoKMhasta.getText().matches("\\d+"));

        // Verificacion que todos los campos estén vacíos
        boolean todosVacios = TextoPrecioInicial.getText().isEmpty() && TextoPrecioFInal.getText().isEmpty() &&
                              TextoKmDesde.getText().isEmpty() && TextoKMhasta.getText().isEmpty();

            boolean todosNumeros = TextoPrecioInicial.getText().matches("\\d*") && TextoPrecioFInal.getText().matches("\\d*") &&
                    TextoKmDesde.getText().matches("\\d*") && TextoKMhasta.getText().matches("\\d*");

        if (!alMenosUnCampoValido || !todosNumeros) {

                showAlert("Entrada inválida", "Por favor, ingrese solo números en al menos uno de los campos.");
                return false;
        }
        else if (todosVacios) {
                showAlert("Campos vacíos", "Por favor, complete al menos uno de los campos.");
                return false;
        }

        return true; // Todos los campos son válidos
    }
        
        
    public void cargarVentana()
    {
         try {
            FXMLLoader fxml = App.loadFXML("Datos");
            Scene sc = new Scene(fxml.load(),600,600);
            DatosController hc = fxml.getController();
            hc.setSelected(selected);
            Stage st = new Stage();
            st.setScene(sc);
            st.show();
        } catch (IOException ex) {
            Alert a = new Alert(Alert.AlertType.ERROR,"No se pudo abrir el fxml");
            a.show();
        }
    }

    @FXML
    private void ModelosElection(ActionEvent event) {
    }

    @FXML
    private void PrecioDesde(ActionEvent event) {
    }

    @FXML
    private void regresar(ActionEvent event) {
    }

    @FXML
    private void PrecioHasta(ActionEvent event) {
    }

    @FXML
    private void KmDesde(ActionEvent event) {
    }

    @FXML
    private void KMHasta(ActionEvent event) {
    }

    @FXML
    private void BuscarBotonAction(ActionEvent event) {
          if (!validarCampos()) {
            return; // No continua si hay campos inválidos
        }

        if(!validarPrecios())
            return;
        if(!validarKilometros())
            return;
        
        ArrayList<MedioDeTransporte> resultados = filtrarMediosTransporte(Lista);
         CargaInicial(resultados);

    }

    @FXML
    private void ordenamiento(ActionEvent event) {
    }

    @FXML
    private void crear(ActionEvent event) {
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
    
    
}
