package src.data;

public class Discipline implements Comparable {
    private String nameOfDiscipline; //Поле не может быть null, Строка не может быть пустой
    private Integer labCount; //Поле не может быть null

    public Discipline(String name, Integer labCount){
        this.nameOfDiscipline = name;
        this.labCount = labCount;
    }

    public Discipline(){}

    public Integer getLabCount() {
        return labCount;
    }

    public void setLabCount(Integer labCount) {
        this.labCount = labCount;
    }

    public String getNameOfDiscipline() {
        return nameOfDiscipline;
    }

    public void setNameOfDiscipline(String nameOfDiscipline) {
        this.nameOfDiscipline = nameOfDiscipline;
    }


    @Override
    public int compareTo(Object o) {
        Discipline disc = (Discipline)o;
        return this.labCount.compareTo(disc.getLabCount());
    }

    @Override
    public String toString() {
        return "Discipline{" +
                "name='" + nameOfDiscipline + '\'' +
                ", practiceHours=" + labCount +
                '}';
    }
}