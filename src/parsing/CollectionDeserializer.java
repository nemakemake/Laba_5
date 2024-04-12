package src.parsing;

import com.google.gson.*;
import src.collection.Collection;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.Hashtable;

public class CollectionDeserializer implements JsonDeserializer<Collection> {
    @Override
    public Collection deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException
    {
        Collection collection = new Collection();
        JsonObject data = json.getAsJsonObject();
        collection.setName(data.get("name").getAsString());
        collection.setCreationDate(context.deserialize(data.get("creationDate"), LocalDate.class));
        collection.setLabWorks(context.deserialize(data.get("LabWorks"), Hashtable.class));
        return collection;
    }
}
