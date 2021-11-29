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
            else
            {
                System.out.println("Unknown command");
            }
        }
    }
}