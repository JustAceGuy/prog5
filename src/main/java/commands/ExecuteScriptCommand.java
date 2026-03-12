package commands;

import commands.meta.Command;
import commands.meta.Invoker;
import handlers.InputHandler;
import handlers.OutputHandler;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class ExecuteScriptCommand implements Command {
    static private int recursionDepth = 0;

    @Override
    public String desc() {
        return "execute a script from {file}";
    }

    @Override
    public void execute(String... args) {
        Invoker.historyWritable = false;

        if (recursionDepth >= 100) {
            OutputHandler.message("Recursion depth reached! Returning.");
            recursionDepth = 0;
            return;
        }

        recursionDepth++;

        try {
            Reader in = new InputStreamReader(new FileInputStream("scripts/" + args[0]), StandardCharsets.UTF_8);
            InputHandler.sc = new Scanner(in);
            while (InputHandler.sc.hasNext()) {
                String[] inp = InputHandler.sc.nextLine().strip().split(" ");
                String commandName = inp[0];
                try {
                    Invoker.executeCommand(commandName, Arrays.copyOfRange(inp, 1, inp.length));
                } catch (NullPointerException e) {
                    OutputHandler.message("Command not found. Try 'help'");
                }
            }
        } catch (FileNotFoundException e) {
            OutputHandler.message("File not found.");
        } finally {
            InputHandler.sc = new Scanner(System.in);
            Invoker.historyWritable = true;
            recursionDepth--;
        }
    }

    @Override
    public String getName() {
        return "execute_script";
    }
}
