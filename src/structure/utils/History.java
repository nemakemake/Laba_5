package src.structure.utils;

import src.commands.Command;

import java.util.concurrent.ConcurrentLinkedQueue;

public class History {
    public History(){}

    ConcurrentLinkedQueue<Command> history = new ConcurrentLinkedQueue<>();

    public ConcurrentLinkedQueue<Command> getHistory() {
        return history;
    }

    public void addToHistory(Command command){
        int MAX_SIZE = 14;
        if (history.size() < MAX_SIZE){
            history.add(command);
        } else {
            history.remove();
            history.add(command);
        }
    }

    @Override
    public String toString() {
        String s = "История:\n";
        Integer k = 1;
        for (Command x: history){
            s += k + " " + x.toString() + "\n";
            k++;
        }
        return s;
    }
}
