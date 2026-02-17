package commands;

public class HistoryCommand implements Command{
    @Override
    public String desc() {
        return "show last 15 commands executed";
    }

    @Override
    public void execute(String... args) {
        for (String s : Invoker.history) {
            System.out.println(s);
        }
    }
}
