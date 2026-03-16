package commands;

import commands.meta.Command;
import commands.meta.Invoker;
import commands.meta.Undoable;
import elements.Route;
import handlers.CollectionHandler;
import handlers.InputHandler;
import handlers.OutputHandler;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class ExecuteScriptCommand implements Command, Undoable {
    static private int recursionDepth = 0;

    @Override
    public String desc() {
        return "execute a script from {file}";
    }

    @Override
    public void execute(String... args) {
        Invoker.historyWritable = false;
        Route[] snapshot = CollectionHandler.getRoutes().toArray(new Route[0]);

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
            Invoker.addToRouteHistory(snapshot);
        } catch (FileNotFoundException e) {
            OutputHandler.message("File not found.");
        } finally {
            InputHandler.sc = new Scanner(System.in);
            Invoker.historyWritable = true;
            recursionDepth--;
        }
    }

    @Override
    public void undo(Route... routes) {
        HashSet<Route> hashRoutes = new HashSet<>(Arrays.asList(routes));
        CollectionHandler.setRoutes(hashRoutes);
    }

    @Override
    public void redo(Route[] routes) {
        execute(Invoker.getHistory().peek().args());
    }

    @Override
    public String getName() {
        return "execute_script";
    }
}
