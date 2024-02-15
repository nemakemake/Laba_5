package collection;

import data.Coordinates;
import data.Difficulty;
import data.Discipline;
import data.LabWork;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Scanner;

public class ElementCreate {
    static CollectionManager collectionManager = new CollectionManager();
    static Scanner scanner = new Scanner(System.in);
    public static LabWork createNewElement(){
        return new LabWork(generateID(),
                createNewName(),
                createNewCoordinates(),
                LocalDate.now(),
                createNewMinimalPoint(),
                createNewDifficulty(),
                createNewDiscipline());
    }

    private static Integer generateID(){
        return 1; //FIXXX!!!
    }

    public static String createNewName(){
        System.out.print("Введите имя\n-> ");
        String name = scanner.nextLine();
        return name;
    }

    public static Coordinates createNewCoordinates(){
        System.out.print("Введите координаты по X и Y через пробел\n->");
        String[] args = scanner.nextLine().split(" ");
        return new Coordinates(Long.parseLong(args[0]), Double.parseDouble(args[1]));
    }

    public static Long createNewMinimalPoint(){
        System.out.print("Введите минимально возможные баллы\n->");
        Long minimalPoint = Long.parseLong(scanner.nextLine());
        return minimalPoint;
    }

    public static Integer createNewDifficulty(){
        System.out.print("Выберите сложность работы\n" +
                "1) VERY_EASY\n" +
                "2) NORMAL\n" +
                "3) VERY_HARD\n" +
                "4) TERRIBLE\n->");
        Integer difficulty = Integer.parseInt(scanner.nextLine());
        return difficulty;
    }

    public static Discipline createNewDiscipline() {
        System.out.print("Введите название дисциплины и количество лабораторных в ней\n->");
        String[] line = scanner.nextLine().split(" ");
        return new Discipline(line[0], Integer.parseInt(line[1]));
    }
}
