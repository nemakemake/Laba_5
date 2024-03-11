package src.collection;

import src.data.Coordinates;
import src.data.Discipline;
import src.data.LabWork;
import src.structure.CollectionManager;
import src.structure.LogicTransfer;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Scanner;

public class ElementCreate {
    private LogicTransfer logicTransfer;
    private CollectionManager collectionManager;
    public ElementCreate(LogicTransfer logicTransfer, CollectionManager collectionManager){
        this.logicTransfer = logicTransfer;
        this.collectionManager = collectionManager;
    }
    public LabWork createNewElement(){
        return new LabWork(generateID(),
                createNewName(),
                createNewCoordinates(),
                LocalDate.now(),
                createNewMinimalPoint(),
                createNewDifficulty(),
                createNewDiscipline());
    }

    private Integer generateID(){
        return Collections.max(collectionManager.getIdregistry()) + 1;
    }

    public String createNewName(){
        System.out.print("Введите имя\n-> ");
        return logicTransfer.requestInput();
    }

    public Coordinates createNewCoordinates(){
        System.out.print("Введите координаты по X и Y через пробел\n->");
        String[] args = logicTransfer.requestInput().split(" ");
        return new Coordinates(Long.parseLong(args[0]), Double.parseDouble(args[1]));
    }

    public Long createNewMinimalPoint(){
        System.out.print("Введите минимально возможные баллы\n->");
        return Long.parseLong(logicTransfer.requestInput());
    }

    public Integer createNewDifficulty(){
        System.out.print("Выберите сложность работы\n" +
                "1) VERY_EASY\n" +
                "2) NORMAL\n" +
                "3) VERY_HARD\n" +
                "4) TERRIBLE\n->");
        return Integer.parseInt(logicTransfer.requestInput());
    }

    public Discipline createNewDiscipline() {
        System.out.print("Введите название дисциплины и количество лабораторных в ней\n->");
        String[] line = logicTransfer.requestInput().split(" ");
        return new Discipline(line[0], Integer.parseInt(line[1]));
    }

    public void setLogicTransfer(LogicTransfer logicTransfer) {
        this.logicTransfer = logicTransfer;
    }
    public void setCollectionManager(CollectionManager collectionManager){
        this.collectionManager = collectionManager;
    }
}
