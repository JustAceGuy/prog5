package elements;

import handlers.InputHandler;

/**
 * Coordinates class
 */
public class Coordinates{
    public Integer x; //Максимальное значение поля: 926
    public Float y;//Значение поля должно быть больше -974, Поле не может быть null
    public Coordinates() {
        if (Route.isLoading) {return;}
        Integer tmp = InputHandler.intInput("x", true, 927, null);
        if (tmp != null) {this.x = tmp;}
        this.y = InputHandler.floatInput("y", false, null, -974f);
    }

    @Override
    public String toString() {
        return String.format("x: %d y:%f", x, y);
    }
}