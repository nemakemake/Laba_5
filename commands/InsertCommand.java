package commands;

import collection.CollectionManager;
import collection.ElementCreate;

public class InsertCommand extends Command{
    CollectionManager collectionManager = new CollectionManager();
    public InsertCommand(){
        super("insert");
    }
    @Override
    public void execute(String arg) {
        collectionManager.addToCollection(ElementCreate.createNewElement());
    }
}
