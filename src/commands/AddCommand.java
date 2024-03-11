package src.commands;

import src.collection.ElementCreate;
import src.structure.CollectionManager;
import src.structure.LogicTransfer;

public class AddCommand extends Command{
    ElementCreate elementCreate = new ElementCreate(logicTransfer, collectionManager);
    public AddCommand(LogicTransfer logicTransfer){
        super("add", logicTransfer);
    }

    @Override
    public void setLogicTransfer(LogicTransfer logicTransfer){
        this.logicTransfer = logicTransfer;
        this.elementCreate.setLogicTransfer(logicTransfer);
    }

    @Override
    public void setCollectionManager(CollectionManager collectionManager){
        this.collectionManager = collectionManager;
        this.elementCreate.setCollectionManager(collectionManager);
    }
    @Override
    public void execute(String arg) {
        collectionManager.addToCollection(elementCreate.createNewElement());
    }
}
