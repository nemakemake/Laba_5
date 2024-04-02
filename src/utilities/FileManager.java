package src.utilities;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import src.collection.Collection;
import src.data.LabWork;
import src.structure.CollectionManager;
import src.structure.LogicTransfer;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Scanner;

public class FileManager {
    Scanner scanner;
    GsonBuilder builder = new GsonBuilder();
    Gson gson = builder.create();
    CollectionManager collectionManager;
    LogicTransfer logicTransfer;
    public FileManager(String arg, LogicTransfer logicTransfer,CollectionManager collectionManager){
        scanner = new Scanner(arg);
        this.collectionManager = collectionManager;
        this.logicTransfer = logicTransfer;
    }

    public String parseToJSON(Hashtable<Integer, LabWork> labWorks){
        String temp = gson.toJson(labWorks);
        return temp;
    }

    public Collection readJSON(String json){
        Collection collection = gson.fromJson(json,Collection.class);
        return collection;
    }

    public void test(){
        Collection temp = collectionManager.getCollection();
        logicTransfer.sendOutput(readJSON(parseToJSON(temp.getLabWorks())).toString());
    }


}
