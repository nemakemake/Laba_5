package data;

public class Coordinates {
    private long x; //Значение поля должно быть больше -804
    private Double y; //Значение поля должно быть больше -710, Поле не может быть null

    public Coordinates(long x, Double y){
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Coordinates{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}