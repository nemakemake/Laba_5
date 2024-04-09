package src.parsing;

import com.google.gson.*;
import src.data.Coordinates;
import src.data.Difficulty;
import src.data.Discipline;
import src.data.LabWork;

import java.lang.reflect.Type;

public class LabWorkDeserializer implements JsonDeserializer<LabWork> {
    @Override
    public LabWork deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException
    {
        LabWork labWork = new LabWork();
        JsonObject data = json.getAsJsonObject();
        labWork.setName(data.get("name").getAsString());
        labWork.setId(data.get("id").getAsInt());
        labWork.setDifficulty(context.deserialize(data.get("difficulty"), Difficulty.class));
        labWork.setCoordinates(context.deserialize(data.get("coordinates"), Coordinates.class));
        labWork.setMinimalPoint(data.get("minimalPoint").getAsLong());
        labWork.setDiscipline(context.deserialize(data.get("discipline"), Discipline.class));
        return labWork;
    }
}
