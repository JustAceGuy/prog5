package commands;
import stuff.*;

public class AddCommand implements Command {
    public String desc() {return "add an object";}

    public void execute() {
        CollectionHandler.add();
    }
}
