package src.interfaces;

public interface Parser {
    <T> T  toData(String data);

    String toString(Object obj);
}
