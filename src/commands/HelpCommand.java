package src.commands;

import src.structure.console.LogicTransfer;

public class HelpCommand extends Command {
    public HelpCommand(LogicTransfer logicTransfer){
        super("help", logicTransfer);
    }
    @Override
    public void execute(String arg){
        logicTransfer.sendOutputln("list of commands...");
    }
}
