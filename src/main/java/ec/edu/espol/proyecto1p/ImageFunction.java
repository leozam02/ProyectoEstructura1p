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
    // Implementación del método
     ArrayList<String> g=new ArrayList<>();
        File folder = new File(ruta);
        
        // Asegúrate de que la carpeta exista
        if (folder.exists() && folder.isDirectory()) {
            // Obtener la lista de archivos dentro de la carpeta
            File[] listOfFiles = folder.listFiles();

            // Verificar que no sea null
            if (listOfFiles != null) {
                // Iterar sobre los archivos y mostrar sus nombres
                for (File file : listOfFiles) {
                    if (file.isFile()) {
                        //System.out.println(file.getName());
                        g.add(file.getName());
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
}
