package src.structure.logic;

import src.commands.*;
import src.structure.console.Console;
import src.structure.utils.History;
import src.structure.console.LogicTransfer;

import java.util.HashMap;

public class CommandManager {
    HashMap<String, Command> listOfCommands = new HashMap<String, Command>();
    CollectionManager collectionManager;
    LogicTransfer logicTransfer;
    History history = new History();

    public CommandManager(LogicTransfer logicTransfer, Console console){
        addCommand("help", new HelpCommand(logicTransfer));
        addCommand("save", new SaveCommand(logicTransfer));
        addCommand("exit", new ExitCommand(logicTransfer));
        addCommand("execute_script", new ExecuteScriptCommand(logicTransfer, this, console));
        addCommand("add", new AddCommand(logicTransfer));
        addCommand("info",new InfoCommand(logicTransfer));
        addCommand("show",new ShowCommand(logicTransfer));
        addCommand("update", new UpdateCommand(logicTransfer));
        addCommand("remove_by_id", new RemoveByIDCommand(logicTransfer));
        addCommand("clear", new ClearCommand(logicTransfer));
        addCommand("add_if_max", new AddIfMaxCommand(logicTransfer));
        addCommand("remove_greater", new RemoveGreaterCommand(logicTransfer));
        addCommand("history", new HistoryCommand(logicTransfer, history));
        addCommand("min_by_discipline", new MinByDisciplineCommand(logicTransfer));
        addCommand("count_by_difficulty", new CountByDifficultyCommand(logicTransfer));
    }

    public void setBlocks(CollectionManager collectionManager, LogicTransfer logicTransfer){
        this.collectionManager = collectionManager;
        this.logicTransfer = logicTransfer;
        for (String key: listOfCommands.keySet()){
            listOfCommands.get(key).setLogicTransfer(logicTransfer);
            listOfCommands.get(key).setCollectionManager(collectionManager);
        }
    }
    private void addCommand(String name, Command command){
        command.setCollectionManager(collectionManager);
        listOfCommands.put(name, command);
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
