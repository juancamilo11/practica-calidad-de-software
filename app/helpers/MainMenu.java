package app.helpers;

import java.util.Scanner;

public class MainMenu {

    public String showMenu() {
        String options = """
                    1. Create task
                    2. List tasks
                    3. List completed tasks
                    4. List pending tasks
                    5. Complete task
                    6. Delete task
                    0. Save tasks and exi
                """;
        System.out.println("==========================");
        System.out.println(" Please select an option ");
        System.out.println("==========================");
        System.out.println(options);
        return this.readInput("Your option: ");
    }

    public String readInput(String message) {
        Scanner reader = new Scanner(System.in);
        System.out.print(message);
        return reader.nextLine();
    }
}
