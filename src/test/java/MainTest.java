import org.junit.jupiter.api.*;

import java.io.*;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {


    @Test
    void main() {
        String a = "hello";
        System.setIn(new ByteArrayInputStream(a.getBytes()));
        Main.main(new String[0]);
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        assertEquals(a, outContent.toString());
    }
}