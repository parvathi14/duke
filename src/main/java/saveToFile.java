/**
 * Saves the list on Duke to a file on the hard disk.
 */

// @@author parvathi14-reused
// Reused from: https://www.mkyong.com/java/how-to-append-content-to-file-in-java/

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class saveToFile {
    private static final String FILENAME = "C:\\Users\\parva\\Desktop\\Level 7 - Save.txt";

    public static void test (String[] args, List<Task> myTasks) {
        BufferedWriter bw = null;
        FileWriter fw = null;

        try {
            //String data = "This i new content";

            File file = new File(FILENAME);

            if (!file.exists()) {
                file.createNewFile();
            }

            fw = new FileWriter(file.getAbsoluteFile()); //appends: adds to existing file
            bw = new BufferedWriter(fw);

            //bw.write(data);
            /*for(Task list: myTasks) {
                bw.write(list + System.lineSeparator()); // no index
            }*/
            for (int n = 0; n != myTasks.size(); n += 1) {
                bw.write((n+1) + ". " + myTasks.get(n).toString() + "\n"); // has index like list
            }

            //System.out.println("Done");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bw != null)
                    bw.close();
                if (fw != null)
                    fw.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
