package src.commands;

import src.structure.console.LogicTransfer;

public class RemoveByIDCommand extends Command{
    public RemoveByIDCommand(LogicTransfer logicTransfer){super("remove_by_id", logicTransfer);}
    @Override
    public void execute(String arg) {
        collectionManager.getCollection().getLabWorks().remove(Integer.parseInt(arg));
        logicTransfer.sendOutputln("Элемент удален");
    }
}
