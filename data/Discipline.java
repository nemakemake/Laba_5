package data;

public class Discipline {
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Integer labCount; //Поле не может быть null

    public Discipline(String name, Integer practiceHours){
        this.name = name;
        this.labCount = practiceHours;
    }

    public Integer getLabCount() {
        return labCount;
    }

    public void setLabCount(Integer labCount) {
        this.labCount = labCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Discipline{" +
                "name='" + name + '\'' +
                ", practiceHours=" + labCount +
                '}';
    }
}