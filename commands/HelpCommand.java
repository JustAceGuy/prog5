package commands;

import java.util.Map;

public class HelpCommand implements Command{
    public String desc() {
        return "Outputs a list of all commands";
    }

    public void execute() {
        for (Map.Entry<String, Command> c: Invoker.commands.entrySet()) {
            System.out.printf("%s - %s\n", c.getKey(), c.getValue().desc());
        }
    }
}
