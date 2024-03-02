package src.structure;

import src.commands.AddCommand;
import src.commands.Command;
import src.commands.HelpCommand;
import src.commands.InfoCommand;
import src.utilities.ConsoleInput;
import src.utilities.ConsoleOutput;

import java.util.HashMap;

public class CommandManager {
    HashMap<String, Command> listOfCommands = new HashMap<String, Command>();
    CollectionManager collectionManager;

    public CommandManager(ConsoleOutput output, ConsoleInput input){
        collectionManager = new CollectionManager();
        addCommand("help", new HelpCommand(output));
        addCommand("add", new AddCommand());
        addCommand("info",new InfoCommand(output));
    }
    private void addCommand(String name, Command command){
        command.setCollectionManager(collectionManager);
        listOfCommands.put(name, command);
    }
    public void jobFinder(String name, String arg){
        listOfCommands.get(name).execute(arg);
    }
}
