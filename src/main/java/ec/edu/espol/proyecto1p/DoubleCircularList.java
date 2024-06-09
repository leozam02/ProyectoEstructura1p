/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ec.edu.espol.proyecto1p;

/**
 *
 * @author User Dell
 */
public interface DoubleCircularList<E> {
    
    public void moveToPrev();
    
    public void moveToNext();

    public void addFirst(E element);
       
    
    public boolean deleteCurrent();    

    public int size();
    
    public boolean isEmpty();
    
    public E getCurrent();

}
