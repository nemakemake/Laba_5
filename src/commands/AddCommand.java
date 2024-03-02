package src.commands;

import src.collection.ElementCreate;

public class AddCommand extends Command{

    public AddCommand(){
        super("insert");
    }
    @Override
    public void execute(String arg) {
        collectionManager.addToCollection(ElementCreate.createNewElement());
    }
}
