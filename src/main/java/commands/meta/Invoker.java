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

    static Stack<Command> commandHistory = new Stack<>();
    static Stack<Route[]> routeHistory = new Stack<>();

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

    }

    /**
     * Execute a specified command
     * @param name String name of the command
     * @param args command arguments
     */
    public static void executeCommand(String name, String... args) {
        Command c = commands.get(name);
        c.execute(args);
        addToCommandHistory(c);
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

    private static void addToCommandHistory(Command c) {
        if (!(c instanceof UndoCommand)) {
            commandHistory.push(c);
        }
    }

    public static void addToRouteHistory(Route... r) {
        routeHistory.push(r);
    }

    public static void undoHistory() {
        try {
        Command c = commandHistory.pop();
        if (c instanceof Undoable) {
            ((Undoable) c).undo(routeHistory.pop());
            }
        OutputHandler.message("- undone '" + c.getName() + "'");
        } catch (EmptyStackException e) {
            OutputHandler.message("Nothing to undo. \nTry doing something for once you lazy bum.");
        }
    }

    /**
     * Returns history
     * @return a list of last 15 commands
     */
    public static ArrayDeque<String> getHistory_old() {
        return history_old;
    }

    public static Stack<Command> getHistory() {
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