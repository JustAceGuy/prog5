package commands;

public class ExitCommand implements Command {
    public String desc() {return "exit without saving";}

    public void execute(){
        System.exit(3);
    }
}
