/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.proyecto1p;

import java.util.List;
import java.util.NoSuchElementException;

/**
 *
 * @author User Dell
 */
public class CircularDoublyLinkedList<E> implements DoubleCircularList<E> {
    
    private Node<E> head;
    private int size;
    
    private static class Node<E> {
        E data;
        Node<E> next;
        Node<E> prev;
        
        public Node(E data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
    
    
    public CircularDoublyLinkedList() {
        head = null;
        size = 0;
    }
    
    
    @Override
    public void moveToPrev() {
        if (head != null) {
            head = head.prev;
        }
    }
    
    @Override
    public void moveToNext() {
        if (head != null) {
            head = head.next;
        }
    }
    
    @Override
    public void addFirst(E element) {
        Node<E> newNode = new Node<>(element);
        if (isEmpty()) {
            head = newNode;
            head.prev = head;
            head.next = head;
        } else {
            newNode.next = head;
            newNode.prev = head.prev;
            head.prev.next = newNode;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }
       
    
    @Override
    public boolean deleteCurrent() {
        if (head == null) {
            return false;
        }
        
        if (size == 1) {
            head = null;
        } else {
            head.prev.next = head.next;
            head.next.prev = head.prev;
            head = head.prev; // Move head to the next node
        }
        size--;
        return true;
    }
    
    
    public E getCurrent() {
        if (head == null) {
            return null;
        }
        return head.data;
    }
    
    
    @Override
    public int size() {
        return size;
    }
    
    
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

}
