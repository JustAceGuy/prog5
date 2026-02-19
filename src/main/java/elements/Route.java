package elements;

import com.fasterxml.jackson.annotation.JacksonInject;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import handlers.InputHandler;

public class Route implements Comparable<Route> {

    public static boolean isLoading = false;

    private static Long instanceCounter = 0L;
    private Long id; //[+] Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name;
    //[+] Поле не может быть null, Строка не может быть пустой
    @JacksonXmlProperty(isAttribute = true)
    private Coordinates coordinates; //[+] Поле не может быть null
    private java.time.LocalDateTime creationDate; //[+] Поле не может быть null, Значение этого поля должно генерироваться автоматически
    @JacksonXmlProperty(isAttribute = true)
    private Location from; //[+] Поле может быть null
    @JacksonXmlProperty(isAttribute = true)
    private Location to; //[+] Поле может быть null
    private Long distance; //[+] Поле не может быть null, Значение поля должно быть больше 1


    public Route() {
        if (isLoading) {return;}

        this.id = Route.instanceCounter++;
        this.creationDate = java.time.LocalDateTime.now();

        this.name = InputHandler.stringInput("Route name", false);

        System.out.println("Coordinates:");
        this.coordinates = new Coordinates();

        if (InputHandler.ynPrompt("Add 'from' Location?")) { this.from = new Location(); }
        if (InputHandler.ynPrompt("Add 'to' Location?")) { this.from = new Location(); }

        this.distance = InputHandler.longInput("distance", false, null, null);


        System.out.printf("-- New Route '%s' created!\n", this.name);
    }


    public Long getId() {
        return id;
    }

    public Long getDistance() {
        return distance;
    }

    public String getName() {
        return name;
    }

    public void update() {
        System.out.println(
                "Which field to update?\n" +
                        "1. name\n" +
                        "2. Coordinates\n" +
                        "3. (Location) from\n" +
                        "4. (Location) to\n" +
                        "5. distance");
        int n = InputHandler.intInput("number", false, 6, 0);
        switch (n) {
            case 1 -> this.name = InputHandler.stringInput("name", false);
            case 2 -> this.coordinates = new Coordinates();
            case 3 -> this.from = new Location();
            case 4 -> this.to = new Location();
            case 5 -> this.distance = InputHandler.longInput("distance", false, null, null);
        }
        System.out.println("Updated!");
    }


    @Override
    public int compareTo(Route o) {
        return Long.compare(this.distance, o.distance);
        //can't really do this via IDs
        //because add_if_min becomes pointless
        //(well technically I could but it would require making routes with HIGHER ids less)
    }

    @Override
    public String toString() {
        return String.format("%s: %s", this.id, this.name);
    }

    public String more() {
        return String.format("id%s - '%s'\n Coordinates: %s\n from: %s\n to: %s\n distance:%s",
                this.id, this.name,
                this.coordinates,
                this.from,
                this.to,
                this.distance);
    }


}