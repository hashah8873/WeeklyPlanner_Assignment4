import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        WeeklyPlanner planner = new WeeklyPlanner();
        String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

        int taskCount = 0;
        while (taskCount < 3 || taskCount > 7) {
            System.out.print("Enter number of tasks for the week (3-7): ");
            if(scanner.hasNextInt()){
                taskCount = scanner.nextInt();
                scanner.nextLine(); // consume newline
                if (taskCount < 3 || taskCount > 7) {
                    System.out.println("Please enter a number between 3 and 7.");
                }
            } else {
                System.out.println("Please enter a valid number.");
                scanner.nextLine(); // consume invalid input
            }
        }

        for (int i = 0; i < taskCount; i++) {
            System.out.println("Task #" + (i + 1));
            String day = "";
            while (true) {
                System.out.print("Enter day (e.g., Monday): ");
                day = scanner.nextLine().trim();
                boolean validDay = false;
                for(String d : days){
                    if(d.equalsIgnoreCase(day)){
                        validDay = true;
                        break;
                    }
                }
                if(validDay){
                    break;
                } else {
                    System.out.println("Invalid day. Please enter a valid weekday.");
                }
            }
            System.out.print("Enter task description: ");
            String desc = scanner.nextLine().trim();
            planner.addTask(new Task(day, desc));
        }

        planner.saveToMarkdown("WeeklyPlanner.md");
        scanner.close();
        System.out.println("Thank you! Your weekly planner has been created.");
    }
}
