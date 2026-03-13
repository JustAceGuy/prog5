package commands;

import commands.meta.Command;
import commands.meta.Invoker;

public class RedoCommand implements Command {
    @Override
    public String desc() {
        return "redo the last undone command";
    }

    @Override
    public void execute(String... args) {
        Invoker.redo();
    }

    @Override
    public String getName() {
        return "redo";
    }
}
