package src.commands;

import src.structure.console.LogicTransfer;

public class CountByDifficultyCommand extends Command{
    public CountByDifficultyCommand(LogicTransfer logicTransfer) {
        super("count_by_difficulty", logicTransfer);
    }

    @Override
    public void execute(String arg) {
        int k = 0;
        System.out.print("Выберите сложность работы для поиска\n" +
                "1) VERY_EASY\n" +
                "2) NORMAL\n" +
                "3) VERY_HARD\n" +
                "4) TERRIBLE\n->");
        int level = Integer.parseInt(logicTransfer.requestInput());
        for (int key: collectionManager.getKeySet()){
            if (collectionManager.getElement(key).getDifficulty().ordinal()+1 == level){
                k++;
            }
        }
        logicTransfer.sendOutputln("Количество элементов в коллекции с данной сложностью: "+k);
    }
}
