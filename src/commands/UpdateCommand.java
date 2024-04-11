package src.commands;

import src.structure.logic.CollectionManager;
import src.structure.console.LogicTransfer;
import src.structure.utils.Updater;

public class UpdateCommand extends Command{
    private final Updater updater;
    public UpdateCommand(LogicTransfer logicTransfer){
        super("update", logicTransfer);
        this.updater = new Updater(collectionManager, logicTransfer);
    }

    @Override
    public void setCollectionManager(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
        this.updater.setCollectionManager(collectionManager);
    }

    @Override
    public void setLogicTransfer(LogicTransfer logicTransfer){
        this.logicTransfer = logicTransfer;
        this.updater.setLogicTransfer(logicTransfer);
    }

    @Override
    public void execute(String arg) {
        this.updater.update(Integer.parseInt(arg));
    }
}
