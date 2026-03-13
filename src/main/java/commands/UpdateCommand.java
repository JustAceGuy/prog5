package commands;

import commands.meta.Command;
import commands.meta.Invoker;
import commands.meta.Undoable;
import elements.Route;
import handlers.CollectionHandler;
import handlers.OutputHandler;

public class UpdateCommand implements Command, Undoable {
    @Override
    public String desc() {
        return "update an element with {id}";
    }

    @Override
    public void execute(String... args) {
        long id;
        try {
            id = Long.parseLong(args[0]);
        } catch (NumberFormatException e) {
            OutputHandler.message("Bad argument!");
            return;
        } catch (ArrayIndexOutOfBoundsException e) {
            OutputHandler.message("Provide a Route id number!");
            return;
        }
        Invoker.addToRouteHistory(CollectionHandler.update_id(id));
    }

    @Override
    public void undo(Route... routes) {
        Route oldRoute = routes[0];
         OutputHandler.suppress();
        CollectionHandler.remove_by_id(oldRoute.getId());
        CollectionHandler.add(oldRoute);
         OutputHandler.open();
    }

    @Override
    public void redo(Route... routes) {
        Route newRoute = routes[1];
         OutputHandler.suppress();
        CollectionHandler.remove_by_id(newRoute.getId());
        CollectionHandler.add(newRoute);
         OutputHandler.open();
    }

    @Override
    public String getName() {
        return "update";
    }
}
