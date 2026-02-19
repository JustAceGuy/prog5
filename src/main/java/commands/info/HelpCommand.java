package commands.info;

import commands.Command;
import commands.Invoker;

import java.util.Map;

public class HelpCommand implements Command {
    public String desc() {
        return "outputs a list of all commands";
    }

    public void execute(String... args) {
        for (Map.Entry<String, Command> c: Invoker.getCommands().entrySet()) {
            System.out.printf("%s - %s\n", c.getKey(), c.getValue().desc());
        }
    }
}
