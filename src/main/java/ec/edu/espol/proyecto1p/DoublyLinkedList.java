/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ec.edu.espol.proyecto1p;

import java.util.List;

/**
 *
 * @author spupi
 */
public interface DoublyLinkedList<E> extends List<E>{
    
    public void moveToPrev();
    
    public void moveToNext();
    
    public Nodo<E> getHead();

    public Nodo<E> getTail();
    
}
