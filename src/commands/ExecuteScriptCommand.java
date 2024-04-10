package src.commands;

import src.structure.logic.CommandManager;
import src.structure.console.Console;
import src.structure.console.LogicTransfer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class ExecuteScriptCommand extends Command{
    Deque<File> fileStack = new ArrayDeque<>();
    Console console;
    CommandManager commandManager;
    public ExecuteScriptCommand(LogicTransfer logicTransfer, CommandManager commandManager, Console console){
        super("execute_script", logicTransfer);
        this.commandManager = commandManager;
        this.console = console;
    }

    @Override
    public void execute(String arg) {
        try {
            File file = new File(arg);
            if (fileStack.contains(file)){
                logicTransfer.sendOutputln("File recursion exception");
                return;
            }
            Scanner scanner = new Scanner(file);
            fileStack.add(file);
            while (scanner.hasNext()){
                console.operateWithScript(scanner.nextLine());
            }


        } catch (FileNotFoundException e){
            logicTransfer.sendOutputln("Cannot find a file");
        }
    }
}
