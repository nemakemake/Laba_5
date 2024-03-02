package src.structure;

import src.interfaces.Client;
import src.utilities.ConsoleInput;
import src.utilities.ConsoleOutput;

public class Console implements Client {
    CommandManager commandManager;
    ConsoleInput input;
    ConsoleOutput output;
    public Console(){
        this.input = new ConsoleInput();
        this.output = new ConsoleOutput();
        this.commandManager = new CommandManager(output, input);
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
}
