package commands;

import commands.meta.Command;
import commands.meta.Invoker;

public class UndoCommand implements Command {
    @Override
    public String desc() {
        return "undo ";
    }

    @Override
    public void execute(String... args) {
        Invoker.undoHistory();
    }

    @Override
    public String getName() {
        return "undo";
    }
}
