import java.util.ArrayList;
import java.util.Scanner;

public class TaskManager {
        private ArrayList<Task> tasks;
        private Scanner scanner;

        public TaskManager() {
                this.tasks = new ArrayList<>();
                this.scanner = new Scanner(System.in);
        }

        public void addTask(String name, String description, String dueDate, int priority) {
                Task newTask = new Task(name, description, dueDate, priority);
                tasks.add(newTask);
                System.out.println("Nouvelle tâche ajoutée : " + newTask.getName());
        }

        public void displayTasks() {
                if (tasks.isEmpty()) {
                        System.out.println("Aucune tâche pour le moment.");
                } else {
                        System.out.println("Liste des tâches :");
                        for (int i = 0; i < tasks.size(); i++) {
                                System.out.println((i + 1) + ". " + tasks.get(i));
                        }
                }
        }

        public void markTaskAsCompleted(int index) {
                if (index >= 1 && index <= tasks.size()) {
                        Task task = tasks.get(index - 1);
                        task.markAsCompleted();
                        System.out.println("Tâche marquée comme terminée : " + task.getDescription());
                } else {
                        System.out.println("Indice de tâche invalide.");
                }
        }

        public void deleteTask(int index) {
                if (index >= 1 && index <= tasks.size()) {
                        Task removedTask = tasks.remove(index - 1);
                        System.out.println("Tâche supprimée : " + removedTask.getDescription());
                } else {
                        System.out.println("Indice de tâche invalide.");
                }
        }

        // Méthode pour saisir une nouvelle tâche depuis la console
        public void createTaskFromUserInput() {
                System.out.print("Entrez la description de la tâche : ");
                String description = scanner.nextLine();
                System.out.print("Entrez le nom de la tâche : ");
                String name = scanner.nextLine();
                System.out.print("Entrez la date d'échéance (format 'yyyy-MM-dd') : ");
                String dueDate = scanner.nextLine();
                System.out.print("Entrez la priorité de la tâche : ");
                int priority = scanner.nextInt();
                addTask(description, name, dueDate, priority);
        }

        // Méthode pour libérer les ressources du scanner
        public void closeScanner() {
                scanner.close();
        }
}
