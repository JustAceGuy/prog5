package commands.basic;

import commands.Command;
import handlers.CollectionHandler;

public class RemoveCommand implements Command {
    public String desc() { return "removes Route with specified {id}"; }

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
        CollectionHandler.remove_by_id(id);
    }
}
