package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;

public class FileOperator {
    File testFile = new File("C:\\Users\\marci\\GitHub\\Laba_5\\test.json");
    public void readFile() throws FileNotFoundException {
        Scanner scanner = new Scanner(testFile);

    }
}
