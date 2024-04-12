package src.structure.utils;

import src.commands.Command;

import java.util.concurrent.ConcurrentLinkedQueue;

public class History {
    public History(){}

    final ConcurrentLinkedQueue<Command> history = new ConcurrentLinkedQueue<>();

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
        StringBuilder s = new StringBuilder("История:\n");
        Integer k = 1;
        for (Command x: history){
            s.append(k).append(" ").append(x.toString()).append("\n");
            k++;
        }
        return s.toString();
    }
}
