package src.parsing;

import com.google.gson.reflect.TypeToken;
import src.collection.Collection;
import src.data.Coordinates;
import src.data.Difficulty;
import src.data.Discipline;
import src.data.LabWork;
import src.interfaces.Parser;
import com.google.gson.*;

import java.io.*;
import java.time.LocalDate;
import java.util.Hashtable;


public class JsonParser implements Parser {
    Gson gson;
    String filePath;

    public JsonParser(String filePath){
        gson = new GsonBuilder()
                .registerTypeAdapter(LocalDate.class, new LocalDateTypeAdapter())
                .registerTypeAdapter(Difficulty.class, new DifficultyDeserializer())
                .registerTypeAdapter(Discipline.class, new DisciplineDeserializer())
                .registerTypeAdapter(Hashtable.class, new LabHashDeserializer())
                .registerTypeAdapter(Collection.class, new CollectionDeserializer())
                .registerTypeAdapter(Coordinates.class, new CoordinatesDeserializer())
                .registerTypeAdapter(LabWork.class, new LabWorkDeserializer())
                .create();
        this.filePath = filePath;
    }

    @Override
    public Collection parse() {
        Collection collection;
        try (BufferedInputStream stream = new BufferedInputStream(new FileInputStream(filePath))){
            collection = gson.fromJson(
                    new InputStreamReader(stream),
                    new TypeToken<Collection>(){}.getType()
            );
        } catch (FileNotFoundException e){
            throw new RuntimeException();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return collection;
    }

}
