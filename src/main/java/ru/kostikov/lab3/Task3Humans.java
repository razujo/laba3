package ru.kostikov.lab3;

import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

// Задание 3
// f) Почему разные сеты выводят по-разному:
// HashSet - хранит по хеш-коду, поэтому порядок как попало. Одинаковых людей
// ищет через equals() и hashCode(), поэтому второй "Иван Петров (20)" не добавился.
// LinkedHashSet - то же самое, но запоминает порядок добавления.
// TreeSet - сортирует через compareTo() (фамилия, потом имя, потом возраст).
// TreeSet с компаратором по фамилии считает людей с одной фамилией одинаковыми,
// поэтому остаётся только один Петров и один Иванов.
// TreeSet с компаратором по возрасту - остаётся по одному человеку каждого возраста.
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
        // анонимный класс-компаратор прямо внутри вызова
        Set<Human> byAge = new TreeSet<>(new Comparator<Human>() {
            @Override
            public int compare(Human h1, Human h2) {
                return h1.getAge() - h2.getAge();
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
