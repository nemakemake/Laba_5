import commands.CommandManager;

import java.util.Scanner;

public class Console {
    Scanner scanner = new Scanner(System.in);
    CommandManager commandManager = new CommandManager();
    public Console(){
    }

    public void start(){
        System.out.println("Program started. Input 'help' for list of commands");
        while(true){
            operateWithInput();
        }
    }
    public void operateWithInput(){
        System.out.print("-> ");
        String input = scanner.nextLine();
        String name = "";
        String arg = "";
        String[] fields = input.split(" ");
        if (fields.length >= 1) name = fields[0];
        if (fields.length >= 2) arg = fields[1];
        commandManager.jobFinder(name, arg);
    }
}
