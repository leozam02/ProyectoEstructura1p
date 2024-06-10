package ec.edu.espol.proyecto1p;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("Usuario").load(), 680, 480);
        stage.setScene(scene);
        stage.show();
    }   

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml).load());
    }

    public static FXMLLoader loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader;
    }
    
    
           public static ArrayList<String>  cargarImagenes(String ruta) {
        ArrayList<String> nombresImagenes = ImageFunction.cargarImagenes(ruta);
        // Haz lo que necesites con la lista de nombres de imágenes
        for (String nombre : nombresImagenes) {
            System.out.println(nombre);
        }
        return  nombresImagenes;
    }

    public static void main(String[] args) {
        launch();
        

    }
        

}