import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
        public class Task {
private String name ;
private String description ;
private Date dueDate ;
private int priority ;
private boolean completed ;

// Format de date pour la conversion entre String et Date
private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        // Constructeur
        public Task(String name, String description , String dueDate , int priority ) {
            this.name = name;
            this.description = description;
            this.completed = false;
            setDueDate(dueDate);
            this.priority = priority;
        }

        public String getName() {
            return name;
        }

        public String getDescription() {
            return description;
        }

        public Date getDueDate() {
            return dueDate;
        }
        public void setDueDate(String dueDate) {
            try {
                this.dueDate = dateFormat.parse(dueDate);
            } catch (ParseException e) {
                System.out.println("Format de date invalide. Utilisez le format 'yyyy-MM-dd'.");
            }
        }

        public int getPriority() {
            return priority;
        }

        public void setPriority(int priority) {
            this.priority = priority;
        }

        public boolean isCompleted() {
            return completed;
        }

        public void markAsCompleted() {
            this.completed = true;
        }

        @Override
        public String toString() {
            return "[" + (completed ? "✔" : " ") + "] " + name
                    + " (Description: " + description + ", Échéance: " + dateFormat.format(dueDate)
                    + ", Priorité: " + priority + ")";
        }
}