package stuff;

import java.util.Scanner;

public class Route {
    public static Long instanceCounter = 0L;
    private Long id; //[+] Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //[.] Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //[.] Поле не может быть null
    private java.time.LocalDateTime creationDate; //[+] Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Location from; //[ ] Поле может быть null
    private Location to; //[ ] Поле может быть null
    private Long distance; //[ ] Поле не может быть null, Значение поля должно быть больше 1

    Route() {
        this.id = Route.instanceCounter++;
        this.creationDate = java.time.LocalDateTime.now();
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите name:\n>>> ");
        this.name = sc.nextLine();
        this.coordinates = new Coordinates();
    }

    @Override
    public String toString() {
        return String.format("%s, %s", this.name, this.coordinates);
    }
}