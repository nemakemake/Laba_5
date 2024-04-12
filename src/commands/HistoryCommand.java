package src.commands;

import src.structure.utils.History;
import src.structure.console.LogicTransfer;

public class HistoryCommand extends Command{
    final History history;
    public HistoryCommand(LogicTransfer logicTransfer, History history){
        super("history", logicTransfer);
        this.history = history;
    }

    @Override
    public void execute(String arg) {
        logicTransfer.sendOutputln(history.toString());
    }
}
