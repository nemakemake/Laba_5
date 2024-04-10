package src.structure.logic;

import src.structure.console.LogicTransfer;
import src.parsing.JsonParser;
import src.parsing.JsonWriter;

import java.io.IOException;
import java.util.HashSet;


public class FileManager {
    CollectionManager collectionManager;
    LogicTransfer logicTransfer;

    public FileManager(LogicTransfer logicTransfer,CollectionManager collectionManager){
        this.collectionManager = collectionManager;
        this.logicTransfer = logicTransfer;
    }

    public void saveFile(){
        try {
            JsonWriter writer = new JsonWriter(collectionManager);
            writer.write();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void readFile(String filePath){
        JsonParser parser = new JsonParser(filePath);
        collectionManager.setCollection(parser.parse());
        collectionManager.setIdregistry(new HashSet<>(collectionManager.getKeySet()));
    }



}
