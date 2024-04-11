package src.commands;

import src.collection.ElementCreate;
import src.data.LabWork;
import src.structure.logic.CollectionManager;
import src.structure.console.LogicTransfer;

import java.util.Hashtable;

public class AddIfMaxCommand extends Command{

    ElementCreate elementCreate = new ElementCreate(logicTransfer, collectionManager);
    public AddIfMaxCommand(LogicTransfer logicTransfer){
        super("add_if_max", logicTransfer);
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
        LabWork lab = elementCreate.createNewElement();
        int flag = 0;
        Hashtable<Integer, LabWork> labworks = collectionManager.getLabWorks();
        for (int x :labworks.keySet()){
            flag += lab.compareTo(labworks.get(x)) <= 0 ? 1 : 0;
        }
        if (flag == 0) {
            collectionManager.addToCollection(lab);
            logicTransfer.sendOutputln("Added successfully");
        } else {logicTransfer.sendOutputln("Not max!");}
    }
}
