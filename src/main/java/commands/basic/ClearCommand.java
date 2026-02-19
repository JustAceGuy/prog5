package commands.basic;

import commands.Command;
import handlers.CollectionHandler;

public class ClearCommand implements Command {
    @Override
    public String desc() {
        return "clear all data";
    }

    @Override
    public void execute(String... args) {
        CollectionHandler.clear();
    }
}
