package src.interfaces;

import src.collection.Collection;
import src.data.LabWork;

import java.io.FileNotFoundException;
import java.util.HashSet;

public interface CollectionManagement {
    void readFile() throws FileNotFoundException;

    HashSet<Integer> getIdregistry();

    void setIdregistry(HashSet<Integer> idregistry);

    Collection getCollection();

    void addToCollection(LabWork labWork);
}
