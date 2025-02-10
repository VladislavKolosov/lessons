package smartphonefactory.file;

import java.io.*;

public class OrderHistoryWriter {
    public static final String FILEPATH = "CompleteOrder.txt";

    public static void writingResult(String message){
        try(PrintWriter printWriter = new PrintWriter(new FileWriter(FILEPATH,true))) {
            printWriter.println(message);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
