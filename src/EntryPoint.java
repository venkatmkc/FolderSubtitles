/**
 * Created by venkatmk on 12/10/15.
 */
public class EntryPoint {
    public static void main(String[] args) {
        ConsoleInputOutput consoleInputOutput = new ConsoleInputOutput();
        FolderSubtitles folderSubtitles = new FolderSubtitles(consoleInputOutput);
        folderSubtitles.start();
    }
}
