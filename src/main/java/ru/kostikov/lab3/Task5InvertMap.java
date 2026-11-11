package ru.kostikov.lab3;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Задание 5. Метод, меняющий местами ключи и значения в Map.
 */
public class Task5InvertMap {
    public static void main(String[] args) {
        System.out.println("===== Задание 5 =====");
        Map<String, Integer> phoneCodes = new LinkedHashMap<>();
        phoneCodes.put("Россия", 7);
        phoneCodes.put("США", 1);
        phoneCodes.put("Германия", 49);
        phoneCodes.put("Франция", 33);

        System.out.println("Исходная Map:    " + phoneCodes);
        System.out.println("Обращённая Map:  " + invert(phoneCodes));

        Map<String, String> withRepeats = new LinkedHashMap<>();
        withRepeats.put("яблоко", "фрукт");
        withRepeats.put("морковь", "овощ");
        withRepeats.put("груша", "фрукт");
        System.out.println("\nЗначения повторяются: " + withRepeats);
        System.out.println("Обращённая Map:       " + invert(withRepeats));
        System.out.println("(при одинаковых значениях остаётся последний ключ)");
    }

    /**
     * Возвращает новую Map, в которой ключи и значения исходной поменяны местами.
     * Значения в Map могут повторяться, а ключи — нет, поэтому при совпадении
     * значений в результате остаётся последний встреченный ключ.
     */
    public static <K, V> Map<V, K> invert(Map<K, V> map) {
        Map<V, K> result = new LinkedHashMap<>();
        for (Map.Entry<K, V> entry : map.entrySet()) {
            result.put(entry.getValue(), entry.getKey());
        }
        return result;
    }
}
