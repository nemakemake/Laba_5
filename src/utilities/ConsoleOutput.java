package src.utilities;

import src.interfaces.Output;

public class ConsoleOutput implements Output {
    public ConsoleOutput(){}
    @Override
    public void print(String arg){
        System.out.print(arg);
    }

    @Override
    public void println(String arg){
        System.out.println(arg);
    }
}
