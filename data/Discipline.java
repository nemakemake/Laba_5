package data;

public class Discipline {
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Integer practiceHours; //Поле не может быть null

    public Discipline(String name, Integer practiceHours){
        this.name = name;
        this.practiceHours = practiceHours;
    }

    public Integer getPracticeHours() {
        return practiceHours;
    }

    public void setPracticeHours(Integer practiceHours) {
        this.practiceHours = practiceHours;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}