import java.util.*;

public class Main {

    public static ArrayList<String> lines = new ArrayList<>();
    public static List<String> ignores;
    public static List<String> titles;

    public static void readInput()
    {
        Scanner console = new Scanner(System.in);
        String s;
        while((s = console.nextLine()).length()!=0)
        {
            lines.add(s);
        }
    }

    public static List<String> seperateIgnore(ArrayList<String> allLines)
    {
        int i = allLines.indexOf("::");
        return allLines.subList(0,i);
    }

    public static List<String> seperateTitle(ArrayList<String> allLines)
    {
        int i = allLines.indexOf("::");
        return allLines.subList(i+1, allLines.size());
    }

    public static void main(String[] args) {
        readInput();
        ignores = seperateIgnore(lines);
        titles = seperateTitle(lines);
    }
}