package src.commands;

import src.data.LabWork;
import src.structure.console.LogicTransfer;

public class MinByDisciplineCommand extends Command{
    public MinByDisciplineCommand(LogicTransfer logicTransfer) {
        super("min_by_discipline", logicTransfer);
    }


    @Override
    public void execute(String arg) {
        LabWork min = null;
        boolean fl = true;
        for (int key: collectionManager.getKeySet()){
            LabWork temp = collectionManager.getElement(key);
            if (fl){
                min = temp;
                fl = false;
                continue;
            }
            min = min.getDiscipline().compareTo(temp.getDiscipline()) >= 0 ? temp : min;
        }
        if (min != null) {
            logicTransfer.sendOutput(min.toString());
        }
    }
}

