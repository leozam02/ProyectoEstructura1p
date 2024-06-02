/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.proyecto1p;

import java.io.Serializable;
import java.util.Iterator;

/**
 *
 * @author PERSONAL
 */
public class DoubleLinkedList<E> implements Serializable, Iterable<E>{
    private Nodo<E> header;
    private Nodo<E> last;

    public DoubleLinkedList() {
        this.header = null;
        this.last = null;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Nodo<E> current = header;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public E next() {
                E data = current.data;
                current = current.next;
                return data;
            }
        };
    }
    
    public void add(E data) {
        Nodo<E> newNode = new Nodo<>(data);
        if (header == null) {
            header = last = newNode;
        } else {
            last.next = newNode;
            newNode.prev = last;
            last = newNode;
        }
    }

    public boolean remove(E data) {
        if (header == null) return false;

        if (header.data.equals(data)) {
            header = header.next;
            if (header != null) header.prev = null;
            else last = null;  // Si la lista se vuelve vacía
            return true;
        }

        Nodo<E> current = header;
        while (current != null) {
            if (current.data.equals(data)) {
                if (current.next != null) current.next.prev = current.prev;
                if (current.prev != null) current.prev.next = current.next;
                if (current == last) last = current.prev;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public E get(int index) {
        if (index < 0) throw new IndexOutOfBoundsException("Index: " + index);

        Nodo<E> current = header;
        for (int i = 0; i < index; i++) {
            if (current == null) throw new IndexOutOfBoundsException("Index: " + index);
            current = current.next;
        }
        if (current == null) throw new IndexOutOfBoundsException("Index: " + index);
        return current.data;
    }

    public int size() {
        int count = 0;
        Nodo<E> current = header;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }
}
