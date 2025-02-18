package smartphonefactory.file;

import java.io.*;

public class OrderHistoryWriter {
    private static String filePath = "CompleteOrder.txt";

    public static void setFilePath(String filePath) {
        OrderHistoryWriter.filePath = filePath;
    }

    public static void writingResult(String message) throws IOException {
       try(PrintWriter printWriter = new PrintWriter(new FileWriter(filePath, true))){
           printWriter.println(message);
       }

    }
}
