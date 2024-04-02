package src.data;

public class Discipline implements Comparable {
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Integer labCount; //Поле не может быть null

    public Discipline(String name, Integer labCount){
        this.name = name;
        this.labCount = labCount;
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
    public int compareTo(Object o) {
        Discipline disc = (Discipline)o;
        return this.labCount.compareTo(disc.getLabCount());
    }

    @Override
    public String toString() {
        return "Discipline{" +
                "name='" + name + '\'' +
                ", practiceHours=" + labCount +
                '}';
    }
}