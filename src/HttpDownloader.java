import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpDownloader {
    private static final int BUFFER_SIZE = 4096;

    public String download(String fileUrl, String destination) throws IOException {
        destination = changeExtensionToZip(destination);
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
        return  destination;
    }

    private String changeExtensionToZip(String destination) {
        destination = destination.substring(0, destination.length() - 3) + "zip";
        return destination;
    }
}
