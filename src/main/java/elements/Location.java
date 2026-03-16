package elements;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import handlers.InputHandler;
import handlers.InputValidator;

/**
 * Location class
 */
public class Location implements Cloneable{
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
        x = InputHandler.longInput("Location x", new InputValidator<Long>()
                .nullable());

        y = InputHandler.floatInput("Location y");
        z = InputHandler.floatInput("Location z");
        name = InputHandler.stringInput("Location name");
    }

    private Location(Location l){
        this.x = l.x;
        this.y = l.y;
        this.z = l.z;
        this.name = l.name;
    }

    boolean validate() {
        return (y != null
                && z != null
                && name != null
                && !name.isBlank());
    }

    @Override
    protected Location clone() {
        return new Location(this);
    }

    @Override
    public String toString() {
        return String.format("%s: (x: %s, y: %s, z: %s)", name, x, y, z);
    }
}