public class Task {
    protected String description;
    protected boolean isDone;
    protected char typeOfTask;

    public Task(char typeOfTask, String description) {
        this.typeOfTask = typeOfTask;
        this.description = description;
        this.isDone = false;
    }

    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718");
    }

    public void markAsDone() {
        this.isDone = true;
    }
}
