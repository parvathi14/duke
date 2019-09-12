/**
 * Converts the Strings in the saved file on the hard disk into a list in Duke.
 */

public class existingFile extends Task{
    protected char taskType;
    public existingFile(String description, char taskType) {
        super(description);
        this.taskType = taskType;
    }

    @Override
    public String toString() {
        return "[" + taskType + "]" + super.toString();
    }
}
