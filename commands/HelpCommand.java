package commands;

import java.awt.color.CMMException;

public class HelpCommand extends Command {
    public HelpCommand(){
        super("help");
    }
    @Override
    public void execute(String arg){
        System.out.println("list of commands...");
    }
}
