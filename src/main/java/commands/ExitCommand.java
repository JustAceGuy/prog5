package commands;

import commands.meta.Command;

public class ExitCommand implements Command {
    public String desc() {return "exit without saving";}

    public void execute(String... args){
        System.exit(3);
    }

    @Override
    public String getName() {
        return "exit";
    }
}
