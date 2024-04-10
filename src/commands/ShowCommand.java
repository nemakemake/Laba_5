package src.commands;

import src.structure.console.LogicTransfer;

public class ShowCommand extends Command{
    public ShowCommand(LogicTransfer logicTransfer){
        super("show", logicTransfer);
    }

    @Override
    public void execute(String arg) {
        for (int key: collectionManager.getCollection().getLabWorks().keySet()){
            logicTransfer.sendOutputln(collectionManager.getElement(key).toString());
        }
    }
}
