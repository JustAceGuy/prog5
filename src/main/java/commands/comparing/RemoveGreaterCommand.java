package commands.comparing;

import commands.Command;
import elements.Route;
import handlers.CollectionHandler;

public class RemoveGreaterCommand implements Command {
    @Override
    public String desc() {
        return "remove all elements greater than input";
    }

    @Override
    public void execute(String... args) {
        CollectionHandler.remove_greater(new Route());
    }
}
