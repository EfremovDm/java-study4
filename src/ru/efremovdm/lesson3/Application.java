package ru.efremovdm.lesson3;

/**
 * 1. Реализовать рассмотренные структуры данных в консольных программах.
 * 2. Создать программу, которая переворачивает вводимые строки (читает справа налево).
 * 3. Создать класс для реализации дека.
 */
public class Application {

    private static final int ARR_SIZE = 10;

    public static void main(String[] args) {

        Queue queue = new Queue(ARR_SIZE);
        Deque deque = new Deque(ARR_SIZE);
        StringInverse inverse = new StringInverse();

        inverse.printStackToString(inverse.initializeStack());

        initializeQueue(queue);
        initializeDequeue(deque);

        while (!deque.isEmpty()) {
            System.out.println(deque.removeRight());
            System.out.println(deque.removeLeft());
        }
    }

    static void initializeDequeue(Deque deque) {
        for (int i = 0; i < ARR_SIZE/2; i++) {
            deque.insertLeft(i);
            deque.insertRight(i);
        }
    }

    static void initializeQueue(Queue queue) {
        for (int i = 0; i < ARR_SIZE; i++) {
            queue.insert(i);
        }
    }
}