package src.collection;

import src.data.LabWork;

import java.time.LocalDate;
import java.util.Hashtable;

public class Collection {
    private Hashtable<Integer, LabWork> LabWorks;
    private LocalDate CreationDate;
    private String name;
    public Collection(String name){
        this.LabWorks = new Hashtable<>();
        this.CreationDate = LocalDate.now();
        this.name = name;
    }

    public Collection(String name, Hashtable<Integer, LabWork> labWorks){
        this.LabWorks = labWorks;
        this.CreationDate = LocalDate.now();
        this.name = name;
    }

    public Collection(){}

    public Collection(String name, Hashtable<Integer, LabWork> labWorks, LocalDate date){
        this.LabWorks = labWorks;
        this.CreationDate = date;
        this.name = name;
    }

    public Hashtable<Integer, LabWork> getLabWorks() {
        return LabWorks;
    }

    public void setLabWorks(Hashtable<Integer, LabWork> labWorks) {
        LabWorks = labWorks;
    }

    public void setCreationDate(LocalDate creationDate) {
        CreationDate = creationDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getCreationDate() {
        return CreationDate;
    }

    public String getName() {
        return name;
    }
}
