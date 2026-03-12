package commands;

import commands.meta.Command;
import handlers.CollectionHandler;

public class ShowCommand implements Command {
    public String desc() {return "show the contents of the HashMap";}

    public void execute(String... args) {
        CollectionHandler.show();
    }

    @Override
    public String getName() {
        return "show";
    }
}
