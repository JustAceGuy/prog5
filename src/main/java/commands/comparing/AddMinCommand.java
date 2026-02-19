package commands.comparing;

import commands.Command;
import elements.Route;
import handlers.CollectionHandler;

public class AddMinCommand implements Command {
    @Override
    public String desc() {
        return "add a Route if it's less than all the other Routes";
    }

    @Override
    public void execute(String... args) {
        CollectionHandler.add_if_min(new Route());
    }
}
