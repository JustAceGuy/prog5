package commands;

/**
 * Command interface
 */
public interface Command {
    /**
     * Execute the command
     * @param args command arguments
     */
    public void execute(String... args);

    /**
     * Get a command's description
     * @return description
     */
    public String desc();
}