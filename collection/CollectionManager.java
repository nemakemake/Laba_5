package collection;

import data.LabWork;
import utilities.FileOperator;

import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Hashtable;

public class CollectionManager {
    public CollectionManager() {}
    FileOperator fileOperator = new FileOperator();
    LabWork lab = new LabWork();
    static HashSet<Integer> idregistry = new HashSet<Integer>();
    static Collection collection = new Collection("Collection of Labs");
    public void readFile() throws FileNotFoundException {
        collection = fileOperator.readFile();
    }

    public static HashSet<Integer> getIdregistry() {
        return idregistry;
    }

    public static void setIdregistry(HashSet<Integer> idregistry) {
        CollectionManager.idregistry = idregistry;
    }

    public static Collection getCollection(){
        return collection;
    }
    public static void addToCollection(LabWork labWork){
        collection.getLabWorks().put(labWork.getId(),labWork);
    }
}
