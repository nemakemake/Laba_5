package src.commands;

import src.structure.console.LogicTransfer;

public class ExitCommand extends Command{
    public ExitCommand(LogicTransfer logicTransfer){
        super("exit", logicTransfer);
    }

    @Override
    public void execute(String arg) {
        logicTransfer.sendOutputln("Shutdown...");
        System.exit(0);
    }
}
