package commands;

import commands.meta.Command;
import handlers.CollectionHandler;

public class PrintAscendingCommand implements Command {
    @Override
    public String desc() {
        return "outputs a sorted list of all current items";
    }

    @Override
    public void execute(String... args) {
        CollectionHandler.print_ascending();
    }

    @Override
    public String getName() {
        return "print_ascending";
    }
}
