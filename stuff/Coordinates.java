package stuff;

public class Coordinates{
    private Integer x; //Максимальное значение поля: 926
    private Float y;//Значение поля должно быть больше -974, Поле не может быть null
    public Coordinates() {
        Integer tmp = Message.intInput("x", true, 927, null);
        if (tmp != null) {this.x = tmp;}
        this.y = Message.floatInput("y", false, null, -974f);
    }

    @Override
    public String toString() {
        return String.format("x: %d y:%f", x, y);
    }
}