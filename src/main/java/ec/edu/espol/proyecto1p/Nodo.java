/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.proyecto1p;

/**
 *
 * @author PERSONAL
 */
public class Nodo<E> {
    Nodo<E> next;
    Nodo<E> prev;
    E data;

    Nodo(E data) {
        this.next = null;
        this.prev = null;
        this.data = data;
    }
}
