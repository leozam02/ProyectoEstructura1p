/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.proyecto1p;

/**
 *
 * @author PERSONAL
 */
public class Vehiculo {
    private double precio;
    private String marca;
    private String modelo;
    private int año;
    private float kilometraje;
    private String motor;
    private String transmision;
    private double peso;
    private String ubicacion;
    private DoubleLinkedList<Foto> fotos;
    private DoubleLinkedList<HistorialAccidente> historialAccidente;
    private DoubleLinkedList<Servicio> historialServicios;
    private DoubleLinkedList<Reparacion> reparaciones;
    private boolean favorito;

    public Vehiculo(double precio, String marca, String modelo, int año, float kilometraje, String motor, String transmision, double peso, String ubicacion, DoubleLinkedList<Foto> fotos, DoubleLinkedList<HistorialAccidente> historialAccidente, DoubleLinkedList<Servicio> historialServicios, DoubleLinkedList<Reparacion> reparaciones, boolean favorito) {
        this.precio = precio;
        this.marca = marca;
        this.modelo = modelo;
        this.año = año;
        this.kilometraje = kilometraje;
        this.motor = motor;
        this.transmision = transmision;
        this.peso = peso;
        this.ubicacion = ubicacion;
        this.fotos = new DoubleLinkedList<>();
        this.historialAccidente = new DoubleLinkedList<>();
        this.historialServicios = new DoubleLinkedList<>();
        this.reparaciones = new DoubleLinkedList<>();
        this.favorito = favorito;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public float getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(float kilometraje) {
        this.kilometraje = kilometraje;
    }

    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

    public String getTransmision() {
        return transmision;
    }

    public void setTransmision(String transmision) {
        this.transmision = transmision;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public DoubleLinkedList<Foto> getFotos() {
        return fotos;
    }

    public void setFotos(DoubleLinkedList<Foto> fotos) {
        this.fotos = fotos;
    }

    public DoubleLinkedList<HistorialAccidente> getHistorialAccidente() {
        return historialAccidente;
    }

    public void setHistorialAccidente(DoubleLinkedList<HistorialAccidente> historialAccidente) {
        this.historialAccidente = historialAccidente;
    }

    public DoubleLinkedList<Servicio> getHistorialServicios() {
        return historialServicios;
    }

    public void setHistorialServicios(DoubleLinkedList<Servicio> historialServicios) {
        this.historialServicios = historialServicios;
    }

    public DoubleLinkedList<Reparacion> getReparaciones() {
        return reparaciones;
    }

    public void setReparaciones(DoubleLinkedList<Reparacion> reparaciones) {
        this.reparaciones = reparaciones;
    }

    public boolean isFavorito() {
        return favorito;
    }

    public void setFavorito(boolean favorito) {
        this.favorito = favorito;
    }
    
    public void addFoto(Foto foto) {
        fotos.add(foto);
    }
    
    public void addHistorialAccidente(HistorialAccidente accidente) {
        historialAccidente.add(accidente);
    }
    
     public void addHistorialServicio(Servicio servicio) {
        historialServicios.add(servicio);
    }
     
     public void addReparacion(Reparacion reparacion) {
        reparaciones.add(reparacion);
    }
     
     

           
}
