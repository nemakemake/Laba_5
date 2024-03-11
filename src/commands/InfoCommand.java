package src.commands;

import src.collection.Collection;
import src.structure.CollectionManager;
import src.structure.LogicTransfer;
import src.utilities.ConsoleOutput;

public class InfoCommand extends Command{
    public InfoCommand(LogicTransfer logicTransfer){
        super("info", logicTransfer);
    }
    @Override
    public void execute(String arg){
        logicTransfer.sendOutput(
                "type             | " + collectionManager.getCollection().getLabWorks().getClass().getSimpleName()+ "\n"+
                "name             | " + collectionManager.getCollection().getName() + "\n"+
                "date of creation | "+ collectionManager.getCollection().getCreationDate().toString() + "\n"+
                "collection size  | "+ collectionManager.getCollection().getLabWorks().keySet().size() + " elements\n"
        );
    }
}

