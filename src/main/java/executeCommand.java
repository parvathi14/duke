import java.util.List;

public class executeCommand {
    private static boolean ans = false;
    DateTime dateAndTime = new DateTime();
    //private boolean ans = false;
    public executeCommand(String line, List<Task> myTasks) {
        if (line.equals("bye")) {
            System.out.println("Bye. Hope to see you again soon!");
            ans = true;
        } else if (line.equals("list")) {
            System.out.println("Here are the tasks in your list:");
            for (int n = 0; n != myTasks.size(); n += 1) {
                System.out.println((n + 1) + ". " + myTasks.get(n).toString());
            }
            ans = false;
        }

        try {
            String[] arrOfStr = line.split(" ", 2);
            if (arrOfStr[0].equals("done")) {
                int element = Integer.parseInt(arrOfStr[1]) - 1;
                myTasks.get(element).markAsDone();
                System.out.println("Nice! I've marked this task as done: \n" + myTasks.get(element).toString());
            } else if (arrOfStr[0].equals("delete")) {
                int element = Integer.parseInt(arrOfStr[1]) - 1;
                System.out.println("Noted. I've removed this task: \n" + myTasks.get(element).toString()
                        + "\n" + "Now you have " + (myTasks.size()-1) + " tasks in the list.");
                myTasks.remove(element);
            } else if (arrOfStr[0].equals("find")) {
                int count = 0;
                for (int n = 0; n != myTasks.size(); n += 1) {
                    String search = myTasks.get(n).toString();
                    if (search.contains(arrOfStr[1])) {
                        if (count == 0) {System.out.println("Here are the matching tasks in your list:");}
                        count += 1;
                        System.out.println(count + ". " + myTasks.get(n).toString());
                    }
                }
                if (count == 0) {
                    System.out.println("Sorry, no matches were found");
                }
            } else if (arrOfStr[0].equals("todo")) {
                Task t = new Todo(arrOfStr[1]);

                myTasks.add(t);
                System.out.println("Got it. I've added this task: \n" + t.toString() +
                        "\n" + "Now you have " + myTasks.size() + " tasks in the list.");
            } else if (arrOfStr[0].equals("deadline")) {
                String[] deadline = arrOfStr[1].split("/", 2); // could split by '/by '?
                String[] date = deadline[1].split(" ", 3);
                String formattedDate = dateAndTime.test(date[1], date[2], deadline[1]);
                Task t = new Deadline(deadline[0], formattedDate);

                myTasks.add(t);
                System.out.println("Got it. I've added this task: \n" + t.toString() +
                        "\n" + "Now you have " + myTasks.size() + " tasks in the list.");
            } else if (arrOfStr[0].equals("event")) {
                String[] event = arrOfStr[1].split("/", 2);
                String[] time = event[1].split(" ", 3);
                String formattedDate = dateAndTime.test(time[1], time[2], event[1]);
                Task t = new Event(event[0], formattedDate);

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

    public static boolean result() {
        return ans;
    }
}
