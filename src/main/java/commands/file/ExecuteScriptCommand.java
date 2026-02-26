package commands.file;

import commands.Command;
import commands.Invoker;
import handlers.InputHandler;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class ExecuteScriptCommand implements Command {
    static int recursionDepth = 0;

    @Override
    public String desc() {
        return "execute a script from {file}";
    }

    @Override
    public void execute(String... args) {
        Invoker.historyWritable = false;

        if (recursionDepth >= 10) {
            System.out.println("Recursion depth reached! Returning.");
            return;
        }

        recursionDepth++;

        try {
            Reader in = new InputStreamReader(new FileInputStream("scripts/" + args[0]), StandardCharsets.UTF_8);
            Scanner sc = new Scanner(in);
            InputHandler.sc = sc;
            while (sc.hasNext()) {
                String[] inp = sc.nextLine().strip().split(" ");
                String commandName = inp[0];
                try {
                    Invoker.executeCommand(commandName, Arrays.copyOfRange(inp, 1, inp.length));
                } catch (NullPointerException e) {
                    System.out.println("Command not found. Try 'help'");
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        } finally {
            InputHandler.sc = new Scanner(System.in);
            Invoker.historyWritable = true;
            recursionDepth--;
        }

    }
}
