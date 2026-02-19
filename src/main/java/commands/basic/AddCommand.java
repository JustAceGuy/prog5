package commands.basic;
import commands.Command;
import handlers.CollectionHandler;

public class AddCommand implements Command {
    public String desc() {return "add an object";}
    public void execute(String... args) {
        CollectionHandler.add();
    }
}
