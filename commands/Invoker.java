package commands;
import java.util.HashMap;

public class Invoker {
    static Command command;
    static HashMap<String, Command> commands = new HashMap<>();
    //static Command[] history = new Command[15]; //find a better data struct for history

    static {
        commands.put("help", new HelpCommand());
        commands.put("exit", new ExitCommand());
        commands.put("echo", new EchoCommand());
        commands.put("add", new AddCommand());
        commands.put("show", new ShowCommand());
    }

    public static void executeCommand(String name) {
        commands.get(name).execute();
    }

}