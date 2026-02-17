import commands.Invoker;
import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        System.out.print(">> ");
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) { //while (true) не подходит из-за Ctrl+D
            String[] inp = sc.nextLine().strip().split(" ");
            String commandName = inp[0];
            try {
                Invoker.executeCommand(commandName, Arrays.copyOfRange(inp, 1, inp.length));
            } catch (NullPointerException e) {
                System.out.println("Command not found. Try 'help'");
            } finally {
                System.out.print(">> ");
            }
        }
    }
}