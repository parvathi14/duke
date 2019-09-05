import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ui {
    private Scanner input;
    public Ui() {
        this.input = new Scanner(System.in);
    }

    public void showWelcome() {
        System.out.println("Hello!, I'm Duke \n" +
                "What can I do for you?");
    }

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
