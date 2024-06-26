package src.commands;

import src.structure.logic.CollectionManager;
import src.structure.console.LogicTransfer;

public abstract class Command {
    protected String description;
    protected CollectionManager collectionManager;
    protected LogicTransfer logicTransfer;
    public Command(LogicTransfer logicTransfer){
        this.logicTransfer = logicTransfer;
    }

    public Command(String description, LogicTransfer logicTransfer){
        this.description = description;
        this.logicTransfer = logicTransfer;
    }



    public void setLogicTransfer(LogicTransfer logicTransfer){
        this.logicTransfer = logicTransfer;
    }
    public void setCollectionManager(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    public String getDescription() {
        return description;
    }

    public abstract void execute(String arg);

    @Override
    public String toString() {
        return description;
    }
}
