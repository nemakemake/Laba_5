package src.commands;

import src.structure.LogicTransfer;
import src.utilities.FileManager;

public class SaveCommand extends Command{
    public SaveCommand(LogicTransfer logicTransfer){
        super("save", logicTransfer);
        this.logicTransfer = logicTransfer;
    }
    @Override
    public void execute(String arg) {
        FileManager fileManager = new FileManager(logicTransfer, collectionManager);
        fileManager.saveFile();
        logicTransfer.sendOutput("Complete.\n");
    }
}
