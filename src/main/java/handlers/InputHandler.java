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

    /**
     * Prompts the user to enter a String
     * @param varName name of String to input
     * @param isNullable whether the input can be {@code null}
     * @return String inputted by user
     * or {@code null}, if {@code isNullable} and user input was empty
     */
    public static String stringInput(String varName, boolean isNullable) {
        String ret;

        System.out.print("Input " + varName + "\n>>> ");

        while (true) {
            ret = sc.nextLine().strip();
            if (ret.isBlank()) {
                if (isNullable) {return null;}
                else {System.out.println(varName + " cannot be empty!");}
            } else {
                return ret;
            }
        }
    }

    /**
     * Prompts the user to enter a Long
     * @param varName name of variable to print
     * @param isNullable whether the input can be {@code null}
     * @param upperBound upper bound of input ({@code null} to ignore)
     * @param lowerBound lower bound of input ({@code null} to ignore)
     * @return Long inputted by user
     * or {@code null}, if {@code isNullable} and user input was empty
     */
    public static Long longInput(String varName, boolean isNullable, Long upperBound, Long lowerBound) {
        boolean badInput = true;
        long ret = 0L;

        String request = "Input " + varName;
        request += ": [long ";
        if (!isNullable || upperBound != null || lowerBound != null) {
            if (!isNullable) { request += "| Cannot be null "; }
            if (lowerBound != null) { request += "| >" + lowerBound.toString(); }
            if (upperBound != null) { request += "| <" + upperBound.toString(); }
        }
        request = request.stripTrailing() + "]\n>>> ";

        while (badInput) {
            try {
                System.out.print(request);
                String temp = sc.nextLine();
                if (temp.isBlank() && isNullable) {return null;}
                ret = Long.parseLong(temp);
                if (upperBound != null && ret >= upperBound) { System.out.println("Input out of range :("); }
                else if (lowerBound != null && ret <= lowerBound) { System.out.println("Input out of range :("); }
                else { badInput = false; }
            } catch (NumberFormatException e) {
                System.out.println("Bad input :(");
            }
        }
        return ret;
    }

    /**
     * Prompts the user to enter an Integer
     * @param varName name of variable to print
     * @param isNullable whether the input can be {@code null}
     * @param upperBound upper bound of input ({@code null} to ignore)
     * @param lowerBound lower bound of input ({@code null} to ignore)
     * @return Integer inputted by user
     * or {@code null}, if {@code isNullable} and user input was empty
     */
    public static Integer intInput(String varName, boolean isNullable, Integer upperBound, Integer lowerBound) {
        boolean badInput = true;
        int ret = 0;

        String request = "Input " + varName;
        request += ": [int ";
        if (!isNullable || upperBound != null || lowerBound != null) {
            if (!isNullable) { request += "| Cannot be null "; }
            if (lowerBound != null) { request += "| >" + lowerBound.toString() + " "; }
            if (upperBound != null) { request += "| <" + upperBound.toString() + " "; }
        }
        request = request.stripTrailing() + "]\n>>> ";

        while (badInput) {
            try {
                System.out.print(request);
                String temp = sc.nextLine();
                if (temp.isBlank() && isNullable) {return null;}
                ret = Integer.parseInt(temp);
                if (upperBound != null && ret >= upperBound) { System.out.println("Input out of range :("); }
                else if (lowerBound != null && ret <= lowerBound) { System.out.println("Input out of range :("); }
                else { badInput = false; }
            } catch (NumberFormatException e) {
                System.out.println("Bad input :(");
            }
        }
        return ret;
    }

    /**
     * Prompts the user to enter a Float
     * @param varName name of variable to print
     * @param isNullable whether the input can be {@code null}
     * @param upperBound upper bound of input ({@code null} to ignore)
     * @param lowerBound lower bound of input ({@code null} to ignore)
     * @return Float inputted by user
     * or {@code null}, if {@code isNullable} and user input was empty
     */
    public static Float floatInput(String varName, boolean isNullable, Float upperBound, Float lowerBound) {
        boolean badInput = true;
        float ret = 0f;

        String request = "Input " + varName;
        request += ": [float ";
        if (!isNullable || upperBound != null || lowerBound != null) {
            if (!isNullable) { request += "| Cannot be null "; }
            if (lowerBound != null) { request += "| >" + lowerBound.toString(); }
            if (upperBound != null) { request += "| <" + upperBound.toString(); }
        }
        request = request.stripTrailing() + "]\n>>> ";

        while (badInput) {
            try {
                System.out.print(request);
                String temp = sc.nextLine();
                if (temp.isBlank() && isNullable) {return null;}
                ret = Float.parseFloat(temp);
                if (upperBound != null && ret >= upperBound) { System.out.println("Input out of range :("); }
                else if (lowerBound != null && ret <= lowerBound) { System.out.println("Input out of range :("); }
                else { badInput = false; }
            } catch (NumberFormatException e) {
                System.out.println("Bad input :(");
            }
        }
        return ret;
    }
}
