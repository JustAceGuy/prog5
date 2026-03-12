package commands;

import commands.meta.Command;
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
        CollectionHandler.update_id(id);
    }

    @Override
    public void undo(Route... routes) {
        Route r = routes[0];
//        CollectionHandler.remove_by_id(r.getId());
//        CollectionHandler.add(r); shit idea
    }

    @Override
    public String getName() {
        return "update";
    }
}
