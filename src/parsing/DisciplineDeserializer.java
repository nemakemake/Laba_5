package src.parsing;

import com.google.gson.*;
import src.data.Discipline;

import java.lang.reflect.Type;

public class DisciplineDeserializer implements JsonDeserializer<Discipline> {
    @Override
    public Discipline deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException
    {
        Discipline discipline= new Discipline();
        JsonObject data = json.getAsJsonObject();
        discipline.setNameOfDiscipline(data.get("nameOfDiscipline").getAsString());
        discipline.setLabCount(data.get("labCount").getAsInt());
        return discipline;
    }
}
