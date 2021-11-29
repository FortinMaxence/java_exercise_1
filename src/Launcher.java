import java.util.Scanner;

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
            else
            {
                System.out.println("Unknown command");
            }
        }
    }
}