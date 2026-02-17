package stuff;

public class Location {
    private Long x;
    private Float y; //Поле не может быть null
    private Float z; //Поле не может быть null
    private String name = ""; //Строка не может быть пустой, Поле не может быть null

    Location() {
        this.x = Message.longInput("Location x", true, null, null);
        this.y = Message.floatInput("Location y", false, null, null);
        this.z = Message.floatInput("Location z", false, null, null);
        this.name = Message.stringInput("Location name", false);
    }

    @Override
    public String toString() {
        return name;
    }
}