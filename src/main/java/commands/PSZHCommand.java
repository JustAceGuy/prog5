package commands;

import commands.meta.Command;

/**
 * ПСЖ
 */
public class PSZHCommand implements Command {
    @Override
    public String desc() {
        return "ПСЖ";
    }

    /**
     * ПСЖ
     */
    @Override
    public void execute(String... args) {
        System.out.println(
                """
                        ##########      ########    ##  ##  ##
                        ##########     #########    ##  ##  ##
                        ##      ##    ####           ## ## ##\s
                        ##      ##    ###             ###### \s
                        ##      ##    ###            ########\s
                        ##      ##    ####           ## ## ##\s
                        ##      ##     #########    ### ## ###
                        ##      ##       #######    ##  ##  ##""");
    }

    @Override
    public String getName() {
        return "псж";
    }


}
