package src.collection;

import src.data.Coordinates;
import src.data.Discipline;
import src.data.LabWork;
import src.structure.console.Validator;
import src.structure.logic.CollectionManager;
import src.structure.console.LogicTransfer;

import java.time.LocalDate;
import java.util.Collections;

public class ElementCreate {
    private LogicTransfer logicTransfer;
    private CollectionManager collectionManager;
    private final Validator validator;
    public ElementCreate(LogicTransfer logicTransfer, CollectionManager collectionManager){
        this.logicTransfer = logicTransfer;
        this.collectionManager = collectionManager;
        validator = new Validator();
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
        String arg = logicTransfer.requestInput("Введите имя");
        if (validator.checkName(arg)) {
            return arg;
        } else {
            logicTransfer.sendOutputln("Invalid input. Try again");
            return createNewName();
        }
    }

    public Coordinates createNewCoordinates(){
        String arg = logicTransfer.requestInput("Введите координаты по X и Y через пробел");
        if (validator.checkCoordinates(arg)){
            String[] args = arg.split(" ");
            return new Coordinates(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
        } else {
            logicTransfer.sendOutputln("Invalid input. Try again");
            return createNewCoordinates();
        }

    }

    public Long createNewMinimalPoint(){
        String arg = logicTransfer.requestInput("Введите минимально возможные баллы");
        if (!validator.checkMinPoint(arg)){
            logicTransfer.sendOutputln("Invalid input. Try again");
            return createNewMinimalPoint();
        } else {
            return arg == null ? null: Long.parseLong(arg);
        }
    }

    public Integer createNewDifficulty(){
        String arg = logicTransfer.requestInput("Выберите сложность работы\n" +
                "1) VERY_EASY\n" +
                "2) NORMAL\n" +
                "3) VERY_HARD\n" +
                "4) TERRIBLE");
        if (!validator.checkDifficulty(arg)){
            logicTransfer.sendOutputln("Invalid input. Try again");
            return createNewDifficulty();
        } else { return Integer.parseInt(arg);}
    }

    public Discipline createNewDiscipline() {
        String arg = logicTransfer.requestInput("Введите название дисциплины и количество лабораторных в ней");
        if (validator.checkDiscipline(arg)){
            String[] line = arg.split(" ");
            if (line.length == 1){
                return new Discipline(line[0], null);
            }
            return new Discipline(line[0], Integer.parseInt(line[1]));
        } else {
            logicTransfer.sendOutputln("Invalid input. Try again");
            return createNewDiscipline();
        }


    }

    public void setLogicTransfer(LogicTransfer logicTransfer) {
        this.logicTransfer = logicTransfer;
    }
    public void setCollectionManager(CollectionManager collectionManager){
        this.collectionManager = collectionManager;
    }
}
