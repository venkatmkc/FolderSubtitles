import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ZipChanger {
    private static final int BUFFER_SIZE = 4096;

    public void extractZipToSrt(String fileLocation) throws IOException {
        ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(fileLocation));
        ZipEntry zipEntry = zipInputStream.getNextEntry();
        while (zipEntry != null) {
            if (isSrt(zipEntry.getName())) {
                FileOutputStream fileOutputStream = new FileOutputStream(changeExtensionToSrt(fileLocation));
                int bytesRead = -1;
                byte[] buffer = new byte[BUFFER_SIZE];
                while ((bytesRead = zipInputStream.read(buffer)) != -1) {
                    fileOutputStream.write(buffer, 0, bytesRead);
                }
                break;
            }
            zipEntry = zipInputStream.getNextEntry();
        }
        deleteZipFile(fileLocation);
    }

    private void deleteZipFile(String fileLocation) {
        File file = new File(fileLocation);
        file.delete();
    }

    private boolean isSrt(String fileName) {
        return fileName.contains("srt");
    }

    private String changeExtensionToSrt(String fileLocation) {
        return fileLocation.substring(0, fileLocation.length() - 3) + "srt";
    }
}
