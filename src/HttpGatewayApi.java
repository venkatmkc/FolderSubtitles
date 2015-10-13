import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class HttpGatewayApi {
    public HttpURLConnection startConnection(String urlString) throws IOException {
        URL url = new URL(urlString);
        URLConnection urlConnection = url.openConnection();
        HttpURLConnection connection = (HttpURLConnection) urlConnection;
        connection.setDoOutput(true);
        connection.setDoInput(true);
        connection.setRequestMethod("POST");
        return connection;
    }

    public void sendRequestToServer(HttpURLConnection httpURLConnection, String request) throws IOException {
        OutputStream outputStream = httpURLConnection.getOutputStream();
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, "UTF-8");
        outputStreamWriter.write(request);
        outputStreamWriter.flush();
        outputStream.close();
    }

    public String getResponseFromServer(HttpURLConnection httpURLConnection) throws IOException {
        InputStream inputStream = httpURLConnection.getInputStream();
        int currentCharacter;
        String response = null;
        while ((currentCharacter = inputStream.read()) != -1) {
            response += (char) currentCharacter;
        }
        inputStream.close();
        return response;
    }
}
