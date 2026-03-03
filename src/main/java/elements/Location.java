package elements;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import handlers.InputHandler;
import handlers.Validator;

/**
 * Location class
 */
public class Location {
    @JacksonXmlProperty
    private Long x;
    @JacksonXmlProperty
    private Float y; //Поле не может быть null
    @JacksonXmlProperty
    private Float z; //Поле не может быть null
    @JacksonXmlProperty
    private String name = ""; //Строка не может быть пустой, Поле не может быть null

    Location() {
        if (Route.isLoading) {return;}
        this.x = InputHandler.longInput("Location x", new Validator<Long>()
                .nullable());
        this.y = InputHandler.floatInput("y", new Validator<Float>());
        this.y = InputHandler.floatInput("z", new Validator<Float>());
        this.name = InputHandler.stringInput("Location name", new Validator<String>());
    }

    @Override
    public String toString() {
        return name;
    }
}