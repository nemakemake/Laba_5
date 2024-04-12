package src;

import src.structure.logic.CollectionManager;
import src.structure.logic.CommandManager;
import src.structure.console.Console;
import src.structure.console.LogicTransfer;
import src.structure.logic.FileManager;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        LogicTransfer logicTransfer = new LogicTransfer();
        Console console = new Console();
        CommandManager commandManager = new CommandManager(logicTransfer, console);
        CollectionManager collectionManager = new CollectionManager();
        FileManager fileManager = new FileManager(logicTransfer, collectionManager);

        logicTransfer.setBlocks(console);
        console.setCommandManager(commandManager);
        commandManager.setBlocks(collectionManager, logicTransfer);
        fileManager.readFile(getFileName(logicTransfer));
        console.start();
    }

    public static String getFileName(LogicTransfer logicTransfer){
        logicTransfer.sendOutputln("Input filepath:");
        return logicTransfer.requestInput();
    }
}
