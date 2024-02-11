package collection;

import data.LabWork;

import java.util.Hashtable;

public class Collection {
    private Hashtable<Integer, LabWork> LabWorks;
    private Collection(){
        LabWorks = new Hashtable<Integer, LabWork>();
    }

    public void createCollection(){}

    public Hashtable<Integer, LabWork> getLabWorks() {
        return LabWorks;
    }

    public void setLabWorks(Hashtable<Integer, LabWork> labWorks) {
        LabWorks = labWorks;
    }
}
