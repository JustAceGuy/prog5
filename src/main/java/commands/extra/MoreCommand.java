package commands.extra;

import commands.Command;
import handlers.CollectionHandler;

public class MoreCommand implements Command {
    public String desc() {
        return "Route info with specified {id}";
    }

    public void execute(String... args) {
        long id;
        try {
            id = Long.parseLong(args[0]);
        } catch (NumberFormatException e) {
            System.out.println("Bad argument!");
            return;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Provide a Route id number!");
            return;
        }
        CollectionHandler.more(id);
    }
}
