package commands;

import commands.meta.Command;
import commands.meta.Invoker;
import handlers.OutputHandler;

import java.util.Map;

public class HelpCommand implements Command {
    public String desc() {
        return "outputs a list of all commands";
    }

    public void execute(String... args) {
        for (Map.Entry<String, Command> c: Invoker.getCommands().entrySet()) {
            OutputHandler.message("%s - %s", c.getKey(), c.getValue().desc());
        }
    }

    @Override
    public String getName() {
        return "help";
    }
}
