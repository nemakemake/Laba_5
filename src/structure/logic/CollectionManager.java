package src.structure.logic;

import src.collection.Collection;
import src.data.LabWork;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;

public class CollectionManager{
    Collection collection;
    HashSet<Integer> idregistry = new HashSet<>();
    public CollectionManager() {
         this.collection = new Collection("Collection of Labs");
    }


    public HashSet<Integer> getIdregistry() {
        return idregistry;
    }


    public void setIdregistry(HashSet<Integer> idregistry) {
        this.idregistry = idregistry;
    }

    public void setCollection(Collection collection) {
        this.collection = collection;
    }

    public Collection getCollection(){
        return collection;
    }

    public void addToCollection(Object obj){
        LabWork labWork = (LabWork) obj;
        collection.getLabWorks().put(labWork.getId(),labWork);
    }

    public Hashtable<Integer, LabWork> getLabWorks(){return getCollection().getLabWorks();}

    public Set<Integer> getKeySet (){
        return getCollection().getLabWorks().keySet();
    }

    public LabWork getElement(int ID){
        return getCollection().getLabWorks().get(ID);
    }
}
