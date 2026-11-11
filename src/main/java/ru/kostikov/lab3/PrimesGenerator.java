package ru.kostikov.lab3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Задание 2. Генератор заданного количества (N) простых чисел.
 * Перебор чисел выполняется через интерфейс Iterator.
 */
public class PrimesGenerator implements Iterable<Integer> {
    private final List<Integer> primes = new ArrayList<>();

    public PrimesGenerator(int count) {
        if (count < 0) {
            throw new IllegalArgumentException("Количество не может быть отрицательным");
        }
        int candidate = 2;
        while (primes.size() < count) {
            if (isPrime(candidate)) {
                primes.add(candidate);
            }
            candidate++;
        }
    }

    private static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }
        for (int d = 2; (long) d * d <= number; d++) {
            if (number % d == 0) {
                return false;
            }
        }
        return true;
    }

    /** Итератор в прямом порядке: от меньшего простого числа к большему. */
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < primes.size();
            }

            @Override
            public Integer next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return primes.get(index++);
            }
        };
    }

    /** Итератор в обратном порядке: от большего простого числа к меньшему. */
    public Iterator<Integer> reverseIterator() {
        return new Iterator<>() {
            private int index = primes.size() - 1;

            @Override
            public boolean hasNext() {
                return index >= 0;
            }

            @Override
            public Integer next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return primes.get(index--);
            }
        };
    }
}
