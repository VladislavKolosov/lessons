package smartphonefactory;

import org.junit.jupiter.api.*;
import smartphonefactory.file.OrderHistoryWriter;
import smartphonefactory.smartphone.topprice.TopUsaSmartphone;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Observer;
import static org.junit.jupiter.api.Assertions.*;

class SmartphoneFactoryTest {
    private SmartphoneFactory smartphoneFactory;
    private static File logFile;

    private final Observer observer = (((o, arg) -> {
        OrderHistoryWriter.setFilePath(logFile.toString());
        try {
            OrderHistoryWriter.writingResult((String) arg);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }));

    @BeforeEach
    public void setUp() throws IOException {
        smartphoneFactory = new SmartphoneFactory();

        smartphoneFactory.addObserver(observer);
        logFile = Files.createTempFile("test", ".txt").toFile();
    }


    @Test
    void testEmptyQueue() throws IOException {
        smartphoneFactory.addOrder(new Order());

        assertTrue(Files.exists(logFile.toPath()));
        assertEquals(0, countLines(logFile.toPath()));
    }

    @Test
    void notNullQueue() throws IOException, InterruptedException {
        smartphoneFactory.addOrder(new Order(new TopUsaSmartphone("Iphone", "16", 1024, 5.5), 2));

        Thread.sleep(3000);

        assertTrue(Files.exists(logFile.toPath()));
        assertEquals(3, countLines(logFile.toPath()), "Ожидалось 3 строки в файле");
    }

    @Test
    void impossibleCreateLogFile(){
        OrderHistoryWriter.setFilePath("invalid_path/file.txt");

        assertThrows(FileNotFoundException.class, () -> {
            OrderHistoryWriter.writingResult("Test");
        });
    }

    public static long countLines(Path filePath) throws IOException {
        try (var lines = Files.lines(filePath)) {

            return lines.count();
        }
    }
}
