package helpers;

import java.util.Scanner;

public class MainMenu {

    public String showMenu() {
        System.out.println("1. Create task");
        System.out.println("2. List tasks");
        System.out.println("3. List completed tasks");
        System.out.println("4. List pending tasks");
        System.out.println("5. Complete task");
        System.out.println("6. Delete task");
        System.out.println("0. Save tasks and exi");
        System.out.println("==========================");
        System.out.println(" Please select an option ");
        System.out.println("==========================");
        return this.readInput("Your option: ");
    }

    public String readInput(String message) {
        Scanner reader = new Scanner(System.in);
        System.out.print(message);
        return reader.nextLine();
    }
}
