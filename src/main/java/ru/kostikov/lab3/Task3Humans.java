package ru.kostikov.lab3;

import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Задание 3. Сравнение разных реализаций Set на одном списке людей.
 *
 * f) Почему выводы разных сетов отличаются:
 *
 * HashSet — хранит элементы по хеш-коду, поэтому порядок вывода не совпадает
 *   с порядком добавления и выглядит «случайным». Повторы определяются
 *   методами equals()/hashCode(): второй объект «Иван Петров (20)» не добавлен,
 *   так как он равен первому.
 *
 * LinkedHashSet — тоже использует equals()/hashCode() (дубликат отброшен),
 *   но дополнительно помнит порядок добавления, поэтому выводит людей
 *   в том же порядке, что и в исходном списке.
 *
 * TreeSet (без компаратора) — сортирует элементы по естественному порядку,
 *   то есть по методу compareTo() интерфейса Comparable: по фамилии,
 *   затем по имени, затем по возрасту. Дубликат определяется тем,
 *   что compareTo() вернул 0.
 *
 * TreeSet с HumanComparatorByLastName — сравнивает только фамилии. Люди
 *   с одинаковой фамилией считаются «равными» (compare() == 0), поэтому
 *   в сет попадает только первый человек с каждой фамилией, остальные теряются.
 *
 * TreeSet с анонимным компаратором по возрасту — аналогично: в сете остаётся
 *   только по одному человеку каждого возраста, элементы упорядочены по возрасту.
 *
 * Вывод: HashSet и LinkedHashSet определяют одинаковость через equals()/hashCode(),
 * а TreeSet — через compareTo()/compare(). Если компаратор сравнивает не все поля,
 * TreeSet «склеивает» разных людей и часть данных пропадает.
 */
public class Task3Humans {
    public static void main(String[] args) {
        System.out.println("===== Задание 3 =====");
        List<Human> humans = List.of(
                new Human("Иван", "Петров", 20),
                new Human("Анна", "Смирнова", 19),
                new Human("Пётр", "Иванов", 25),
                new Human("Мария", "Петрова", 20),
                new Human("Сергей", "Петров", 31),
                new Human("Ольга", "Козлова", 19),
                new Human("Иван", "Петров", 20),   // полный дубликат первого
                new Human("Дмитрий", "Иванов", 22)
        );
        System.out.println("Исходный список:");
        print(humans);

        // a) HashSet
        Set<Human> hashSet = new HashSet<>(humans);
        System.out.println("\na) HashSet:");
        print(hashSet);

        // b) LinkedHashSet
        Set<Human> linkedHashSet = new LinkedHashSet<>(humans);
        System.out.println("\nb) LinkedHashSet:");
        print(linkedHashSet);

        // c) TreeSet с естественным порядком (Comparable)
        Set<Human> treeSet = new TreeSet<>(humans);
        System.out.println("\nc) TreeSet (Comparable):");
        print(treeSet);

        // d) TreeSet с компаратором по фамилии
        Set<Human> byLastName = new TreeSet<>(new HumanComparatorByLastName());
        byLastName.addAll(humans);
        System.out.println("\nd) TreeSet (HumanComparatorByLastName):");
        print(byLastName);

        // e) TreeSet с анонимным компаратором по возрасту
        Set<Human> byAge = new TreeSet<>(new Comparator<Human>() {
            @Override
            public int compare(Human h1, Human h2) {
                return Integer.compare(h1.getAge(), h2.getAge());
            }
        });
        byAge.addAll(humans);
        System.out.println("\ne) TreeSet (анонимный компаратор по возрасту):");
        print(byAge);
        System.out.println();
    }

    private static void print(Iterable<Human> humans) {
        for (Human human : humans) {
            System.out.println("   " + human);
        }
    }
}
