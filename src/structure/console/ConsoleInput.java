package src.structure.console;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Scanner;
public class ConsoleInput {
    Scanner scanner = new Scanner(System.in);
    public ConsoleInput(){}
    public String read() {
        String arg = null;
        try {
            arg = scanner.nextLine();
            if (Objects.equals(arg, "")) {
                return null;
            }
        } catch (NoSuchElementException ignored) {
            System.exit(1);
        }
        return arg;
    }
    }
