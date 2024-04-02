package src;

import src.structure.CollectionManager;
import src.structure.CommandManager;
import src.structure.Console;
import src.structure.LogicTransfer;
import src.utilities.ConsoleInput;
import src.utilities.ConsoleOutput;
import src.utilities.FileManager;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        LogicTransfer logicTransfer = new LogicTransfer();
        Console console = new Console();
        CommandManager commandManager = new CommandManager(logicTransfer);
        CollectionManager collectionManager = new CollectionManager();
        FileManager fileManager;

        collectionManager.readFile();
        logicTransfer.setBlocks(console, commandManager);
        console.setCommandManager(commandManager);
        commandManager.setBlocks(collectionManager, logicTransfer);
        fileManager = new FileManager(getFileName(logicTransfer),logicTransfer,collectionManager);
        fileManager.test();
        console.start();
    }

    public static String getFileName(LogicTransfer logicTransfer){
        logicTransfer.sendOutputln("Input filepath:");
        return logicTransfer.requestInput();
    }
}
