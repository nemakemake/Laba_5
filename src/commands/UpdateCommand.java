package src.commands;

import src.structure.CollectionManager;
import src.structure.LogicTransfer;
import src.utilities.Updater;

public class UpdateCommand extends Command{
    private Updater updater;
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
