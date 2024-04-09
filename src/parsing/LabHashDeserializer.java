package src.parsing;

import com.google.gson.*;
import src.data.LabWork;

import java.lang.reflect.Type;
import java.util.Hashtable;

public class LabHashDeserializer implements JsonDeserializer<Hashtable<Integer,LabWork>> {
    @Override
    public Hashtable<Integer, LabWork> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Hashtable<Integer, LabWork> labworks = new Hashtable<>();
        JsonObject data = json.getAsJsonObject();
        for (String key : data.asMap().keySet()) {
            labworks.put(Integer.parseInt(key), context.deserialize(data.get(key), LabWork.class));
        }
        return labworks;
    }
}
