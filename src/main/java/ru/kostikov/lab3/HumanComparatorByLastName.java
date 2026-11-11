package ru.kostikov.lab3;

import java.util.Comparator;

// Задание 3. Компаратор, сравнивающий людей только по фамилии.
public class HumanComparatorByLastName implements Comparator<Human> {
    @Override
    public int compare(Human h1, Human h2) {
        return h1.getLastName().compareTo(h2.getLastName());
    }
}
