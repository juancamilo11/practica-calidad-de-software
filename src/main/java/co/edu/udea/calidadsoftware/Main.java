package co.edu.udea.calidadsoftware;

import co.edu.udea.calidadsoftware.helpers.MainMenu;
import co.edu.udea.calidadsoftware.models.ToDoManagement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        String opt;
        ToDoManagement toDoManagement = new ToDoManagement();
        MainMenu menu = new MainMenu();

        do {
            opt = menu.showMenu();

            switch (opt) {
                case "1":
                    String desc = menu.readInput("Task description: ");
                    toDoManagement.addTask(desc);
                    logger.info("Task successfully added");
                    break;
                case "2":
                    toDoManagement.listTasks();
                    break;

                case "3":
                  toDoManagement.showCompletedTasks();
                  break;

                case "4":
                  toDoManagement.showPendingTasks();
                  break;
                case "5":
                    String idToComplete = menu.readInput("Task Id to complete: ");
                    boolean taskToCompleteExists = toDoManagement.existsById(idToComplete);
                    if (taskToCompleteExists) {
                        toDoManagement.completeTask(idToComplete);
                    } else {
                        logger.warn("Task not found");
                    }
                    break;
                case "6":
                    String idToRemove = menu.readInput("Task Id to remove: ");
                    boolean taskToRemoveExists = toDoManagement.existsById(idToRemove);
                    if (taskToRemoveExists) {
                        String ok = menu.readInput("Write 'ok' to confirm:");
                        if (ok.equalsIgnoreCase("ok")) {
                            toDoManagement.deleteTask(idToRemove);
                        }
                    } else {
                        logger.info("Task not found");
                    }
                    break;
                default:
                    logger.error("Invalid option, please try again");
                    break;
            }
        } while (!opt.equals("0"));
    }
}
