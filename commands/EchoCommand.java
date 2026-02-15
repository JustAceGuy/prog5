package commands;

import java.util.Scanner;

public class EchoCommand implements Command{
    public String desc() {return "echo!";}

    public void execute() {
        Scanner sc = new Scanner(System.in);
        System.out.print(">>> ");
        System.out.println(sc.nextLine());
    }

}
