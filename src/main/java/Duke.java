import java.util.Scanner;

public class Duke {
    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Hello!, I'm Duke \n" +
                "What can I do for you?");

        while(input.hasNextLine()) {
            //System.out.println(input.nextLine());
            String s = new String(input.nextLine());
            if(s.equals("bye")) {
                System.out.println("Bye. Hope to see you again soon!");
            } else {
                System.out.println(s);
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
