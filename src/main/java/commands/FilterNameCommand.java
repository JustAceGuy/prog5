package commands;

import commands.meta.Command;
import handlers.CollectionHandler;
import handlers.OutputHandler;

public class FilterNameCommand implements Command {
    @Override
    public String desc() {
        return "output all Routes w/ names containing {pattern}";
    }

    @Override
    public void execute(String... args) {
        try {
            CollectionHandler.filter_contains_name(args[0]);
        } catch (ArrayIndexOutOfBoundsException e) {
            OutputHandler.message("No {pattern} provided!");
        }

    }

    @Override
    public String getName() {
        return "filter_contains_name";
    }
}
