package stuff;

import java.util.Scanner;

public class Coordinates{
    private int x; //Максимальное значение поля: 926
    private Float y;//Значение поля должно быть больше -974, Поле не может быть null
    public Coordinates() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите x (int, <= 926):\n>>> ");
        this.x = Integer.parseInt(sc.nextLine()); //TODO: ADD LOGIC TO CHECK FOR BOUNDS
        System.out.print("Введите y (float, >-974, !null):\n>>> "); //and check for null
        this.y = Float.parseFloat(sc.nextLine());
    }

    @Override
    public String toString() {
        return String.format("x: %d y:%f", x, y);
    }
}