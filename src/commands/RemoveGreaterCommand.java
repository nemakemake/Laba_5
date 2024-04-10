package src.commands;

import src.collection.ElementCreate;
import src.data.LabWork;
import src.structure.logic.CollectionManager;
import src.structure.console.LogicTransfer;

import java.util.ArrayList;

public class RemoveGreaterCommand extends Command {
    ArrayList<Integer> indexes = new ArrayList<Integer>();
    LabWork lab;
    ElementCreate elementCreate = new ElementCreate(logicTransfer, collectionManager);
    public RemoveGreaterCommand(LogicTransfer logicTransfer){
        super("remove_greater", logicTransfer);
        this.logicTransfer = logicTransfer;
        this.elementCreate.setLogicTransfer(logicTransfer);
    }

    @Override
    public void setCollectionManager(CollectionManager collectionManager){
        this.collectionManager = collectionManager;
        this.elementCreate.setCollectionManager(collectionManager);
    }
    @Override
    public void execute(String arg){
        try {
            int newArg = Integer.parseInt(arg);
            findIndexes(newArg);
        } catch (NumberFormatException e){
            findIndexes(-1);
        }
        removeGreater(indexes);
    }

    private void removeGreater(ArrayList<Integer> indexes){
        for (Integer x: indexes){
            collectionManager.getCollection().getLabWorks().remove(x);
        }
    }
    private void findIndexes(int arg){
        if (arg == -1){
            lab = elementCreate.createNewElement();
        } else {
            lab = collectionManager.getCollection().getLabWorks().get(arg);
        }
        for (int x: collectionManager.getCollection().getLabWorks().keySet()) {
            if (lab.compareTo(collectionManager.getCollection().getLabWorks().get(x)) < 0) {
                indexes.add(x);
            }
        }
    }

}
