package src.commands;

import src.collection.ElementCreate;
import src.data.LabWork;
import src.structure.CollectionManager;
import src.structure.LogicTransfer;

import java.text.NumberFormat;
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
            executeWithLab(newArg);
        } catch (NumberFormatException e){
            executeWithNew();
        }
        removeGreater(indexes);
    }

    private void removeGreater(ArrayList<Integer> indexes){
        for (Integer x: indexes){
            collectionManager.getCollection().getLabWorks().remove(x);
        }
    }
    private void executeWithLab(int arg){
        lab = collectionManager.getCollection().getLabWorks().get(arg);
        for (int x: collectionManager.getCollection().getLabWorks().keySet()) {
            if (lab.compareTo(collectionManager.getCollection().getLabWorks().get(x)) < 0) {
                indexes.add(x);
            }
        }
    }

    private void executeWithNew(){
        lab = elementCreate.createNewElement();
        for (int x: collectionManager.getCollection().getLabWorks().keySet()){
            if (lab.compareTo(collectionManager.getCollection().getLabWorks().get(x)) < 0){
                indexes.add(x);
            }
        }
    }
}
