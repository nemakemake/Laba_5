package src.structure.logic;

import src.commands.*;
import src.structure.console.Console;
import src.structure.utils.History;
import src.structure.console.LogicTransfer;

import java.util.HashMap;

public class CommandManager {
    final HashMap<String, Command> listOfCommands = new HashMap<>();
    CollectionManager collectionManager;
    LogicTransfer logicTransfer;
    final History history = new History();

    public CommandManager(LogicTransfer logicTransfer, Console console){
        addCommand(new HelpCommand(logicTransfer));
        addCommand(new SaveCommand(logicTransfer));
        addCommand(new ExitCommand(logicTransfer));
        addCommand(new ExecuteScriptCommand(logicTransfer, this, console));
        addCommand(new AddCommand(logicTransfer));
        addCommand(new InfoCommand(logicTransfer));
        addCommand(new ShowCommand(logicTransfer));
        addCommand(new UpdateCommand(logicTransfer));
        addCommand(new RemoveByIDCommand(logicTransfer));
        addCommand(new ClearCommand(logicTransfer));
        addCommand(new AddIfMaxCommand(logicTransfer));
        addCommand(new RemoveGreaterCommand(logicTransfer));
        addCommand(new HistoryCommand(logicTransfer, history));
        addCommand(new MinByDisciplineCommand(logicTransfer));
        addCommand(new CountByDifficultyCommand(logicTransfer));
    }

    public void setBlocks(CollectionManager collectionManager, LogicTransfer logicTransfer){
        this.collectionManager = collectionManager;
        this.logicTransfer = logicTransfer;
        for (String key: listOfCommands.keySet()){
            listOfCommands.get(key).setLogicTransfer(logicTransfer);
            listOfCommands.get(key).setCollectionManager(collectionManager);
        }
    }
    private void addCommand(Command command){
        command.setCollectionManager(collectionManager);
        listOfCommands.put(command.getDescription(), command);
    }
    public void jobFinder(String name, String arg){
        try {
            listOfCommands.get(name).execute(arg);
        } catch (NullPointerException e){
            logicTransfer.sendOutputln("Invalid command");
            return;
        }
        history.addToHistory(listOfCommands.get(name));
    }

}
