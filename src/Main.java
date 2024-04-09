package src;

import src.structure.CollectionManager;
import src.structure.CommandManager;
import src.structure.Console;
import src.structure.LogicTransfer;
import src.utilities.FileManager;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        LogicTransfer logicTransfer = new LogicTransfer();
        Console console = new Console();
        CommandManager commandManager = new CommandManager(logicTransfer);
        CollectionManager collectionManager = new CollectionManager();
        FileManager fileManager = new FileManager(logicTransfer, collectionManager);

        logicTransfer.setBlocks(console, commandManager);
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
