import commands.Command;
import commands.Invoker;

import java.util.Scanner;

class Main {
    public static void main() {
        System.out.print(">> ");
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) { //while (true) не подходит из-за Ctrl+D
            String commandName = sc.nextLine().strip();
            try {
                Invoker.executeCommand(commandName);
            } catch (NullPointerException e) {
                System.out.println("Command not found. Try 'help'");
            } finally {
                System.out.print(">> ");
            }
        } //add end of command print somewhere
    }
}