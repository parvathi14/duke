/**
 * Loads the existing list in the file saved on the hard disk every time Duke starts up.
 */

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Storage {
    private File file;
    private List existingList;
    private List<Task> myTasks;

    /**
     * Reads file saved on hard disk
     * @param filePath location of file on hard disk
     */

    public Storage(String filePath) {
        this.file = new File(filePath);
        readFromFile read = new readFromFile();

        try {
            this.existingList = read.readByJava8(filePath);
        } catch (Exception e) {
            System.out.println("Oops! Something went wrong :(");
        }
        this.myTasks = new ArrayList<>();
    }

    /**
     * Loads data from saved file
     * @return list created from existing data on the file
     */
    public List<Task> load() {
        if (file.length() != 3) {
            for (int n = 0; n != existingList.size(); n += 1) {
                //System.out.println((n + 1) + ". " + existingList.get(n));
                String newInput = (String) existingList.get(n);
                String[] existingTasks = newInput.split("\\[", 3);
                String[] existingDescription = existingTasks[2].split(" ", 2);

                Task t = new existingFile(existingDescription[1], existingTasks[1].charAt(0));
                myTasks.add(t);

                if (existingTasks[2].charAt(0) == '\u2713') {
                    t.markAsDone();
                    //myTasks.get(n).markAsDone();
                }
            }
            return myTasks;
        }
        // return new ArrayList<>();
        return myTasks;
    }
}
