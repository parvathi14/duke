/**
 * Starts up and runs Duke.
 */

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Duke {
    private Ui ui;
    private Storage storage;
    private List<Task> myTasks;
    public boolean isExit;
    private String[] Args;

    /**
     * Prepares Duke for run: involves loading file from hard disk
     * @param filePath location of file on hard disk
     */

    public Duke (String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        try {
            myTasks = storage.load();
        } catch (Exception e) {
            myTasks = new ArrayList<>();
        }
    }

    /**
     * Runs Duke: Calls classes that read and execute the commands inputted by the user.
     */

    public void run() {
        ui.showWelcome();
        saveToFile trial = new saveToFile();
        isExit = false;
        String line = new String();
        while (!isExit) {
            try {
                line = ui.readCommand();
                if (line.equals("no input")) {
                    isExit = true;
                    break;
                }
                new executeCommand(line, myTasks);
                isExit = executeCommand.result();

            } catch (Exception e) {
                return;
                //DukeException error = new DukeException(line);
                //error.toPrint();
            }
            trial.test(Args, myTasks);
        }
        //System.out.println("Bye. Hope to see you again soon!");
    }

    public static void main(String[] args) {
        new Duke("C:\\Users\\parva\\Desktop\\Level 7 - Save.txt").run();
    }
}
