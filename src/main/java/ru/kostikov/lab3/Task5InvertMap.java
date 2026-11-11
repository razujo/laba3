package ru.kostikov.lab3;

import java.util.LinkedHashMap;
import java.util.Map;

// Задание 5. Метод, меняющий местами ключи и значения в Map.
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

    // меняет местами ключи и значения. K и V - любые типы.
    // если значения повторяются, остаётся последний ключ (ключи в Map не повторяются)
    public static <K, V> Map<V, K> invert(Map<K, V> map) {
        Map<V, K> result = new LinkedHashMap<>();
        for (Map.Entry<K, V> entry : map.entrySet()) {
            result.put(entry.getValue(), entry.getKey());
        }
        return result;
    }
}
