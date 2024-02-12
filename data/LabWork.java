package data;


import java.time.LocalDate;

public class LabWork {
    private Integer id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private LocalDate creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private float minimalPoint; //Значение поля должно быть больше 0
    private Float maximumPoint; //Поле может быть null, Значение поля должно быть больше 0
    private Difficulty difficulty; //Поле может быть null
    private Discipline discipline; //Поле может быть null

    public LabWork(){}

    public LabWork(Integer id, String name, Coordinates coordinates, LocalDate creationDate, float minimalPoint, Float maximumPoint, Integer difficulty,Discipline discipline){
        this.id = id;
        this.name= name;
        this.coordinates = coordinates;
        this.creationDate = creationDate;
        this.minimalPoint = minimalPoint;
        this.maximumPoint = maximumPoint;
        if (difficulty == null){ this.difficulty = null;}
        else {this.difficulty = Difficulty.values()[difficulty-1];}
        this.discipline = discipline;
    }

    public LabWork createSample(){
        return new LabWork(1,"sample", new Coordinates(1,1d), LocalDate.now(), 1f, 5f, 2, new Discipline("SampleDis", 1));
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "LabWork{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coordinates=" + coordinates +
                ", creationDate=" + creationDate +
                ", minimalPoint=" + minimalPoint +
                ", maximumPoint=" + maximumPoint +
                ", difficulty=" + difficulty +
                ", discipline=" + discipline +
                '}';
    }
}
