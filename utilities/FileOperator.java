package utilities;

import collection.Collection;
import data.Coordinates;
import data.Discipline;
import data.LabWork;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;
import java.io.File;

public class FileOperator {
    File testFile = new File("test2.json");
    public Collection readFile() throws FileNotFoundException {
        Scanner scanner = new Scanner(testFile);
        return new Collection(testFile.getName(), parseToLab(scanner), Instant.ofEpochMilli(testFile.lastModified()).atZone(ZoneId.systemDefault()).toLocalDate());
    }

    public Hashtable<Integer, LabWork> parseToLab(Scanner scanner){
        String line = "";
        boolean flag = false;
        Hashtable<Integer, LabWork> labWorks = new Hashtable<Integer, LabWork>();
        HashMap<String, String> classBricks = new HashMap<String, String>();
        String[] dataLine;
        while(scanner.hasNext()){
            line = scanner.nextLine();
            if(line.matches(".*?\\\"lab.*?\\\": \\{$")){
                if (flag){
                    labWorks.put(Integer.parseInt(classBricks.get("id")), convertToLab(classBricks));
                    classBricks.clear();
                } else {flag = true;}
            }
            if (!(line.contains("}") || line.contains("{"))) {
                dataLine = readJSONLine(line);
                classBricks.put(dataLine[0], dataLine[1]);
            }
        }
        labWorks.put(Integer.parseInt(classBricks.get("id")), convertToLab(classBricks));
        return labWorks;
    }


    public String[] readJSONLine(String line){
        return line.replaceAll("[ \t,\"]","").split(":");
    }

    public LabWork convertToLab(HashMap<String, String> bricks){
        System.out.println(bricks);
        int id = Integer.parseInt(bricks.get("id"));
        String name = bricks.get("name");
        Coordinates coordinates = new Coordinates(
                Long.parseLong(bricks.get("x")),
                Double.parseDouble(bricks.get("y"))
        );
        LocalDate localDate =LocalDate.parse(bricks.get("creationDate"));
        Long minimalPoint = Long.parseLong(bricks.get("minimalPoint"));
        Integer difficulty;
        if (Objects.equals(bricks.get("difficulty"), "null")) {
            difficulty = null;
        } else {
            difficulty = Integer.parseInt(bricks.get("difficulty"));
        }
        Discipline discipline = new Discipline(
                bricks.get("nameOfDiscipline"),
                Integer.parseInt(bricks.get("practiceHours"))
        );
        return new LabWork(id, name, coordinates, localDate, minimalPoint, difficulty, discipline);
    }
}
