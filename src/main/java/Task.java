/**
 * Custom datatype class consisting of a String which notes the description of the task and
 * a boolean variable that keeps track of whether the task has been completed or not.
 */

public class Task {
    protected String description;
    protected boolean isDone;
    // protected char typeOfTask;

    /**
     * Creates new task
     * @param description description of new task
     */

    public Task(String description) {
        // this.typeOfTask = typeOfTask;
        this.description = description;
        this.isDone = false;
    }

    /**
     * Returns respective icon depending on the status of the task
     * @return status icon
     */
    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718");
    }

    /**
     * Marks the respective task as 'Done'
     */
    public void markAsDone() {
        this.isDone = true;
    }

    public String toString() {
        return "[" + this.getStatusIcon() + "] " + this.description;
    }
}
