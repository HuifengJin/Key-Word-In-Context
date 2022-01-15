import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Main {

    public static ArrayList<String> lines = new ArrayList<>();
    public static Map<String, ArrayList<String>> Keywords = new HashMap<String, ArrayList<String>>();

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

    public static Map<String, ArrayList<String>> findKey(List<String> ign, List<String> tit)
    {
        for (String t: tit) {
            t = t.toLowerCase();
            ArrayList<String> words = new ArrayList<>();
            words.addAll(Arrays.asList(t.split("\\s+")));
            int count = 0;
            for(String w: words)
            {
                ArrayList<String> new_words = new ArrayList<>(words);
                new_words.set(count, w.toUpperCase());
                String new_t = String.join(" ", new_words);
                if(!ign.contains(w))
                {
                    if(Keywords.containsKey(w))
                    {
                        Keywords.get(w).add(new_t);
                    }
                    else
                    {
                        Keywords.put(w, new ArrayList<String>(Arrays.asList(new_t)));
                    }
                    w = w.toLowerCase();
                }
                count++;
            }
        }

        return Keywords;
    }

    public static Map<String, ArrayList<String>> sortKey(Map<String, ArrayList<String>> KeyMap)
    {
        return new TreeMap<String, ArrayList<String>>(KeyMap);
    }

    public static void printResult(Map<String, ArrayList<String>> KeyMap)
    {
        for (String key : KeyMap.keySet()) {
            for (String title: KeyMap.get(key)) {
                System.out.println(title);
            }
        }
    }

    public static void main(String[] args) {

        List<String> ignores;
        List<String> titles;

        readInput();
        ignores = seperateIgnore(lines);
        titles = seperateTitle(lines);
        Keywords = findKey(ignores, titles);
        Keywords = sortKey(Keywords);
        printResult(Keywords);
    }
}