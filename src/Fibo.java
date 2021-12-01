import java.util.Scanner;

public class Fibo implements Command{
    @Override
    public String name() {
        return "fibo";
    }

    @Override
    public boolean run(Scanner scanner) {
        int n = scanner.nextInt();
        int x0=0, x1=1, resultat=0;

        if(n == 0){
            System.out.println(0);
            return true;
        }

        if(n == 1){
            System.out.println(1);
            return true;
        }

        for(int i=2; i<n+1; ++i)
        {
            resultat = x0 + x1;
            x0 = x1;
            x1 = resultat;
        }

        System.out.println(resultat);
        return true;
    }
}