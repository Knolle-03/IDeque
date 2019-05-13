package de.hawh.ld.deque;
import de.hawh.kahlbrandt.ss2019bai2pm2.a06.interfaces.IDeque;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;


public class Deque<E> implements IDeque<E>, Iterable<E> {

    private Node head;
    private Node tail;
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
    }

    @Override
    public void addFirst(E e) throws IllegalArgumentException {
        if(e == null){
            throw new IllegalArgumentException();
        }
        Node newHead = new Node(e);

        if(head == null){
            head = newHead;
            head.next = head;
            head.prev = head;
        } else {
            newHead.next = head;
            head = newHead;
            head.prev = tail;
        }
        dequeSize++;
    }

    @Override
    public void addLast(E e) throws IllegalArgumentException {
        if(e == null){
            throw new IllegalArgumentException();
        }
        Node newTail = new Node(e);

        if(tail != null){
            newTail.prev = tail;
            tail.next = newTail;
        }

        tail = newTail;
        newTail.next = head;


        if(head == null){
            head = tail;
        }
        dequeSize++;
    }

    @Override
    public E removeFirst() throws NoSuchElementException {
        if(head == null){
            throw new NoSuchElementException();
        }

        Node oldHead = head;
        head = head.next;

        dequeSize--;

        return oldHead.data;
    }

    @Override
    public E removeLast() throws NoSuchElementException {
        if(tail == null){
            throw new NoSuchElementException();
        }

        Node oldTail = tail;
        tail = tail.prev;
        tail.next = head;


        dequeSize--;

        return oldTail.data;
    }

    @Override
    public E getFirst() throws NoSuchElementException {
        if(this.isEmpty()){
            throw new NoSuchElementException();
        }
        return head.data;
    }

    @Override
    public E getLast() throws NoSuchElementException {
        if(this.isEmpty()){
            throw new NoSuchElementException();
        }
        return tail.data;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public String toString() {
        Iterator<E> it = iterator();
        StringBuilder dataString = new StringBuilder();
        for (int i = 0; i < dequeSize; i++) {
            dataString.append(it.next()).append(", ");
            System.out.println(dataString.toString());
        }
        return "DequeData: " + dataString.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Deque<?> deque = (Deque<?>) o;
        return dequeSize == deque.dequeSize &&
                Objects.equals(head, deque.head) &&
                Objects.equals(tail, deque.tail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(head, tail, dequeSize);
    }

    @Override
    public Iterator<E> iterator() {
        return new DataIterator();
    }

    private class DataIterator implements Iterator<E> {

        Node current;

        public DataIterator() {
            current = head;
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