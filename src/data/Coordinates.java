package src.data;

public class Coordinates {
    private long x; //Значение поля должно быть больше -804
    private Double y; //Значение поля должно быть больше -710, Поле не может быть null

    public Coordinates(long x, Double y){
        this.x = x;
        this.y = y;
    }

    public Coordinates(){}

    public long getX() {
        return x;
    }

    public void setX(long x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
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