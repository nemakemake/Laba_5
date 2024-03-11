package src.structure;

import src.collection.Collection;
import src.data.LabWork;
import src.interfaces.CollectionManagement;
import src.utilities.FileOperator;

import java.io.FileNotFoundException;
import java.util.HashSet;

public class CollectionManager implements CollectionManagement {
    Collection collection;
    FileOperator fileOperator = new FileOperator();
    HashSet<Integer> idregistry = new HashSet<Integer>();
    public CollectionManager() {
         this.collection = new Collection("Collection of Labs");
    }
    @Override
    public void readFile() throws FileNotFoundException {
        collection = fileOperator.readFile();
        for (int key: collection.getLabWorks().keySet()){
            idregistry.add(collection.getLabWorks().get(key).getId());
        }
    }

    @Override
    public HashSet<Integer> getIdregistry() {
        return idregistry;
    }

    @Override
    public void setIdregistry(HashSet<Integer> idregistry) {
        this.idregistry = idregistry;
    }

    @Override
    public Collection getCollection(){
        return collection;
    }
    @Override
    public void addToCollection(LabWork labWork){
        collection.getLabWorks().put(labWork.getId(),labWork);
    }
}
