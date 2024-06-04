/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.proyecto1p;

/**
 *
 * @author PERSONAL
 */
public class DoubleLinkedList<E> {
    private Nodo<E> head;
    private Nodo<E> tail;

    public DoubleLinkedList() {
        this.head = head;
        this.tail = tail;
    }
    
    
    public void add(E data) {
        Nodo<E> newNode = new Nodo<>(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    public Nodo<E> getHead() {
        return head;
    }

    public Nodo<E> getTail() {
        return tail;
    }
    
    

    public void traverseForwards() {
        Nodo<E> current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public void traverseBackwards() {
        Nodo<E> current = tail;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.prev;
        }
        System.out.println();
    }

    public void traverseSimultaneously() {
        Nodo<E> forward = head;
        Nodo<E> backward = tail;

        while (forward != null || backward != null) {
            if (forward != null) {
                System.out.print(forward.data + " ");
                forward = forward.next;
            }

            if (backward != null) {
                System.out.print(backward.data + " ");
                backward = backward.prev;
            }
        }
        System.out.println();
    }
    
}
