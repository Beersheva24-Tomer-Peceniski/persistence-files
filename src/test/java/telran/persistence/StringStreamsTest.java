package telran.persistence;
import static org.junit.jupiter.api.Assertions.*;

import java.io.*;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.EnumSet;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
public class StringStreamsTest {
    static final String PRINT_STREAM_FILE = "printStreamFile.txt";
    static final String PRINT_WRITER_FILE = "printWriterFile.txt";
    @Test
    @Disabled
    void printStreamTest() throws Exception{
        PrintStream printStream = new PrintStream(PRINT_STREAM_FILE);
        printStream.println("HELLO");
        printStream.close();
    }
    @Test
    @Disabled
    void printWriterTest() throws Exception{
        PrintWriter printWriter = new PrintWriter(PRINT_WRITER_FILE);
        printWriter.println("HELLO");
        printWriter.close();
    }
    @Test
    @Disabled
    void bufferedReaderTest() throws Exception{
        BufferedReader reader = new BufferedReader(new FileReader(PRINT_WRITER_FILE));
        assertEquals("HELLO",reader.readLine());
        reader.close();
    }
    @Test
    void printingDirectoryTest() throws Exception {
        printDirectoryContent("\\\\\\\\\\",3);
    }

    void printDirectoryContent(String symbol, int levels) throws Exception {
        Path path = Paths.get("C:/Users/tomer/Documents/Contrato de estágio");
        Files.walkFileTree(path, EnumSet.noneOf(FileVisitOption.class), levels, new FileVisitorImpl(path, symbol));
    }
}
