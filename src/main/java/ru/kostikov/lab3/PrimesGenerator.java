package ru.kostikov.lab3;

import java.util.ArrayList;
import java.util.Iterator;

// Задание 2. Генерирует N простых чисел, перебирать их можно через Iterator
public class PrimesGenerator implements Iterable<Integer> {
    private ArrayList<Integer> primes = new ArrayList<>();

    public PrimesGenerator(int n) {
        int number = 2;
        while (primes.size() < n) {
            if (isPrime(number)) {
                primes.add(number);
            }
            number++;
        }
    }

    // число простое, если делится только на 1 и на себя
    private boolean isPrime(int number) {
        for (int d = 2; d * d <= number; d++) {
            if (number % d == 0) {
                return false;
            }
        }
        return true;
    }

    // итератор в прямом порядке
    @Override
    public Iterator<Integer> iterator() {
        return new ForwardIterator();
    }

    // итератор в обратном порядке
    public Iterator<Integer> reverseIterator() {
        return new BackwardIterator();
    }

    private class ForwardIterator implements Iterator<Integer> {
        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < primes.size();
        }

        @Override
        public Integer next() {
            int value = primes.get(index);
            index++;
            return value;
        }
    }

    private class BackwardIterator implements Iterator<Integer> {
        private int index = primes.size() - 1;

        @Override
        public boolean hasNext() {
            return index >= 0;
        }

        @Override
        public Integer next() {
            int value = primes.get(index);
            index--;
            return value;
        }
    }
}
