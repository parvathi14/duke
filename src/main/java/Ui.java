/**
 * Checks if there is any commands inputted by the user and reads it in.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ui {
    private Scanner input;
    public Ui() {
        this.input = new Scanner(System.in);
    }

    /**
     * Prints out welcome message
     */
    public void showWelcome() {
        System.out.println("Hello!, I'm Duke \n" +
                "What can I do for you?");
    }

    /**
     * Checks if there is a line inputted by the user and reads the input.
     * @return the inputted line or "no input" if there is no input line
     */

    public String readCommand() {
        String line;
        if (input.hasNextLine()) {
            line = new String(input.nextLine());
        } else {
            line = "no input";
        }
        return line;
    }

}
