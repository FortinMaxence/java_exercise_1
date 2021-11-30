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

public class Launcher {

    public static void main(String[] args) {
        System.out.println("Bienvenue");
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            String entree = scanner.nextLine();
            if (entree.equals("quit"))
            {
                return;
            }
            else if(entree.equals("fibo")){
                int n = scanner.nextInt();
                int x0=0, x1=1, resultat=0;

                if(n == 0){
                    System.out.println(0);
                    return;
                }

                if(n == 1){
                    System.out.println(1);
                    return;
                }

                for(int i=2; i<n+1; ++i)
                {
                    resultat = x0 + x1;
                    x0 = x1;
                    x1 = resultat;
                }

                System.out.println(resultat);
                return;
            }
            else if(entree.equals("freq")){
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
            }
            else
            {
                System.out.println("Unknown command");
            }
        }
    }
}