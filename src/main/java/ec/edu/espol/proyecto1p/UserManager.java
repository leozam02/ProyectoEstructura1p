/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.proyecto1p;

/**
 *
 * @author leoza
 */
public class UserManager {
    //Se uso el metodo de patron singleton para evitar llamar la instancia  en cada momento
    
    private static UserManager instance;
    private ArrayList<Usuario> users;

    // Constructor privado para evitar instanciación directa
    private UserManager() {
        users = new ArrayList<>();
    }

    // Método para obtener la instancia única
    public static synchronized UserManager getInstance() {
        if (instance == null) {
            instance = new UserManager();
        }
        return instance;
    }

    // Métodos para manipular la lista de usuarios
    public ArrayList<Usuario> getUsers() {
        return users;
    }

    public void addUser(Usuario user) {
        users.add(user);
    }
    
    public boolean userExists(String name) {
    for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getName().equals(name)) {
                return true;
            }
        }
        return false;
    }
}
