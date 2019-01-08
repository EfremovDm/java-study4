package ru.efremovdm.lesson3;

/**
 * Стек
 */
public class Stack {

    private char[] data;
    private int currentSize;

    public Stack(int maxSize) {
        this.currentSize = 0;
        this.data = new char[maxSize];
    }

    public char pop() {
        return this.data[--currentSize];

    }

    public void push(char value) {
        this.data[currentSize++] = value;

    }

    public char peek() {
        return this.data[currentSize - 1];
    }

    public int getSize() {
        return currentSize;
    }

    public boolean isEmpty() {
        return currentSize != 0;
    }

    public boolean isFull() {
        return currentSize >= data.length;
    }
}