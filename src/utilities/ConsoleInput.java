package src.utilities;
import java.util.Scanner;
public class ConsoleInput {
    Scanner scanner = new Scanner(System.in);
    public ConsoleInput(){}
    public String read(){
        return scanner.nextLine();
    }
}
