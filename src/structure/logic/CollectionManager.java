package src.structure.logic;

import src.collection.Collection;
import src.data.LabWork;
import src.interfaces.CollectionManagement;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;

public class CollectionManager implements CollectionManagement {
    Collection collection;
    HashSet<Integer> idregistry = new HashSet<Integer>();
    public CollectionManager() {
         this.collection = new Collection("Collection of Labs");
    }


    @Override
    public HashSet<Integer> getIdregistry() {
        return idregistry;
    }

    @Override
    public void setIdregistry(HashSet<Integer> idregistry) {
        this.idregistry = idregistry;
    }

    public void setCollection(Collection collection) {
        this.collection = collection;
    }

    @Override
    public Collection getCollection(){
        return collection;
    }

    @Override
    public void addToCollection(Object obj){
        LabWork labWork = (LabWork) obj;
        collection.getLabWorks().put(labWork.getId(),labWork);
    }

    public Hashtable<Integer, LabWork> getLabWorks(){return getCollection().getLabWorks();}

    public Set<Integer> getKeySet (){
        return getCollection().getLabWorks().keySet();
    }

    @Override
    public LabWork getElement(int ID){
        return getCollection().getLabWorks().get(ID);
    }
}
