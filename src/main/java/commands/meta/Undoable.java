package commands.meta;

import elements.Route;

public interface Undoable {
    public void undo(Route... routes);
    public void redo(Route... routes);
}

//TODO: make this crap work w/ execute_command and update
// for update: need to add .clone()