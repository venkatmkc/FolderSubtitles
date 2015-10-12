import java.io.InputStream;
import java.util.Scanner;

public class ConsoleInputOutput {
    public static InputStream inputStream = System.in;

    public String getInputFromUser() {
        Scanner input = new Scanner(inputStream);
        return input.next();
    }

    public void printMessage(String message) {
        System.out.println(message);
    }
}
