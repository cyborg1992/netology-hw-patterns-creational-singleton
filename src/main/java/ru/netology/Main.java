package ru.netology;

import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Logger logger = Logger.getInstance();

        logger.log("Запускаем программу");
        logger.log("Просим пользователя ввести входные данные для списка");
        int listSize;
        while (true) {
            System.out.print("Введите размер списка -> ");
            try {
                listSize = Integer.parseInt(scanner.nextLine());
                if (listSize > 0) {
                    break;
                }
                logger.log("Введено некоректное значение. Размер списка должен быть > 0");
            } catch (Exception e) {
                logger.log("Введено некоректное значение. Введёное значение должно быть целочисленным значением");
            }
        }
        int maxValue;
        while (true) {
            System.out.print("Введите верхнюю границу для значений -> ");
            try {
                maxValue = Integer.parseInt(scanner.nextLine());
                if (maxValue > 0) {
                    break;
                }
                logger.log("Введено некоректное значение. Верхняя граница для значений должна быть > 0");
            } catch (NumberFormatException e) {
                logger.log("Введено некоректное значение. Введёное значение должно быть целочисленным значением");
            }
        }

        logger.log("Создаём и наполняем список");
        List<Integer> intList = generateRandomInts(listSize, maxValue);

        System.out.print("Вот случайный список: ");
        intList.forEach(x -> System.out.print(x + " "));
        System.out.println();

        logger.log("Просим пользователя ввести входные данные для фильтрации");
        System.out.print("Введите порог для фильтра -> ");
        int threshold = scanner.nextInt();

        logger.log("Запускаем фильтрацию");
        Filter filter = new Filter(threshold);
        intList = filter.filterOut(intList);

        logger.log("Выводим результат на экран");
        System.out.print("Отфильтрованный список: ");
        intList.forEach(x -> System.out.print(x + " "));
        System.out.println();

        logger.log("Завершаем программу");
    }

    private static List<Integer> generateRandomInts(int listSize, int maxValue) {
        Random random = new Random();
        return random.ints(listSize, 0, maxValue)
                .boxed()
                .collect(Collectors.toList());
    }
}
