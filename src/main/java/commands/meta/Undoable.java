package commands.meta;

import elements.Route;

public interface Undoable {
    public void undo(Route... routes);
}
