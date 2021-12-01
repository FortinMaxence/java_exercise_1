import java.util.Scanner;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.TreeMap;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Freq implements Command{
    @Override
    public String name() {
        return "freq";
    }

    @Override
    public boolean run(Scanner scanner) {
        System.out.println("Indiquez le chemin du fichier a analyser.");
        String path = scanner.nextLine();
        Path filePath = Paths.get(path);
        try {
            String content = Files.readString(filePath);
            System.out.println("Contenu: " + content);
            content = content.toLowerCase();
            content = content.replaceAll("\\p{Punct}", "");
            String[] words = content.split(" ");

            Map<String, Integer> mapOfFrequentWords = new TreeMap<>();
            for (String word : words) {
                if (!mapOfFrequentWords.containsKey(word)) {
                    mapOfFrequentWords.put(word, 1);
                } else {
                    mapOfFrequentWords.put(word, mapOfFrequentWords.get(word) + 1);
                }
            }

            Map<String, Integer> sorted = mapOfFrequentWords
                    .entrySet()
                    .stream()
                    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                    .limit(3)
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,
                            LinkedHashMap::new));
            System.out.println(sorted);
        }catch (IOException e) {
            System.out.println("Unreadable file: " + path);
            e.printStackTrace();
        }
        return true;
    }
}