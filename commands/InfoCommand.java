package commands;

import collection.Collection;
import collection.CollectionManager;
import data.LabWork;

import java.util.Hashtable;

public class InfoCommand extends Command{
    public InfoCommand(){
        super("info");
    }

    CollectionManager collectionManager = new CollectionManager();
    Collection demoCollection;
    @Override
    public void execute(String arg){
        demoCollection = collectionManager.getCollection();
        System.out.println(
                "type             | HashTable \n"+
                "name             | " + demoCollection.getName() + "\n"+
                "date of creation | "+ demoCollection.getCreationDate().toString() + "\n"+
                "collection size  | "+ demoCollection.getLabWorks().size() + " elements"
        );
    }
}

