package commands;

import commands.meta.Command;
import commands.meta.Invoker;
import commands.meta.Undoable;
import elements.Route;
import handlers.CollectionHandler;

public class RemoveGreaterCommand implements Command, Undoable {
    @Override
    public String desc() {
        return "remove all elements greater than input";
    }

    @Override
    public void execute(String... args) {
        Route[] r = CollectionHandler.remove_greater(new Route());
        Invoker.addToRouteHistory(r);
    }

    @Override
    public void undo(Route... routes) {
        CollectionHandler.add(routes);
    }

    @Override
    public void redo(Route... routes) {
        if (routes.length == 1) {
            CollectionHandler.remove_greater(routes[0]);
        }
    }

    @Override
    public String getName() {
        return "remove_greater";
    }
}
