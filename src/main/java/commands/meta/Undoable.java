package commands.meta;

import elements.Route;

public interface Undoable {
    public void undo(Route... routes);
    public void redo(Route... routes);
}
