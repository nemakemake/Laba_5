package src.parsing;

import com.google.gson.*;
import src.data.Difficulty;


import java.lang.reflect.Type;

public class DifficultyDeserializer implements JsonDeserializer<Difficulty>
{
    @Override
    public Difficulty deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException
    {
        String data = json.getAsString();
        return switch (data) {
            case ("NORMAL") -> Difficulty.NORMAL;
            case ("VERY_EASY") -> Difficulty.VERY_EASY;
            case ("VERY_HARD") -> Difficulty.VERY_HARD;
            default -> Difficulty.TERRIBLE;
        };


    }
}