package commands.file;
import commands.Command;
import handlers.CollectionHandler;
import handlers.FileHandler;

public class LoadCommand implements Command {
    @Override
    public String desc() {
        return "load collection from the save file";
    }

    @Override
    public void execute(String... args) {
        FileHandler.load();
    }
}
