package src.parsing;

import com.google.gson.*;
import src.collection.Collection;
import src.data.Coordinates;
import src.data.Difficulty;
import src.data.Discipline;
import src.data.LabWork;
import src.interfaces.Writer;
import src.structure.logic.CollectionManager;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Hashtable;


public class JsonWriter implements Writer {
    final String FILE_NAME = "collection.json";
    final Gson gson;
    final Collection collection;
    public JsonWriter(CollectionManager collectionManager) {
        gson = new GsonBuilder()
                .setPrettyPrinting()
                .registerTypeAdapter(LocalDate.class, new LocalDateTypeAdapter())
                .registerTypeAdapter(Difficulty.class, new DifficultyDeserializer())
                .registerTypeAdapter(Discipline.class, new DisciplineDeserializer())
                .registerTypeAdapter(Hashtable.class, new LabHashDeserializer())
                .registerTypeAdapter(Collection.class, new CollectionDeserializer())
                .registerTypeAdapter(Coordinates.class, new CoordinatesDeserializer())
                .registerTypeAdapter(LabWork.class, new LabWorkDeserializer())
                .create();
        collection = collectionManager.getCollection();
    }

    @Override
    public void write() {
        String jsonText = gson.toJson(collection);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (String value : jsonText.split("\n")) {
                writer.write(value + "\n");
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
 }
