package de.hawh.kahlbrandt.ss2019bai2pm2.a06.interfaces;

import java.util.NoSuchElementException;

/**
 * An interface for a simple Deque with fewer Methods than
 * {@link java.util.Deque}.
 *
 * @param <E>
 * @author Bernd Kahlbrandt
 */
public interface IDeque<E> {
    /**
     * Inserts the specified element at the front of this deque.
     *
     * @param e the element to add
     */
    void addFirst(E e);

    /**
     * Inserts the specified element at the end of this deque.
     */
    void addLast(E e);

    /**
     * Retrieves and removes the first element of this deque.     *
     *
     * @return the head of this deque
     * @throws NoSuchElementException if this deque is empty
     */
    E removeFirst() throws NoSuchElementException;

    /**
     * Retrieves and removes the last element of this deque.
     *
     * @return the tail of this deque
     * @throws NoSuchElementException if this deque is empty
     */
    E removeLast() throws NoSuchElementException;

    /**
     * Retrieves, but does not remove, the first element of this deque.
     *
     * @return the head of this deque
     * @throws NoSuchElementException if this deque is empty
     */
    E getFirst() throws NoSuchElementException;

    /**
     * Retrieves, but does not remove, the last element of this deque.
     *
     * @return the tail of this deque
     * @throws NoSuchElementException if this deque is empty
     */
    E getLast() throws NoSuchElementException;

    /**
     * Checks if this deque is empty.
     *
     * @return true, if this deque is empty, false otherwise.
     */
    boolean isEmpty();
}
