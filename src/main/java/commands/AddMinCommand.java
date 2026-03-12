package commands;

import commands.meta.Command;
import commands.meta.Undoable;
import elements.Route;
import handlers.CollectionHandler;

public class AddMinCommand implements Command, Undoable {
    @Override
    public String desc() {
        return "add a Route if it's less than all the other Routes";
    }

    @Override
    public void execute(String... args) {
        CollectionHandler.add_if_min(new Route());
    }

    @Override
    public void undo(Route... routes) {
        if (routes.length == 1) {
            CollectionHandler.remove_by_id(routes[0].getId());
        }
    }

    @Override
    public String getName() {
        return "add_if_min";
    }
}
