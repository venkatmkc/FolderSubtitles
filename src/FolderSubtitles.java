import java.util.Scanner;

/**
 * Created by venkatmk on 12/10/15.
 */
public class FolderSubtitles {

    private ConsoleInputOutput consoleInputOutput;

    public FolderSubtitles(ConsoleInputOutput consoleInputOutput) {
        this.consoleInputOutput = consoleInputOutput;
    }

    public void start() {
        consoleInputOutput.printMessage("Username : ");
    }
}
