package commands.basic;

import commands.Command;

public class ExitCommand implements Command {
    public String desc() {return "exit without saving";}

    public void execute(String... args){
        System.exit(3);
    }
}
