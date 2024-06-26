package src.structure.console;

import src.interfaces.Client;
import src.structure.logic.CommandManager;

public class Console implements Client {
    protected CommandManager commandManager;
    protected final ConsoleInput input = new ConsoleInput();
    protected final ConsoleOutput output = new ConsoleOutput();
    public Console(){
    }


    @Override
    public void start(){
        output.println("Starting... \nInput 'help' for list of commands");
        while(true){
            operateWithInput();
        }
    }

    @Override
    public void operateWithInput(){
        output.print(">> ");
        String line = input.read();
        String name = "";
        String arg = "";
        if (line == null){
            commandManager.jobFinder(null, "");
        } else {
        String[] fields = line.split(" ", 2);
        if (fields.length >= 1) name = fields[0];
        if (fields.length >= 2) arg = fields[1];
        commandManager.jobFinder(name, arg);
    }
    }

    public void operateWithScript(String line){
        String name = "";
        String arg = "";
        String[] fields = line.split(" ",2 );
        if (fields.length >= 1) name = fields[0];
        if (fields.length >= 2) arg = fields[1];
        commandManager.jobFinder(name, arg);
    }

    public ConsoleInput getInput() {
        return input;
    }

    public ConsoleOutput getOutput() {
        return output;
    }

    public void setCommandManager(CommandManager commandManager) {
        this.commandManager = commandManager;
    }
}
