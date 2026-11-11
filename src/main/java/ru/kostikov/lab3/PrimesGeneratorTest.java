package ru.kostikov.lab3;

import java.util.Iterator;

// Задание 2. Проверочный класс: выводит первые N простых чисел
// в прямом и обратном порядке.
public class PrimesGeneratorTest {
    private static final int N = 20;

    public static void main(String[] args) {
        System.out.println("===== Задание 2 =====");
        PrimesGenerator generator = new PrimesGenerator(N);

        System.out.print("Первые " + N + " простых чисел (прямой порядок):   ");
        Iterator<Integer> forward = generator.iterator();
        while (forward.hasNext()) {
            System.out.print(forward.next() + " ");
        }
        System.out.println();

        System.out.print("Первые " + N + " простых чисел (обратный порядок): ");
        Iterator<Integer> backward = generator.reverseIterator();
        while (backward.hasNext()) {
            System.out.print(backward.next() + " ");
        }
        System.out.println("\n");
    }
}
