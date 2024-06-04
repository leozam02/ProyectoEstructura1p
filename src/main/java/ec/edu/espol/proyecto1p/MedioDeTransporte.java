/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.proyecto1p;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author leoza
 */
public class MedioDeTransporte  {
       private String fecha;
    private String Marca;
    private String Modelo;
    private int kilometraje;
    private int motor;
    private String transmision;
    private int precio;
    private String provincia;
    private String descripcion;
    private String nombre;
    private String id;
    private DoubleCircularList<String> fotos;
    private static final long serialVersionUID=1L;


    public MedioDeTransporte(String fecha, String Marca, String Modelo, int kilometraje, int motor, String transmision, int precio, String provincia, String descripcion, String nombre, String id) {
        this.fecha = fecha;
        this.Marca = Marca;
        this.Modelo = Modelo;
        this.kilometraje = kilometraje;
        this.motor = motor;
        this.transmision = transmision;
        this.precio = precio;
        this.provincia = provincia;
        this.descripcion = descripcion;
        this.nombre = nombre;
        this.id=id;
    
    }
    
   

    public String getFecha() {
        return fecha;
    }

    public String getMarca() {
        return Marca;
    }

    public String getModelo() {
        return Modelo;
    }

    public int getKilometraje() {
        return kilometraje;
    }

    public int getMotor() {
        return motor;
    }

    public String getTransmision() {
        return transmision;
    }

    public int getPrecio() {
        return precio;
    }

    public String getProvincia() {
        return provincia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getId() {
        return id;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }

    public void setModelo(String Modelo) {
        this.Modelo = Modelo;
    }

    public void setKilometraje(int kilometraje) {
        this.kilometraje = kilometraje;
    }

    public void setMotor(int motor) {
        this.motor = motor;
    }

    public void setTransmision(String transmision) {
        this.transmision = transmision;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setFotos(DoubleCircularList<String> fotos) {
        this.fotos = fotos;
    }

    public DoubleCircularList<String> getFotos() {
        return fotos;
    }
        
    
        @Override
    public String toString(){
        return fecha + ";" + Marca + ";" + Modelo + ";" + kilometraje + ";" + motor + ";" + transmision + ";" + precio + ";" + provincia + ";" + descripcion + ";" + nombre + ";" + id;
    }

    
     
}
