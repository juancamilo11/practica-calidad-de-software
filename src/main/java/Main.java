import helpers.MainMenu;
import models.ToDoManagement;

public class Main {
    public static void main(String[] args) {
        String opt = "";
        ToDoManagement toDoManagement = new ToDoManagement();
        MainMenu menu = new MainMenu();

        do {
            opt = menu.showMenu();
            System.out.println("Option selected: " + opt);

            switch (opt) {
                case "1":
                    String desc = menu.readInput("Task description: ");
                    toDoManagement.addTask(desc);
                    System.out.println("Task successfully added");
                    break;
                case "2":
                    toDoManagement.listTasks();
                    break;

                //   case "3":
                //     toDoManagement.listTasksByStatus("COMPLETED");
                //     break;

                //   case "4":
                //     toDoManagement.listTasksByStatus("PENDING");
                //     break;
                case "5":
                    String idToComplete = menu.readInput("Task Id to complete: ");
                    boolean taskToCompleteExists = toDoManagement.existsById(idToComplete);
                    if (taskToCompleteExists) {
                        toDoManagement.completeTask(idToComplete);
                    } else {
                        System.out.println("Task not found");
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
                        System.out.println("Task not found");
                    }
                    break;
                //   case "0":
                //     toDoManagement.saveTasksInDB();
                //     break;
                default:
                    System.out.println("Invalid option, please try again");
                    //     break;
            }
        } while (!opt.equals("0"));
    }
}
