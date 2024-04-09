package src.parsing;

import com.google.gson.reflect.TypeToken;
import src.collection.Collection;
import src.data.Coordinates;
import src.data.Difficulty;
import src.data.Discipline;
import src.data.LabWork;
import src.interfaces.Parser;
import com.google.gson.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.Hashtable;
import java.util.Scanner;


public class JsonParser implements Parser {
    Gson gson;
    String filePath;
    String haha = "{\n" +
            "  \"LabWorks\": {\n" +
            "    \"1\": {\n" +
            "      \"id\": 1,\n" +
            "      \"name\": \"Lab 1\",\n" +
            "      \"coordinates\": {\n" +
            "        \"x\": 100,\n" +
            "        \"y\": 200\n" +
            "      },\n" +
            "      \"creationDate\": \"2022-03-15\",\n" +
            "      \"minimalPoint\": 5,\n" +
            "      \"difficulty\": 1,\n" +
            "      \"discipline\": {\n" +
            "        \"nameOfDiscipline\": \"Math\",\n" +
            "        \"labCount\": 12\n" +
            "      }\n" +
            "    },\n" +
            "    \"2\": {\n" +
            "      \"id\": 2,\n" +
            "      \"name\": \"Lab 2\",\n" +
            "      \"coordinates\": {\n" +
            "        \"x\": 150,\n" +
            "        \"y\": 250\n" +
            "      },\n" +
            "      \"creationDate\": \"2022-03-16\",\n" +
            "      \"minimalPoint\": 6,\n" +
            "      \"difficulty\": 2,\n" +
            "      \"discipline\": {\n" +
            "        \"nameOfDiscipline\": \"Physics\",\n" +
            "        \"labCount\": 15\n" +
            "      }\n" +
            "    },\n" +
            "    \"3\": {\n" +
            "      \"id\": 3,\n" +
            "      \"name\": \"Lab 3\",\n" +
            "      \"coordinates\": {\n" +
            "        \"x\": 200,\n" +
            "        \"y\": 300\n" +
            "      },\n" +
            "      \"creationDate\": \"2022-03-17\",\n" +
            "      \"minimalPoint\": 7,\n" +
            "      \"difficulty\": 3,\n" +
            "      \"discipline\": {\n" +
            "        \"nameOfDiscipline\": \"Chemistry\",\n" +
            "        \"labCount\": 10\n" +
            "      }\n" +
            "    },\n" +
            "    \"4\": {\n" +
            "      \"id\": 4,\n" +
            "      \"name\": \"Lab 4\",\n" +
            "      \"coordinates\": {\n" +
            "        \"x\": 250,\n" +
            "        \"y\": 350\n" +
            "      },\n" +
            "      \"creationDate\": \"2022-03-18\",\n" +
            "      \"minimalPoint\": 6,\n" +
            "      \"difficulty\": 4,\n" +
            "      \"discipline\": {\n" +
            "        \"nameOfDiscipline\": \"Biology\",\n" +
            "        \"labCount\": 12\n" +
            "      }\n" +
            "    },\n" +
            "    \"5\": {\n" +
            "      \"id\": 5,\n" +
            "      \"name\": \"Lab 5\",\n" +
            "      \"coordinates\": {\n" +
            "        \"x\": 300,\n" +
            "        \"y\": 400\n" +
            "      },\n" +
            "      \"creationDate\": \"2022-03-19\",\n" +
            "      \"minimalPoint\": 8,\n" +
            "      \"difficulty\": 1,\n" +
            "      \"discipline\": {\n" +
            "        \"nameOfDiscipline\": \"Biology\",\n" +
            "        \"labCount\": 8\n" +
            "      }\n" +
            "    },\n" +
            "    \"6\": {\n" +
            "      \"id\": 6,\n" +
            "      \"name\": \"Lab 6\",\n" +
            "      \"coordinates\": {\n" +
            "        \"x\": 350,\n" +
            "        \"y\": 450\n" +
            "      },\n" +
            "      \"creationDate\": \"2022-03-20\",\n" +
            "      \"minimalPoint\": 7,\n" +
            "      \"difficulty\": 1,\n" +
            "      \"discipline\": {\n" +
            "        \"nameOfDiscipline\": \"Biology\",\n" +
            "        \"labCount\": 7\n" +
            "      }\n" +
            "    },\n" +
            "    \"7\": {\n" +
            "      \"id\": 7,\n" +
            "      \"name\": \"Lab 7\",\n" +
            "        \"coordinates\": {\n" +
            "          \"x\": 400,\n" +
            "          \"y\": 500\n" +
            "      },\n" +
            "      \"creationDate\": \"2022-03-21\",\n" +
            "      \"minimalPoint\": 6,\n" +
            "      \"difficulty\": 3,\n" +
            "      \"discipline\": {\n" +
            "        \"nameOfDiscipline\": \"Computer Science\",\n" +
            "        \"labCount\": 20\n" +
            "      }\n" +
            "    },\n" +
            "    \"8\": {\n" +
            "      \"id\": 8,\n" +
            "      \"name\": \"Lab 8\",\n" +
            "      \"coordinates\": {\n" +
            "        \"x\": 450,\n" +
            "        \"y\": 550\n" +
            "      },\n" +
            "      \"creationDate\": \"2022-03-22\",\n" +
            "      \"minimalPoint\": 7,\n" +
            "      \"difficulty\": 2,\n" +
            "      \"discipline\": {\n" +
            "        \"nameOfDiscipline\": \"Engineering\",\n" +
            "        \"labCount\": 18\n" +
            "      }\n" +
            "    },\n" +
            "    \"9\": {\n" +
            "      \"id\": 9,\n" +
            "      \"name\": \"Lab 9\",\n" +
            "      \"coordinates\": {\n" +
            "        \"x\": 500,\n" +
            "        \"y\": 600\n" +
            "      },\n" +
            "      \"creationDate\": \"2022-03-23\",\n" +
            "      \"minimalPoint\": 6,\n" +
            "      \"difficulty\": 1,\n" +
            "      \"discipline\": {\n" +
            "        \"nameOfDiscipline\": \"Geology\",\n" +
            "        \"labCount\": 11\n" +
            "      }\n" +
            "    },\n" +
            "    \"10\": {\n" +
            "      \"id\": 10,\n" +
            "      \"name\": \"Lab 10\",\n" +
            "      \"coordinates\": {\n" +
            "        \"x\": 550,\n" +
            "        \"y\": 650\n" +
            "      },\n" +
            "      \"creationDate\": \"2022-03-24\",\n" +
            "      \"minimalPoint\": 7,\n" +
            "      \"difficulty\": 2,\n" +
            "      \"discipline\": {\n" +
            "        \"nameOfDiscipline\": \"Astronomy\",\n" +
            "        \"labCount\": 14\n" +
            "      }\n" +
            "    }\n" +
            "  },\n" +
            "  \"creationDate\": \"2024-03-25\",\n" +
            "  \"name\": \"test2.json\"\n" +
            "}\n" +
            "\n";
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
        try (Scanner scanner = new Scanner(new FileReader(filePath))){
            collection = gson.fromJson(
                    haha,
                    new TypeToken<Collection>(){}.getType()
            );
        } catch (FileNotFoundException e){
            throw new RuntimeException();
        }
        return collection;
    }

}
