package src.commands;

import src.utilities.ConsoleInput;
import src.utilities.ConsoleOutput;

public class HelpCommand extends Command {
    public HelpCommand(ConsoleOutput output){
        super("help", output);
    }
    @Override
    public void execute(String arg){
        output.println("list of commands...");
    }
}
