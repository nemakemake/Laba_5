package src.commands;

import src.collection.Collection;
import src.structure.CollectionManager;
import src.utilities.ConsoleOutput;

public class InfoCommand extends Command{
    public InfoCommand(ConsoleOutput output){
        super("info", output);
    }

    CollectionManager collectionManager = new CollectionManager();
    Collection demoCollection;
    @Override
    public void execute(String arg){
        demoCollection = collectionManager.getCollection();
        output.println(
                "type             | HashTable \n"+
                "name             | " + demoCollection.getName() + "\n"+
                "date of creation | "+ demoCollection.getCreationDate().toString() + "\n"+
                "collection size  | "+ demoCollection.getLabWorks().size() + " elements"
        );
    }
}

