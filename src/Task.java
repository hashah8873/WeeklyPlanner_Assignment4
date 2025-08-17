public class Task {
    private String day;
    private String description;

    public Task(String day, String description) {
        this.day = day;
        this.description = description;
    }

    public String getDay() {
        return day;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "- " + description;
    }
}
