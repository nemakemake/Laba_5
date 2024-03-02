package src.commands;

import src.structure.CollectionManager;
import src.utilities.ConsoleInput;
import src.utilities.ConsoleOutput;

public abstract class Command {
    protected String description;
    protected CollectionManager collectionManager;
    protected ConsoleInput input;
    protected ConsoleOutput output;
    public Command(String description){
        this.description = description;
    }

    public Command(String description, ConsoleOutput output){
        this.description = description;
        this.output = output;
    }

    public Command(String description, ConsoleOutput output, ConsoleInput input){
        this.description = description;
        this.output = output;
        this.input = input;
    }

    public void setCollectionManager(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    public String getDescription() {
        return description;
    }

    public abstract void execute(String arg);
}
