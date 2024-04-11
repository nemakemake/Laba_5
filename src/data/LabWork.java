package src.data;


import java.time.LocalDate;

public class LabWork implements Comparable{
    private Integer id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private LocalDate creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Long minimalPoint; //Поле может быть null, Значение поля должно быть больше 0
    private Difficulty difficulty; //Поле может быть null
    private Discipline discipline; //Поле может быть null

    public LabWork(){}

    public LabWork(Integer id, String name, Coordinates coordinates, LocalDate creationDate, Long minimalPoint, Integer difficulty,Discipline discipline){
        this.id = id;
        this.name= name;
        this.coordinates = coordinates;
        this.creationDate = creationDate;
        this.minimalPoint = minimalPoint;
        if (difficulty == null){ this.difficulty = null;}
        else {this.difficulty = Difficulty.values()[difficulty-1];}
        this.discipline = discipline;
    }

    public LabWork createSample(){
        return new LabWork(1,"sample", new Coordinates(1,1), LocalDate.now(), 1L, 2, new Discipline("SampleDis", 1));
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public Long getMinimalPoint() {
        return minimalPoint;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public Discipline getDiscipline() {
        return discipline;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public void setMinimalPoint(Long minimalPoint) {
        this.minimalPoint = minimalPoint;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public void setDiscipline(Discipline discipline) {
        this.discipline = discipline;
    }


    @Override
    public String toString() {
        return "LabWork{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coordinates=" + coordinates +
                ", creationDate=" + creationDate +
                ", minimalPoint=" + minimalPoint +
                ", difficulty=" + difficulty +
                ", discipline=" + discipline +
                '}';
    }

    @Override
    public int compareTo(Object o){
        LabWork oLab = (LabWork)o;
        int compareOfDifficulty = this.difficulty.compareTo(oLab.getDifficulty());
        if (compareOfDifficulty != 0){
            return compareOfDifficulty;
        }
        int compareOfDiscipline = this.discipline.compareTo(oLab.getDiscipline());
        if (compareOfDiscipline != 0){
            return compareOfDiscipline;
        }
        return this.id.compareTo(oLab.getId());
    }
}
