package src;

import src.structure.CollectionManager;
import src.structure.CommandManager;
import src.structure.Console;
import src.structure.LogicTransfer;
import src.utilities.ConsoleInput;
import src.utilities.ConsoleOutput;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        LogicTransfer logicTransfer = new LogicTransfer();
        Console console = new Console();
        CommandManager commandManager = new CommandManager(logicTransfer);
        CollectionManager collectionManager = new CollectionManager();

        collectionManager.readFile();
        logicTransfer.setBlocks(console, commandManager);
        console.setCommandManager(commandManager);
        commandManager.setBlocks(collectionManager, logicTransfer);

        console.start();
    }
}
