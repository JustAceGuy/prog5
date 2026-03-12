package commands;

import commands.meta.Command;
import handlers.OutputHandler;

public class EchoCommand implements Command {
    public String desc() {
        return "echo";
    }

    public void execute(String... args) {
        StringBuilder out = new StringBuilder();
        for (String a : args) {
            out.append(a).append(" ");
        }
        OutputHandler.message(out);
    }

    @Override
    public String getName() {
        return "echo";
    }
}
