import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Duke {
    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Hello!, I'm Duke \n" +
                "What can I do for you?");

        List<Task> myTasks = new ArrayList<>();

        while(input.hasNextLine()) {
            //System.out.println(input.nextLine());
            String s = new String(input.nextLine());
            String[] arrOfStr = s.split(" ", 2);

            if(s.equals("bye")) {
                System.out.println("Bye. Hope to see you again soon!");
            } else if (s.equals("list")) {
                System.out.println("Here are the tasks in your list:");
                for (int n = 0; n != myTasks.size(); n += 1) {
                    System.out.println((n + 1) + ". [" + myTasks.get(n).getStatusIcon() + "] " + myTasks.get(n).description);
                }
            } else if (arrOfStr[0].equals("done")) {
                int element = Integer.parseInt(arrOfStr[1]) - 1;
                myTasks.get(element).markAsDone();
                System.out.println("Nice! I've marked this task as done: \n" + "   [" + myTasks.get(element).getStatusIcon() + "] " + myTasks.get(element).description);
            } else {
                Task t = new Task(s);
                myTasks.add(t);
                System.out.println("added: " + s);
            }
        }
    }
}
