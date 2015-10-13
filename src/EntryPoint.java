/**
 * Created by venkatmk on 12/10/15.
 */
public class EntryPoint {
    public static void main(String[] args) {
        ConsoleInputOutput consoleInputOutput = new ConsoleInputOutput();
        RequestConstructor requestConstructor = new RequestConstructor();
        User user = new User(consoleInputOutput);
        FolderSubtitles folderSubtitles = new FolderSubtitles(requestConstructor, user);
        folderSubtitles.start();
    }
}
