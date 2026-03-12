package handlers;

public class OutputHandler {
    static private boolean suppressedOutput = false;
    public static void suppress() {suppressedOutput=true;}
    public static void open() {suppressedOutput=false;}

    static private boolean suppressedRequests = false;
    public static void suppressRq() {suppressedRequests=true;}
    public static void openRq() {suppressedRequests=false;}

    public static void message(String text) {
        if (!suppressedOutput) { System.out.println(text); }
    }

    public static void message(Object o) {
        message( o.toString() );
    }

    public static void message(String text, Object... args) {
        message( String.format(text, args) );
    }

    public static void messageRequest(String text) {
        if (!suppressedOutput && !suppressedRequests) { System.out.print(text + "\n>>> "); }
    }
}
