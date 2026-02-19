package commands.extra;

import commands.Command;

public class EchoCommand implements Command {
    public String desc() {
        return "echo";
    }

    public void execute(String... args) {
        String out = "";
        for (String a : args) {
            out += (a + " ");
        }
        System.out.println(out);
        return;
    }
}
