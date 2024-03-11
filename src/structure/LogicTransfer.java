package src.structure;

public class LogicTransfer {
    private Console console;
    private CommandManager commandManager;
    public LogicTransfer(){
    }

    public void setBlocks(Console console, CommandManager commandManager) {
        this.console = console;
        this.commandManager = commandManager;
    }



    public void sendOutput(String arg){
        console.getOutput().print(arg);
    }
    public void sendOutputln(String arg){
        console.getOutput().println(arg);
    }

    public String requestInput(){
        return console.getInput().read();
    }
}
