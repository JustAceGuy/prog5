package commands.info;

import commands.Command;
import handlers.CollectionHandler;

public class ShowCommand implements Command {
    public String desc() {return "show the contents of the HashMap";}

    public void execute(String... args) {
        CollectionHandler.show();
    }
}
