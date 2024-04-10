package src.commands;

import src.structure.console.LogicTransfer;

public class ClearCommand extends Command{

    public ClearCommand(LogicTransfer logicTransfer){super("clear", logicTransfer);}
    @Override
    public void execute(String arg) {
        collectionManager.getCollection().getLabWorks().clear();
    }
}
