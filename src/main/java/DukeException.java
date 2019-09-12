/**
 * Sends exception message if an invalid input is keyed in by the user.
 */

public class DukeException extends Exception {
    protected String task;

    public DukeException(String task) {
        this.task = task;
    }

    /**
     * Prints the respective error message depending on the type of error
     */
    public void toPrint() {
        if (!this.task.equals("list") && !this.task.equals("bye")) {
            if (this.task.equals("todo") || this.task.equals("deadline") || this.task.equals("event")) {
                System.out.println("\u2639" + " OOPS!!! The description of a " + task + " cannot be empty.");
            } else {
                System.out.println("\u2639" + " OOPS!!! I'm sorry, but I don't know what that means :-(");
            }
        }
    }
}
