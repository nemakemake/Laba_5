package src.structure.console;


import src.structure.logic.CommandManager;

public class LogicTransfer {
    private Console console;

    public LogicTransfer(){
    }

    public void setBlocks(Console console) {
        this.console = console;
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

    public String requestInput(String arg){
        sendOutputln(arg);
        return console.getInput().read();
    }
}
