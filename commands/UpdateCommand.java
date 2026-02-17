package commands;

import stuff.CollectionHandler;

public class UpdateCommand implements Command{
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
            System.out.println("Bad argument!");
            return;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Provide a Route id number!");
            return;
        }
        CollectionHandler.update_id(id);
    }
}
