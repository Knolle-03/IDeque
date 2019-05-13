package de.hawh.ld.deque;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class DequeTest {

    private List<Integer> intTestData = List.of(1,2,3,4,5,6);
    private List<String> strTestData = List.of("H","e","l","l","o","!");
    private Deque<Integer> intDeque = new Deque<>();
    private Deque<String> strDeque = new Deque<>();
    private Deque<String> emptyDeque = new Deque<>();



    @BeforeEach
    void setUp() {
        for (Integer i : intTestData) {
            intDeque.addLast(i);
        }
        for (String str : strTestData) {
            strDeque.addLast(str);
        }
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void size() {
        assertEquals(6, intDeque.size());
        assertEquals(6, strDeque.size());
        assertEquals(0, emptyDeque.size());
    }

    @Test
    void addFirst() {
        intDeque.addFirst(1234);
        strDeque.addFirst("test");
        assertEquals(1234, intDeque.getFirst());
        assertEquals("test", strDeque.getFirst());
    }

    @Test
    void addLast() {
        intDeque.addLast(1234);
        strDeque.addLast("test");
        assertEquals(1234, intDeque.getLast());
        assertEquals("test", strDeque.getLast());
    }

    @Test
    void removeFirst() {
        assertEquals(1, intDeque.removeFirst());
        assertEquals("H", strDeque.removeFirst());
        assertThrows(NoSuchElementException.class, () ->  emptyDeque.removeFirst());
    }

    @Test
    void removeLast() {
        assertEquals(6, intDeque.removeLast());
        assertEquals("!", strDeque.removeLast());
        assertThrows(NoSuchElementException.class, () ->  emptyDeque.removeLast());
    }

    @Test
    void getFirst() {
        assertEquals(1, intDeque.getFirst());
        assertEquals("H", strDeque.getFirst());
        assertThrows(NoSuchElementException.class, () ->  emptyDeque.getFirst());
    }

    @Test
    void getLast() {
        assertEquals(6, intDeque.getLast());
        assertEquals("!", strDeque.getLast());
        assertThrows(NoSuchElementException.class, () ->  emptyDeque.getLast());
    }

    @Test
    void isEmpty() {
        assertFalse(intDeque.isEmpty());
        assertTrue(emptyDeque.isEmpty());
    }
}