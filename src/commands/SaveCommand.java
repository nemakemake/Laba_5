package src.commands;

import src.structure.console.LogicTransfer;
import src.structure.logic.FileManager;

import java.time.LocalDate;

public class SaveCommand extends Command{
    public SaveCommand(LogicTransfer logicTransfer){
        super("save", logicTransfer);
        this.logicTransfer = logicTransfer;
    }
    @Override
    public void execute(String arg) {
        FileManager fileManager = new FileManager(logicTransfer, collectionManager);
        collectionManager.getCollection().setCreationDate(LocalDate.now());
        fileManager.saveFile();
        logicTransfer.sendOutput("Complete.\n");
    }
}
