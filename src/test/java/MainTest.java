import org.junit.jupiter.api.*;
import java.util.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    String text = "is\n" +
            "the\n" +
            "of\n" +
            "and\n" +
            "as\n" +
            "a\n" +
            "but\n" +
            "::\n" +
            "Descent of Man\n" +
            "The Ascent of Man\n" +
            "The Old Man and The Sea\n" +
            "A Portrait of The Artist As a Young Man\n" +
            "A Man is a Man but Bubblesort IS A DOG\n";
    String text1 = "is\n" +
            "the\n" +
            "of\n" +
            "and\n" +
            "as\n" +
            "a\n" +
            "but\n";
    String text2 = "Descent of Man\n" +
            "The Ascent of Man\n" +
            "The Old Man and The Sea\n" +
            "A Portrait of The Artist As a Young Man\n" +
            "A Man is a Man but Bubblesort IS A DOG\n";

    ArrayList<String> input = new ArrayList<>();
    List<String> ignores;
    List<String> titles;

    @Test
    void testFindKey()
    {
        input.addAll(Arrays.asList(text.split("\\n")));
        ignores.addAll(Arrays.asList(text1.split("\\n")));
        titles.addAll(Arrays.asList(text2.split("\\n")));
        assertEquals(10 ,Main.findKey(ignores, titles).size());
    }

}