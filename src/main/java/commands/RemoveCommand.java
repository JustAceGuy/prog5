package commands;

import commands.meta.Command;
import commands.meta.Undoable;
import elements.Route;
import handlers.CollectionHandler;
import handlers.OutputHandler;

public class RemoveCommand implements Command, Undoable {
    public String desc() { return "removes Route with specified {id}"; }

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
        CollectionHandler.remove_by_id(id);
    }

    @Override
    public void undo(Route... routes) {
        if (routes.length == 1) {
            CollectionHandler.add(routes[0]);
            OutputHandler.message("");
        } else { OutputHandler.message("rm.undo failed, bad argument");}
    }

    @Override
    public String getName() {
        return "remove";
    }
}
