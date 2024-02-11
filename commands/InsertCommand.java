package commands;

import collection.CollectionManager;

public class InsertCommand extends Command{
    CollectionManager collectionManager = new CollectionManager();
    public InsertCommand(){
        super("insert");
    }
    @Override
    public void doSomething(String arg) {
        collectionManager.createSampleCollection();
    }
}
