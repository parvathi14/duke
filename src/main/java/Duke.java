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
            //String s = new String(input.nextLine());
            //String[] arrOfStr = s.split(" ", 2);

            String line = new String(input.nextLine());

            if (line.equals("bye")) {
                System.out.println("Bye. Hope to see you again soon!");
                break;
            } else if (line.equals("list")) {
                System.out.println("Here are the tasks in your list:");
                for (int n = 0; n != myTasks.size(); n += 1) {
                    System.out.println((n + 1) + ". " + myTasks.get(n).toString());
                }
                continue;
            }

            try {
                String[] arrOfStr = line.split(" ", 2);
                if (arrOfStr[0].equals("done")) {
                    int element = Integer.parseInt(arrOfStr[1]) - 1;
                    myTasks.get(element).markAsDone();
                    System.out.println("Nice! I've marked this task as done: \n" + myTasks.get(element).toString());
                    continue;
                } else if (arrOfStr[0].equals("todo")) {
                    Task t = new Todo(arrOfStr[1]);

                    myTasks.add(t);
                    System.out.println("Got it. I've added this task: \n" + t.toString() +
                            "\n" + "Now you have " + myTasks.size() + " tasks in the list.");
                } else if (arrOfStr[0].equals("deadline")) {
                    String[] deadline = arrOfStr[1].split("/", 2);
                    String[] date = deadline[1].split(" ", 2);
                    Task t = new Deadline(deadline[0], date[1]);

                    myTasks.add(t);
                    System.out.println("Got it. I've added this task: \n" + t.toString() +
                            "\n" + "Now you have " + myTasks.size() + " tasks in the list.");
                } else if (arrOfStr[0].equals("event")) {
                    String[] event = arrOfStr[1].split("/", 2);
                    String[] time = event[1].split(" ", 2);
                    Task t = new Event(event[0], time[1]);

                    myTasks.add(t);
                    System.out.println("Got it. I've added this task: \n" + t.toString() +
                            "\n" + "Now you have " + myTasks.size() + " tasks in the list.");
                } else {
                    DukeException error = new DukeException(arrOfStr[0]);
                    error.toPrint();
                }
            } catch (Exception e) {
                DukeException error = new DukeException(line);
                error.toPrint();
            }
        }
    }
}
