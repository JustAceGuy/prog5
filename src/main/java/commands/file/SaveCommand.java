package commands.file;
import commands.Command;
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
}
