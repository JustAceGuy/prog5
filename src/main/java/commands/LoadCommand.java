package commands;

import commands.meta.Command;
import handlers.FileHandler;

public class LoadCommand implements Command {
    @Override
    public String desc() {
        return "load collection from the save file";
    }

    @Override
    public void execute(String... args) {
        FileHandler.load();
    }

    @Override
    public String getName() {
        return "load";
    }
}
