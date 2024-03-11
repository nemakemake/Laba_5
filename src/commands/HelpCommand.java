package src.commands;

import src.structure.LogicTransfer;
import src.utilities.ConsoleInput;
import src.utilities.ConsoleOutput;

public class HelpCommand extends Command {
    public HelpCommand(LogicTransfer logicTransfer){
        super("help", logicTransfer);
    }
    @Override
    public void execute(String arg){
        logicTransfer.sendOutputln("list of commands...");
    }
}
