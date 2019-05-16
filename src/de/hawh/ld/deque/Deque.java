package de.hawh.ld.deque;
import de.hawh.kahlbrandt.ss2019bai2pm2.a06.interfaces.IDeque;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;


public class Deque<E> implements IDeque<E>, Iterable<E> {

    private Node start;

    private int dequeSize = 0;

    public Deque(){}

    public int size(){
        return dequeSize;
    }

    private class Node{

        E data;
        Node prev;
        Node next;
        Node(E e){
            data = e;
        }


        @SuppressWarnings("unchecked")
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return data == node.data;
        }

        @Override
        public int hashCode() {
            return Objects.hash(data);
        }
    }

    @Override
    public void addFirst(E e) throws IllegalArgumentException {
        if(e == null){
            throw new IllegalArgumentException();
        }
        Node newHead = new Node(e);

        if(isEmpty()){
            start = newHead;
            start.next = start;
            start.prev = start;
        } else {
            newHead.next = start;
            newHead.prev = start.prev;
            start = newHead;
        }
        dequeSize++;
    }

    @Override
    public void addLast(E e) throws IllegalArgumentException {
        if(e == null){
            throw new IllegalArgumentException();
        }
        Node newTail = new Node(e);

        if(isEmpty()) {
            start = newTail;
            start.next = start;
            start.prev = start;
        } else {
            newTail.next = start;
            newTail.prev = start.prev;
            start.prev.next = newTail;
            start.prev = newTail;
        }
        dequeSize++;
    }

    @Override
    public E removeFirst() throws NoSuchElementException {
        if(isEmpty()){
            throw new NoSuchElementException();
        }

        Node oldStart = start;
        start = start.next;

        dequeSize--;

        return oldStart.data;
    }

    @Override
    public E removeLast() throws NoSuchElementException {
        if(isEmpty()){
            throw new NoSuchElementException();
        }

        Node oldTail = start.prev;
        start.prev = start.prev.prev;
        start.prev.next = start;


        dequeSize--;

        return oldTail.data;
    }

    @Override
    public E getFirst() throws NoSuchElementException {
        if(this.isEmpty()){
            throw new NoSuchElementException();
        }
        return start.data;
    }

    @Override
    public E getLast() throws NoSuchElementException {
        if(this.isEmpty()){
            throw new NoSuchElementException();
        }
        return start.prev.data;
    }

    @Override
    public boolean isEmpty() {
        return start == null;
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Deque<E> that = (Deque<E>) o;
        Iterator<E> thisIt = this.iterator();
        Iterator<E> thatIt = that.iterator();
        if (dequeSize != that.dequeSize) return false;
        boolean truthVal = true;

        for (int i = 0; i < dequeSize; i++) {
            if (!thisIt.next().equals(thatIt.next())){
                truthVal = false;
            }

        }
        return truthVal;
    }



        @Override
    public int hashCode() {
        Iterator<E> it = iterator();
        int hash = 31;
            for (int i = 0; i < dequeSize; i++) {
                hash *= it.next().hashCode();
            }
        return hash;
    }



    @Override
    public String toString() {
        Iterator<E> it = iterator();
        StringBuilder dataString = new StringBuilder();
        for (int i = 0; i < dequeSize; i++) {
            if(i == dequeSize - 1){
                dataString.append(it.next());
            } else {
                dataString.append(it.next()).append(", ");
            }
        }
        return "DequeData: " + dataString.toString();
    }


    @Override
    public Iterator<E> iterator() {
        return new DataIterator();
    }

    private class DataIterator implements Iterator<E> {

        Node current;

        public DataIterator() {
            current = start;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            if (current == null)
                throw new NoSuchElementException();

            E data = current.data;
            current = current.next;
            return data;
        }
    }
}