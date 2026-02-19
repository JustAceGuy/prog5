package commands.file;

import commands.Command;
import commands.Invoker;
import handlers.InputHandler;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class ExecuteScriptCommand implements Command {
    @Override
    public String desc() {
        return "execute a script from {file}";
    }

    @Override
    public void execute(String... args) {
        try {
            System.out.println(args[0]);
            System.out.println(System.getProperty("user.dir"));
            Reader in = new InputStreamReader(new FileInputStream("scripts/" + args[0]), StandardCharsets.UTF_8);
            Scanner sc = new Scanner(in);
            InputHandler.sc = sc;
            while (sc.hasNext()) {
                String[] inp = sc.nextLine().strip().split(" ");
                String commandName = inp[0];
                try {
                    Invoker.executeCommand(commandName, Arrays.copyOfRange(inp, 1, inp.length));
                } catch (NullPointerException e) {
                    System.out.println("Command not found. Try 'help'");
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        } finally {
            InputHandler.sc = new Scanner(System.in);
        }

    }
}
