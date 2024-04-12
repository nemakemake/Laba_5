package src.structure.logic;

import src.structure.console.LogicTransfer;
import src.parsing.JsonParser;
import src.parsing.JsonWriter;

import java.io.IOException;
import java.util.HashSet;


public class FileManager {
    final CollectionManager collectionManager;
    final LogicTransfer logicTransfer;

    public FileManager(LogicTransfer logicTransfer,CollectionManager collectionManager){
        this.collectionManager = collectionManager;
        this.logicTransfer = logicTransfer;
    }

    public void saveFile(){
        JsonWriter writer = new JsonWriter(collectionManager);
        writer.write();
    }

    public void readFile(String filePath){
        try {
            JsonParser parser = new JsonParser(filePath);
            collectionManager.setCollection(parser.parse());
            collectionManager.setIdregistry(new HashSet<>(collectionManager.getKeySet()));
        } catch (RuntimeException e){
            logicTransfer.sendOutputln("Invalid filepath");
            System.exit(0);
        }
    }



}
