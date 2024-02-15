package commands;

import java.util.HashMap;

public class CommandManager {
    HelpCommand helpCommand = new HelpCommand();
    InsertCommand insertCommand = new InsertCommand();
    InfoCommand infoCommand = new InfoCommand();
    HashMap<String, Command> listOfCommands = new HashMap<String, Command>();

    public CommandManager(){
        listOfCommands.put("help", helpCommand);
        listOfCommands.put("insert",insertCommand);
        listOfCommands.put("info",infoCommand);
    }
    public void jobFinder(String name, String arg){
        listOfCommands.get(name).execute(arg);
    }
}
