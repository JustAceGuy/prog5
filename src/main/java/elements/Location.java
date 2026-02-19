package elements;

import handlers.InputHandler;

public class Location {
    public Long x;
    public Float y; //Поле не может быть null
    public Float z; //Поле не может быть null
    public String name = ""; //Строка не может быть пустой, Поле не может быть null

    Location() {
        if (Route.isLoading) {return;}
        this.x = InputHandler.longInput("Location x", true, null, null);
        this.y = InputHandler.floatInput("Location y", false, null, null);
        this.z = InputHandler.floatInput("Location z", false, null, null);
        this.name = InputHandler.stringInput("Location name", false);
    }

    @Override
    public String toString() {
        return name;
    }
}