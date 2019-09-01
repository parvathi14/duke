import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Duke {
    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Hello!, I'm Duke \n" +
                "What can I do for you?");

        List<String> list = new ArrayList<String>();

        while(input.hasNextLine()) {
            //System.out.println(input.nextLine());
            String s = new String(input.nextLine());
            if(s.equals("bye")) {
                System.out.println("Bye. Hope to see you again soon!");
            } else if (s.equals("list")) {
                for (int n = 0; n != list.size(); n += 1) {
                    System.out.println((n + 1) + ". " + list.get(n));
                }
            } else {
                System.out.println("added: " + s);
                list.add(s);
            }
        }
    }
    /*public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
    }*/
}
