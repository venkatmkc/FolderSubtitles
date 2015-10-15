import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpDownloader {
    private static final int BUFFER_SIZE = 4096;

    public void download(String fileUrl, String destination) throws IOException {
        destination += "compressed file";
        URL url = new URL(fileUrl);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        InputStream inputStream = httpURLConnection.getInputStream();
        FileOutputStream fileOutputStream = new FileOutputStream(destination);
        int bytesRead = -1;
        byte []buffer = new byte[BUFFER_SIZE];
        while((bytesRead = inputStream.read(buffer)) != -1) {
            fileOutputStream.write(buffer, 0, bytesRead);
        }
        inputStream.close();
        fileOutputStream.close();
    }
}
