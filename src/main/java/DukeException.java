public class DukeException {
    protected String task;

    public DukeException(String task) {
        this.task = task;
    }

    public void toPrint() {
        if (this.task.equals("todo") || this.task.equals("deadline") || this.task.equals("event")) {
            System.out.println("\u2639" + " OOPS!!! The description of a " + task + " cannot be empty.");
        } else {
            System.out.println("\u2639" + " OOPS!!! I'm sorry, but I don't know what that means :-(");
        }
    }
}
