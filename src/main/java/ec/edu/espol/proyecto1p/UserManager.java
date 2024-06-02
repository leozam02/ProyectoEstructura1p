/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.proyecto1p;

import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author leoza
 */
public class UserManager  {
    
    

        private static Usuario usuario;

        // Método para establecer el usuario
        public static void setUsuario(Usuario usuarioNuevo) {
            usuario = usuarioNuevo;
        }

        // Método para obtener el usuario actual
        public static Usuario getUsuario() {
            return usuario;
        }
        public static void escribirUsuarioCSV(Usuario usuario, String filePath) {
            ArrayList<Usuario> usuarios = leerUsuariosCSV(filePath);
            boolean usuarioExiste = false;

            for (Usuario u : usuarios) {
                if (u.getName().equals(usuario.getName())) {
                    // El usuario ya existe, actualizar su información
                    u.setPassword(usuario.getPassword());
                    u.setAutos(usuario.getAutos());
                    u.setFavoritos(usuario.getFavoritos());
                    usuarioExiste = true;
                    break;
                }
            }

            if (!usuarioExiste) {
                // El usuario no existe, agregarlo a la lista
                usuarios.add(usuario);
            }

            // Ahora escribir la lista actualizada de usuarios en el archivo CSV
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
                for (Usuario u : usuarios) {
                    writer.write(u.getName() + "," + u.getPassword() + ",");
                    //+ autosToString(u.getAutos()) + "," + autosToString(u.getFavoritos())
                    writer.newLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private static ArrayList<Usuario> leerUsuariosCSV(String filePath) {
            ArrayList<Usuario> usuarios = new ArrayList<>();
            
            return usuarios;
        }

        private static String autosToString(ArrayList<MedioDeTransporte> autos) {
            // Convertir la lista de autos a una cadena de texto
            // Puedes implementar esta función según tu formato de escritura en CSV
            return ""; // Implementación ficticia, debes cambiarla según tus necesidades
        }

}
