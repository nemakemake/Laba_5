package src.structure;

import src.interfaces.Client;
import src.utilities.ConsoleInput;
import src.utilities.ConsoleOutput;

public class Console implements Client {
    protected CommandManager commandManager;
    protected ConsoleInput input = new ConsoleInput();
    protected ConsoleOutput output = new ConsoleOutput();
    public Console(){
    }


    @Override
    public void start(){
        output.println("Program started. Input 'help' for list of commands");
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
        String[] fields = line.split(" ");
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
