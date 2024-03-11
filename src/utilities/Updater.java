package src.utilities;

import src.collection.ElementCreate;
import src.data.Difficulty;
import src.structure.CollectionManager;
import src.structure.LogicTransfer;

public class Updater {
    LogicTransfer logicTransfer;
    CollectionManager collectionManager;
    ElementCreate elementCreate;
    public Updater(CollectionManager collectionManager, LogicTransfer logicTransfer){
        this.collectionManager = collectionManager;
        this.logicTransfer = logicTransfer;
        this.elementCreate = new ElementCreate(logicTransfer, collectionManager);
    }
    public void update(int ID){
        logicTransfer.sendOutputln("Выбран элемент "
                + collectionManager.getCollection().getLabWorks().get(ID).toString() + "\n"
                + "Выберите данные для изменения \n" +
                "1) Имя\n" +
                "2) Координаты\n" +
                "3) Минимальные баллы\n" +
                "4) Сложность\n" +
                "5) Дисциплина");
        int fieldnumber = Integer.parseInt(logicTransfer.requestInput());
        switch (fieldnumber){
            case(1):
                collectionManager.getCollection().getLabWorks().get(ID).setName(elementCreate.createNewName());
                break;
            case(2):
                collectionManager.getCollection().getLabWorks().get(ID).setCoordinates(elementCreate.createNewCoordinates());
                break;
            case(3):
                collectionManager.getCollection().getLabWorks().get(ID).setMinimalPoint(elementCreate.createNewMinimalPoint());
                break;
            case(4):
                collectionManager.getCollection().getLabWorks().get(ID).setDifficulty(Difficulty.values()[elementCreate.createNewDifficulty()-1]);
                break;
            case(5):
                collectionManager.getCollection().getLabWorks().get(ID).setDiscipline(elementCreate.createNewDiscipline());
                break;
        }
    }

    public void setLogicTransfer(LogicTransfer logicTransfer) {
        this.logicTransfer = logicTransfer;
    }

    public void setCollectionManager(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }
}
