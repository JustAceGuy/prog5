package commands;

import stuff.CollectionHandler;

public class FilterNameCommand implements Command{
    @Override
    public String desc() {
        return "output all Routes w/ names containing {pattern}";
    }

    @Override
    public void execute(String... args) {
        try {
            CollectionHandler.filter_contains_name(args[0]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("No {pattern} provided!");
        }

    }
}
