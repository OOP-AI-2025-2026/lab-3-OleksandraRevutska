package org.example.task3;

import java.util.EmptyStackException;

public class IntStack {

    private int[] elements;
    private int size;

    private static final int DEFAULT_CAPACITY = 10;

    public IntStack() {
        this.elements = new int[DEFAULT_CAPACITY];
        this.size = 0;
    }

    public void push(int value) {
        ensureCapacity();
        this.elements[this.size] = value;
        this.size++;
    }

    public int pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        int value = this.elements[this.size - 1];
        this.size--;
        return value;
    }

    public int peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return this.elements[this.size - 1];
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void clear() {
        this.size = 0;
    }

    private void ensureCapacity() {
        if (this.size == this.elements.length) {
            int newCapacity = this.elements.length * 2;
            int[] newArray = new int[newCapacity];
            System.arraycopy(this.elements, 0, newArray, 0, this.size);
            this.elements = newArray;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Stack: [");
        for (int i = 0; i < this.size; i++) {
            sb.append(this.elements[i]);
            if (i < this.size - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}

