package commands;

import stuff.CollectionHandler;

public class UniqueDistanceCommand implements Command{
    @Override
    public String desc() {
        return "output a list of unique distance values";
    }

    @Override
    public void execute(String... args) {
        CollectionHandler.print_unique_distance();
    }
}
