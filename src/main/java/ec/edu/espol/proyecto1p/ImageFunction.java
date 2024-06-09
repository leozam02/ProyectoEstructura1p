/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.proyecto1p;

import java.io.File;

/**
 *
 * @author leoza
 */
public class ImageFunction {
    
    public static ArrayList<String> cargarImagenes(String ruta) {
    
     ArrayList<String> g=new ArrayList<>();
     File folder = new File(ruta);
     
        if (folder.exists() && folder.isDirectory()) {
            // Obtener la lista de archivos dentro de la carpeta
            File[] listOfFiles = folder.listFiles();

            //Se Verifica que no sea null
            if (listOfFiles != null) {
                // Iterar sobre los archivos y mostrar sus nombres
                for (File file : listOfFiles) {
                    if (file.isFile()) {
                        
                        g.add(file.getName());
                        //Se agregan los nombres
                    }
                }
                
                return g;
            } else {
                System.out.println("La carpeta está vacía o no se pudo leer.");
            }
        } else {
            System.out.println("La carpeta 'img' no existe.");
        }
        return null;
    }
        
    
    
    public static ArrayList<String> filtrar(ArrayList<String> lista, String marca) {
        ArrayList<String> filtrados = new ArrayList<>();
        for (String t : lista) {
           String [] tokens=t.split("-");
           if(marca.equals(tokens[0]))
               filtrados.add(t);
        }
        return filtrados;
    }
        
     public static boolean deleteImage(String imageName) {
        // Construir la ruta completa del archivo
        //String imagePath = IMAGE_DIRECTORY + imageName;
        File imageFile = new File(imageName);

        // Intentar eliminar el archivo
        if (imageFile.exists()) {
            if (imageFile.delete()) {
                System.out.println("Imagen eliminada: " + imageName);
                return true;
            } else {
                System.err.println("Error al eliminar la imagen: " + imageName);
                return false;
            }
        } else {
            System.err.println("La imagen no existe: " + imageName);
            return false;
        }
        
    }
     
     
     
    public static boolean delete(String imageName) {
        // Construir la ruta completa del archivo
        File imageFile = new File(imageName);

        // Mostrar la ruta absoluta del archivo para depuración
        System.out.println("Intentando eliminar la imagen en: " + imageFile.getAbsolutePath());

        // Intentar eliminar el archivo
        if (imageFile.exists()) {
            if (imageFile.delete()) {
                System.out.println("Imagen eliminada: " + imageName);
                return true;
            } else {
                System.err.println("Error al eliminar la imagen: " + imageName);
                return false;
            }
        } else {
            System.err.println("La imagen no existe: " + imageName);
            return false;
        }
    }
        
}
