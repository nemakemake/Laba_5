package src.parsing;

import com.google.gson.*;
import src.data.Coordinates;

import java.lang.reflect.Type;

public class CoordinatesDeserializer implements JsonDeserializer<Coordinates>
{
    @Override
    public Coordinates deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException
    {
        Coordinates coordinates = new Coordinates();
        JsonObject data = json.getAsJsonObject();
        coordinates.setX(data.get("x").getAsInt());
        coordinates.setY(data.get("y").getAsInt());

        return coordinates;
    }
}