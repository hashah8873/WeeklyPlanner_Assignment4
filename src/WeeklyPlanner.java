import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class WeeklyPlanner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("How many tasks do you want to plan?");
        int taskCount = scanner.nextInt();
        scanner.nextLine(); // consume newline

        // Create array of Task objects
        Task[] tasks = new Task[taskCount];

        // Input tasks
        for (int i = 0; i < taskCount; i++) {
            System.out.print("Enter task " + (i + 1) + ": ");
            String description = scanner.nextLine();
            tasks[i] = new Task(description);
        }

        // Write tasks to Markdown file
        try (FileWriter writer = new FileWriter("../WeeklyPlanner.md")) {
            writer.write("# Weekly Planner\n\n");
            for (int i = 0; i < taskCount; i++) {
                writer.write("- " + tasks[i].getDescription() + "\n");
            }
            System.out.println("Tasks saved to WeeklyPlanner.md successfully!");
        } catch (IOException e) {
            System.out.println("An error occurred while writing the file.");
            e.printStackTrace();
        }

        scanner.close();
    }
}
