import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;


public class Launcher{



    public static void main(String[] args) {
        System.out.println("Bienvenue");
        boolean exit = false;
        List<Command> commands = new ArrayList<Command>();
        Scanner scanner = new Scanner(System.in);

        commands.add(new Freq());
        commands.add(new Fibo());
        commands.add(new Quit());

        while (scanner.hasNext()) {
            String entree = scanner.nextLine();
            for (Command command : commands){
                if (command.name().equals(entree))
                    if(command.run(scanner));
                        return;
            }
            System.out.println("Unknown command");
        }
    }
}
