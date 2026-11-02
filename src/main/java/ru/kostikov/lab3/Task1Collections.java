package ru.kostikov.lab3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;

/**
 * Задание 1. Работа со статическими методами класса Collections.
 */
public class Task1Collections {
    private static final int N = 30;

    public static void main(String[] args) {
        System.out.println("===== Задание 1 =====");

        // a) Массив из N случайных чисел от 0 до 100
        Random random = new Random();
        Integer[] array = new Integer[N];
        for (int i = 0; i < N; i++) {
            array[i] = random.nextInt(101);
        }
        System.out.println("a) Массив:                 " + Arrays.toString(array));

        // b) Список на основе массива
        List<Integer> list = new ArrayList<>(Arrays.asList(array));
        System.out.println("b) Список:                 " + list);

        // c) Сортировка по возрастанию
        Collections.sort(list);
        System.out.println("c) По возрастанию:         " + list);

        // d) Сортировка в обратном порядке
        list.sort(Collections.reverseOrder());
        System.out.println("d) В обратном порядке:     " + list);

        // e) Перемешивание
        Collections.shuffle(list);
        System.out.println("e) Перемешанный:           " + list);

        // f) Циклический сдвиг на 1 элемент (последний становится первым)
        Collections.rotate(list, 1);
        System.out.println("f) Сдвиг на 1:             " + list);

        // g) Только уникальные элементы: каждое значение остаётся один раз
        List<Integer> unique = new ArrayList<>(new LinkedHashSet<>(list));
        System.out.println("g) Уникальные:             " + unique);

        // h) Только дублирующиеся элементы: значения, встречающиеся больше одного раза
        List<Integer> duplicates = new ArrayList<>();
        for (Integer value : unique) {
            if (Collections.frequency(list, value) > 1) {
                duplicates.add(value);
            }
        }
        System.out.println("h) Дублирующиеся:          " + duplicates);

        // i) Из списка получаем массив
        Integer[] fromList = list.toArray(new Integer[0]);
        System.out.println("i) Массив из списка:       " + Arrays.toString(fromList));

        // j) Количество вхождений каждого числа в массив
        System.out.println("j) Количество вхождений:");
        List<Integer> sortedUnique = new ArrayList<>(unique);
        Collections.sort(sortedUnique);
        List<Integer> arrayAsList = Arrays.asList(array);
        StringBuilder line = new StringBuilder("  ");
        int inLine = 0;
        for (Integer value : sortedUnique) {
            line.append(String.format(" %3d -> %d;", value, Collections.frequency(arrayAsList, value)));
            if (++inLine == 10) {
                System.out.println(line);
                line = new StringBuilder("  ");
                inLine = 0;
            }
        }
        if (inLine > 0) {
            System.out.println(line);
        }
        System.out.println();
    }
}
