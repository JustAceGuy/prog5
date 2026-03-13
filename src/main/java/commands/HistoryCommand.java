package commands;

import commands.meta.Command;
import commands.meta.Invoker;
import handlers.OutputHandler;

public class HistoryCommand implements Command {
    @Override
    public String desc() {
        return "show last 15 commands executed";
    }

    @Override
    public void execute(String... args) {
        for (Command s : Invoker.getHistory()) {
            OutputHandler.message(s);
        }
    }

    @Override
    public String getName() {
        return "history";
    }
}
