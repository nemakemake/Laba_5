package src.interfaces;

import src.collection.Collection;
import src.data.LabWork;

import java.io.FileNotFoundException;
import java.util.HashSet;

public interface CollectionManagement {

    HashSet<Integer> getIdregistry();

    void setIdregistry(HashSet<Integer> idregistry);

    <T> T getCollection();

    void addToCollection(Object obj);

    <T> T getElement(int ID);
}
