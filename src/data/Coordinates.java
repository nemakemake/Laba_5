package src.data;

public class Coordinates {
    private Integer x; //Значение поля должно быть больше -804
    private Integer y; //Значение поля должно быть больше -710, Поле не может быть null

    public Coordinates(Integer x, Integer y){
        this.x = x;
        this.y = y;
    }

    public Coordinates(){}

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
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