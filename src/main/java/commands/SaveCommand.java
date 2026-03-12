package commands;
import commands.meta.Command;
import handlers.CollectionHandler;
import handlers.FileHandler;

public class SaveCommand implements Command {
    @Override
    public String desc() {
        return "saves collection to a file";
    }

    @Override
    public void execute(String... args) {
        FileHandler.save(CollectionHandler.getRoutes());
    }

    @Override
    public String getName() {
        return "save";
    }
}
