package ru.kostikov.lab3;

import java.util.Objects;

// Задание 3. Человек: имя, фамилия, возраст.
// Естественный порядок (Comparable): по фамилии, затем по имени, затем по возрасту.
public class Human implements Comparable<Human> {
    private final String firstName;
    private final String lastName;
    private final int age;

    public Human(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(Human other) {
        int result = lastName.compareTo(other.lastName);
        if (result == 0) {
            result = firstName.compareTo(other.firstName);
        }
        if (result == 0) {
            result = age - other.age;
        }
        return result;
    }

    // два человека равны, если у них совпадают имя, фамилия и возраст
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Human)) {
            return false;
        }
        Human other = (Human) o;
        return age == other.age && firstName.equals(other.firstName) && lastName.equals(other.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, age);
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " (" + age + ")";
    }
}
