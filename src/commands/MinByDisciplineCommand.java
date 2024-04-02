package src.commands;

import src.data.LabWork;
import src.structure.CollectionManager;
import src.structure.LogicTransfer;

public class MinByDisciplineCommand extends Command{
    public MinByDisciplineCommand(LogicTransfer logicTransfer) {
        super("min_by_discipline", logicTransfer);
    }


    @Override
    public void execute(String arg) {
        LabWork min = null;
        boolean fl = true;
        for (int key: collectionManager.getCollection().getLabWorks().keySet()){
            LabWork temp = collectionManager.getElement(key);
            if (fl){
                min = temp;
                fl = false;
                continue;
            }
            min = min.getDiscipline().compareTo(temp.getDiscipline()) >= 0 ? temp : min;
        }
        logicTransfer.sendOutput(min.toString());
    }
}

