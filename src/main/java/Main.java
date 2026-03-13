import commands.meta.Invoker;
import handlers.FileHandler;
import handlers.InputHandler;
import handlers.OutputHandler;

import java.util.Arrays;
import java.util.NoSuchElementException;

class Main {
    public static void main(String[] args) {
        FileHandler.load();
        System.out.print(">> ");
        try {
            while (InputHandler.sc.hasNext()) {
                String[] inp = InputHandler.sc.nextLine().strip().split(" ");
                String commandName = inp[0];
                try {
                    Invoker.executeCommand(commandName, Arrays.copyOfRange(inp, 1, inp.length));
                } catch (NullPointerException e) {
                    OutputHandler.message("Command not found. Try 'help'");
                } finally {
                    System.out.print(">> ");
                }
            }
        } catch (NoSuchElementException e) {OutputHandler.message("got it!");}
    }
}