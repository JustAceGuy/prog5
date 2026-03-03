package elements;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import handlers.InputHandler;
import handlers.Validator;

/**
 * Coordinates class
 */
public class Coordinates{
    @JacksonXmlProperty
    private Integer x; //Максимальное значение поля: 926
    @JacksonXmlProperty
    private Float y;//Значение поля должно быть больше -974, Поле не может быть null

    public Coordinates() {
        if (Route.isLoading) {return;}
        this.x = InputHandler.intInput("x", new Validator<Integer>()
                .nullable()
                .upper(927));
        this.y = InputHandler.floatInput("y", new Validator<Float>()
                .lower(-974f));
    }


    @Override
    public String toString() {
        return String.format("x: %d y: %f", x, y);
    }
}