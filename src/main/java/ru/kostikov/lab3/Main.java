package ru.kostikov.lab3;

/**
 * Запуск всех заданий лабораторной работы №3 «Коллекции».
 * Можно передать номер задания аргументом: mvn exec:java -Dexec.args="2"
 */
public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            Task1Collections.main(args);
            PrimesGeneratorTest.main(args);
            Task3Humans.main(args);
            Task4WordFrequency.main(args);
            Task5InvertMap.main(args);
            return;
        }
        switch (args[0]) {
            case "1" -> Task1Collections.main(args);
            case "2" -> PrimesGeneratorTest.main(args);
            case "3" -> Task3Humans.main(args);
            case "4" -> Task4WordFrequency.main(args);
            case "5" -> Task5InvertMap.main(args);
            default -> System.out.println("Нет задания с номером " + args[0]);
        }
    }
}
