import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskManager taskManager = new TaskManager();

        while (true) {
            System.out.println("\nGestionnaire de Tâches");
            System.out.println("1. Ajouter une tâche");
            System.out.println("2. Afficher les tâches");
            System.out.println("3. Marquer une tâche comme terminée");
            System.out.println("4. Supprimer une tâche");
            System.out.println("5. Créer une tâche depuis la console");
            System.out.println("0. Quitter");

            System.out.print("Choix : ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Entrez le nom de la tâche : ");
                    String name = scanner.nextLine();
                    System.out.print("Entrez la description de la tâche : ");
                    String description = scanner.nextLine();
                    System.out.print("Entrez la date d'échéance (format 'yyyy-MM-dd') : ");
                    String dueDate = scanner.nextLine();
                    System.out.print("Entrez la priorité de la tâche : ");
                    int priority = scanner.nextInt();
                    taskManager.addTask(name, description, dueDate, priority);
                    break;
                case 2:
                    taskManager.displayTasks();
                    break;
                case 3:
                    System.out.print("Entrez le numéro de la tâche à marquer comme terminée : ");
                    int completeIndex = scanner.nextInt();
                    taskManager.markTaskAsCompleted(completeIndex);
                    break;
                case 4:
                    System.out.print("Entrez le numéro de la tâche à supprimer : ");
                    int deleteIndex = scanner.nextInt();
                    taskManager.deleteTask(deleteIndex);
                    break;
                case 5:
                    taskManager.createTaskFromUserInput();
                    break;
                case 0:
                    taskManager.closeScanner();
                    System.out.println("Merci d'avoir utilisé le gestionnaire de tâches. Au revoir !");
                    System.exit(0);
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
            }
        }
    }
}
