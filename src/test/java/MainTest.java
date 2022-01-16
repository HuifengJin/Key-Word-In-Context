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

    String result = "a portrait of the ARTIST as a young man\n" +
            "the ASCENT of man\n" +
            "a man is a man but BUBBLESORT is a dog\n" +
            "DESCENT of man\n" +
            "a man is a man but bubblesort is a DOG\n" +
            "descent of MAN\n" +
            "the ascent of MAN\n" +
            "the old MAN and the sea\n" +
            "a portrait of the artist as a young MAN\n" +
            "a MAN is a man but bubblesort is a dog\n" +
            "a man is a MAN but bubblesort is a dog\n" +
            "the OLD man and the sea\n" +
            "a PORTRAIT of the artist as a young man\n" +
            "the old man and the SEA\n" +
            "a portrait of the artist as a YOUNG man\n";

    ArrayList<String> input = new ArrayList<>();
    public static Map<String, ArrayList<String>> Keywords = new HashMap<String, ArrayList<String>>();
    List<String> ignores;
    List<String> titles;

    @Test
    void testMain()
    {
        input.addAll(Arrays.asList(text.split("\\n")));
        ignores = Main.seperateIgnore(input);
        titles = Main.seperateTitle(input);
        Keywords = Main.findKey(ignores, titles);
        Keywords = Main.sortKey(Keywords);
        assertEquals(result, Main.printResult(Keywords));
    }

}