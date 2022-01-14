import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static ArrayList<String> lines = new ArrayList<>();

    public static void readInput()
    {
        Scanner console = new Scanner(System.in);
        String s;
        while((s = console.nextLine()).length()!=0)
        {
            lines.add(s);
        }
    }

    public static void main(String[] args) {
        readInput();
    }
}