package commands.meta;

import commands.*;
import elements.Route;
import handlers.OutputHandler;

import java.util.ArrayDeque;
import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.Stack;

/**
 * Class responsible for executing commands
 */
public class Invoker {
    static HashMap<String, Command> commands = new HashMap<>();
    static ArrayDeque<String> history_old = new ArrayDeque<>();

    static Stack<HistoryEntry> commandHistory = new Stack<>();
    static Stack<Route[]> routeHistory = new Stack<>();
    static Stack<HistoryEntry> commandUndone = new Stack<>();
    static Stack<Route[]> routeUndone = new Stack<>();

    public static boolean historyWritable = true;

    static { //TODO: get command name from the command
        // Meta
        commands.put("help", new HelpCommand());
        commands.put("exit", new ExitCommand());
        commands.put("history", new HistoryCommand());

        // Basic collection manip
        commands.put("show", new ShowCommand());
        commands.put("add", new AddCommand());
        commands.put("info", new InfoCommand());
        commands.put("remove", new RemoveCommand());
        commands.put("clear", new ClearCommand());
        commands.put("update", new UpdateCommand());


        // Cyclical collection manip
        commands.put("add_if_min", new AddMinCommand());
        commands.put("remove_greater", new RemoveGreaterCommand());
        commands.put("filter_contains_name", new FilterNameCommand());
        commands.put("print_ascending", new PrintAscendingCommand());
        commands.put("print_unique_distance", new UniqueDistanceCommand());

        // File stuff
        commands.put("save", new SaveCommand());
        commands.put("execute_script", new ExecuteScriptCommand());

        // Unnecessary/debug
        commands.put("more", new MoreCommand());
        commands.put("псж", new PSZHCommand());
        commands.put("echo", new EchoCommand());
        commands.put("load", new LoadCommand());

        commands.put("undo", new UndoCommand());
        commands.put("redo", new RedoCommand());

    }

    /**
     * Execute a specified command
     * @param name String name of the command
     * @param args command arguments
     */
    public static void executeCommand(String name, String... args) {
        Command c = commands.get(name);
        c.execute(args);
        addToCommandHistory(c, args);
        if ( !(c instanceof UndoCommand || c instanceof RedoCommand) ) {
            commandUndone.clear();
            routeUndone.clear();
        }

    }

    /**
     * Write a command to history.
     * @param name of the command to add
     */
    private static void addToHistory_old(String name) {
        if (!historyWritable) {return;} // stops execute_script commands from being added

        history_old.add(name);
        if (history_old.size() > 15) {
            history_old.removeFirst();
        }
    }

    private static void addToCommandHistory(Command c, String... args) {
        if ( !(c instanceof UndoCommand || c instanceof RedoCommand) ) {
            commandHistory.push( new HistoryEntry(c, args));
        }
    }

    public static void addToRouteHistory(Route... r) {
        routeHistory.push(r);
    }

    public static void undo() {
        try {
            HistoryEntry h = commandHistory.pop();
            Command c = h.command();
            commandUndone.push(h);
            if (c instanceof Undoable) {
                routeUndone.push(routeHistory.pop());
                ((Undoable) c).undo(routeUndone.peek());
            }
            OutputHandler.message("- undone '" + c.getName() + "'");
        } catch (EmptyStackException e) {
            OutputHandler.message("Nothing to undo. \nTry doing something for once you lazy bum.");
        }
    }

    public static void redo() {
        try {
            HistoryEntry h = commandUndone.pop();
            Command c = h.command();
            commandHistory.push(h);
            if (c instanceof Undoable) {
                routeHistory.push(routeUndone.pop());
                ((Undoable) c).redo(routeHistory.peek());
            } else {
                c.execute(h.args());
            }
            OutputHandler.message("- redone '" + c.getName() + "'");
        } catch (EmptyStackException e) {
            OutputHandler.message("Nothing to redo. \nTry doing something for once you lazy bum.");
        }
    }

    public static Stack<HistoryEntry> getHistory() {
        return commandHistory;
    }

    /**
     * Returns all commands
     * @return the HashMap of command name-object pairs
     */
    public static HashMap<String, Command> getCommands() {
        return commands;
    }
}