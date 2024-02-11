package collection;

import data.LabWork;

import java.util.Hashtable;

public class CollectionManager {
    public CollectionManager() {}

    LabWork lab = new LabWork();
    private Hashtable<Integer, LabWork> LabWorks = new Hashtable<Integer, LabWork>();

    public void createSampleCollection(){
        LabWork sample = lab.createSample();
        LabWorks.put(sample.getId(), sample);
        System.out.println(LabWorks.toString());
    }
}
