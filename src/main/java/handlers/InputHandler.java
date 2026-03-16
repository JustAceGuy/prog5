package handlers;

import java.util.Scanner;

/**
 * Class that handles all the input
 */
public class InputHandler {

    public static Scanner sc = new Scanner(System.in);

    /**
     * Gives the user a [y/n] prompt. N is selected by default.
     * @param question String printed before the prompt
     * @return {@code true} if user input was 'y' or 'Y', {@code false} otherwise
     */
    public static boolean ynPrompt(String question) {
        System.out.print(question + " (y/N)\n>>> ");
        return sc.nextLine().strip().equalsIgnoreCase("y");
    }

    public static String stringInput(String varName) {
        InputValidator<String> v = new InputValidator<>();
        String ret;
        String req = v.request("String", varName);
        do {
            System.out.print(req);
            String tmp = sc.nextLine().strip();
            ret = tmp.isBlank()? null : tmp;
        } while (!v.validate(ret));
        return ret;
    }
    public static String stringInput(String varName, InputValidator<String> v) {
        String ret;
        String req = v.request("String", varName);

        do {
            System.out.print(req);
            String tmp = sc.nextLine().strip();
            ret = tmp.isBlank()? null : tmp;
        } while (!v.validate(ret));
        return ret;
    }

    public static Integer intInput(String varName) {
        InputValidator<Integer> v = new InputValidator<>();
        String req = v.request("int", varName);
        Integer n = null;
        do {
            System.out.print(req);
            String inp = sc.nextLine();
            try {
                if (!inp.isBlank()) {n = Integer.parseInt(inp);}
            } catch (NumberFormatException e) { System.out.println("Bad input :(");}
        } while (!v.validate(n));
        return n;
    }
    public static Integer intInput(String varName, InputValidator<Integer> v) {
        String req = v.request("int", varName);
        Integer n = null;
        do {
            System.out.print(req);
            String inp = sc.nextLine();
            try {
                if (!inp.isBlank()) {n = Integer.parseInt(inp);}
            } catch (NumberFormatException e) { System.out.println("Bad input :(");}
        } while (!v.validate(n));
        return n;
    }

    public static Long longInput(String varName, InputValidator<Long> v) {
        String req = v.request("long", varName);
        Long n = null;
        do {
            System.out.print(req);
            String inp = sc.nextLine();
            try {
                if (!inp.isBlank()) {n = Long.parseLong(inp);}
            } catch (NumberFormatException e) { System.out.println("Bad input :(");}
        } while (!v.validate(n));
        return n;
    }
    public static Long longInput(String varName) {
        InputValidator<Long> v = new InputValidator<>();
        String req = v.request("long", varName);
        Long n = null;
        do {
            System.out.print(req);
            String inp = sc.nextLine();
            try {
                if (!inp.isBlank()) {n = Long.parseLong(inp);}
            } catch (NumberFormatException e) { System.out.println("Bad input :(");}
        } while (!v.validate(n));
        return n;
    }

    public static Float floatInput(String varName, InputValidator<Float> v) {
        String req = v.request("float", varName);
        Float n = null;
        do {
            System.out.print(req);
            String inp = sc.nextLine();
            try {
                if (!inp.isBlank()) {n = Float.parseFloat(inp);}
            } catch (NumberFormatException e) { System.out.println("Bad input :(");}
        } while (!v.validate(n));
        return n;
    }
    public static Float floatInput(String varName) {
        InputValidator<Float> v = new InputValidator<>();
        String req = v.request("float", varName);
        Float n = null;
        do {
            System.out.print(req);
            String inp = sc.nextLine();
            try {
                if (!inp.isBlank()) {n = Float.parseFloat(inp);}
            } catch (NumberFormatException e) { System.out.println("Bad input :(");}
        } while (!v.validate(n));
        return n;
    }
}
