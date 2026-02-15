package commands;

import stuff.CollectionHandler;

public class ShowCommand implements Command{
    public String desc() {return "show the contents of the HashMap";}

    @Override
    public void execute() {
        CollectionHandler.show();
    }
}
