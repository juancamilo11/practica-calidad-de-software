package co.edu.udea.calidadsoftware.helpers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class MainMenu {
    private static final Logger logger = LoggerFactory.getLogger(MainMenu.class);

    public String showMenu() {
        logger.info("1. Create task");
        logger.info("2. List tasks");
        logger.info("3. List completed tasks");
        logger.info("4. List pending tasks");
        logger.info("5. Complete task");
        logger.info("6. Delete task");
        logger.info("0. Exit");
        logger.info("==========================");
        logger.info(" Please select an option ");
        logger.info("==========================");
        return this.readInput("Your option: ");
    }

    public String readInput(String message) {
        Scanner reader = new Scanner(System.in);
        System.out.println(message);
        return reader.nextLine();
    }
}
