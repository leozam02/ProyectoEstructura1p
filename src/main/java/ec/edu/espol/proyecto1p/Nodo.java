/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.proyecto1p;

import java.io.Serializable;

/**
 *
 * @author PERSONAL
 */
public class Nodo<E> implements Serializable {
    E data;
    Nodo<E> next;
    Nodo<E> prev;

    public Nodo(E data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
    
}
