/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.proyecto1p;

import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 *
 * @author leoza
 */
public class ArrayList<E> implements List<E>, Serializable {
    private static final long serialVersionUID=1L;
    private E [] elements=null;
    private int capacity =100;
    private int effectiveSize;

    public ArrayList() {
        elements= (E []) (new Object [capacity]);
        effectiveSize=0;
    }
    
    private void addCapacity (){
        E [] tmp= (E []) (new Object [capacity*2]);
        for (int i=0; i<capacity; i++){
            tmp[i]=elements[i];
            
        }
        
        elements=tmp;
        capacity=capacity*2;
    }
    
    
     @Override
    public boolean add(E e) {
        if(e==null)
            return false;
        else if(isEmpty()){
            elements[effectiveSize++]=e;
            return true;
        }
        else if (isFull()){
            addCapacity();
        }
        elements[effectiveSize]=e;
        effectiveSize++;
        return true;

    }
    
    
        @Override
    public E get(int index) {
        if(!this.isEmpty() && index <effectiveSize)
            return elements[index];
        return null;
    }
    
    
    

    @Override
    public int size() {
       return effectiveSize;
    }
    
    public boolean isFull(){
        return effectiveSize==capacity;
    }
    
    @Override
    public boolean isEmpty() {
       return effectiveSize==0;
    }
    
        public ArrayList<E> FindInt( Comparator<E> cmp ){
        ArrayList<E> results=new ArrayList();
        for(E e:this){
            //if(cmp.compare(e, )<0)
                results.add(e);
                
        }
        return results;
    }

        
        
        
    
    
    @Override
    public boolean contains(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Iterator<E> iterator() {
                Iterator<E> it=new Iterator<E>(){
            int cursor=0;

            @Override
            public boolean hasNext() {
                return cursor<effectiveSize;
            }

            @Override
            public E next() {
                E e= elements[cursor];
                cursor++;
                return e;
            }
            
            
        };
        return it;
    }

    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }



    @Override
        public boolean remove(Object o) {
            if (o == null) {
                return false;
            }

            for (int i = 0; i < effectiveSize; i++) {
                if (o.equals(elements[i])) {
                    
                    for (int j = i; j < effectiveSize - 1; j++) {
                        elements[j] = elements[j + 1];
                    }
                    
                    elements[effectiveSize - 1] = null;
                    effectiveSize--;
                    return true;
                }
            }
            return false;
        }


    @Override
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }



    @Override
    public E set(int index, E element) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void add(int index, E element) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public E remove(int index) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int indexOf(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int lastIndexOf(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ListIterator<E> listIterator() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
