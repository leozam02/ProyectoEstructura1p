/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.proyecto1p;

import java.io.Serializable;

/**
 *
 * @author leoza
 */
public class Usuario {
    private String name;
    private String password;
    private ArrayList<Vehiculo> autos;
    

    public Usuario(String name, String password, ArrayList<Vehiculo> autos) {
        this.name = name;
        this.password = password;
        this.autos = autos;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public ArrayList<Vehiculo> getAutos() {
        return autos;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAutos(ArrayList<Vehiculo> autos) {
        this.autos = autos;
    }
    
    
    
}
