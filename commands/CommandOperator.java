package commands;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Objects;

public class CommandOperator {
    HelpCommand helpCommand = new HelpCommand();
    InsertCommand insertCommand = new InsertCommand();
    HashSet<Command> listOfCommands = new HashSet<Command>();

    public CommandOperator(){}
    public void jobFinder(String name, String arg){
        listOfCommands.add(helpCommand);
        listOfCommands.add(insertCommand);

        for (Command command: listOfCommands){
            if (Objects.equals(command.getName(), name)) command.doSomething(arg);
        }
    }
}
