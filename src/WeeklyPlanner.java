import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WeeklyPlanner {
    private List<Task> tasks;

    public WeeklyPlanner() {
        tasks = new ArrayList<>();
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void saveToMarkdown(String filename) {
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write("# Weekly Planner\n\n");
            String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
            for (String day : days) {
                writer.write("## " + day + "\n");
                for (Task task : tasks) {
                    if (task.getDay().equalsIgnoreCase(day)) {
                        writer.write(task.toString() + "\n");
                    }
                }
                writer.write("\n");
            }
            System.out.println("Tasks saved to " + filename);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}
