package src.commands;

import src.structure.CollectionManager;
import src.structure.Console;
import src.structure.LogicTransfer;
import src.utilities.ConsoleInput;
import src.utilities.ConsoleOutput;

public abstract class Command {
    protected String description;
    protected CollectionManager collectionManager;
    protected LogicTransfer logicTransfer;
    public Command(String description){
        this.description = description;
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
}
