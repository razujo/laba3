package ru.kostikov.lab3;

import java.util.HashMap;
import java.util.Map;

// Задание 4. Частота встречаемости слов в английском тексте (с помощью HashMap).
// Слова, отличающиеся только регистром, считаются одинаковыми.
public class Task4WordFrequency {
    public static void main(String[] args) {
        System.out.println("===== Задание 4 =====");
        String text = "The quick brown fox jumps over the lazy dog. "
                + "The dog was not amused, but the fox was quick! "
                + "A Fox and a DOG can be friends.";
        System.out.println("Текст: " + text);

        Map<String, Integer> frequency = countWords(text);

        System.out.println("Различных слов: " + frequency.size());
        for (Map.Entry<String, Integer> entry : frequency.entrySet()) {
            System.out.println("   " + entry.getKey() + " -> " + entry.getValue());
        }
        System.out.println();
    }

    public static Map<String, Integer> countWords(String text) {
        Map<String, Integer> frequency = new HashMap<>();
        // делаем все буквы маленькими и делим текст на слова по пробелам и знакам препинания
        String[] words = text.toLowerCase().split("[ .,!?]+");
        for (String word : words) {
            if (word.isEmpty()) {
                continue;
            }
            if (frequency.containsKey(word)) {
                frequency.put(word, frequency.get(word) + 1);
            } else {
                frequency.put(word, 1);
            }
        }
        return frequency;
    }
}
