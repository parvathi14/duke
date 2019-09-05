import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Duke {
    public static void main (String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        List<Task> myTasks = new ArrayList<>();
        saveToFile trial = new saveToFile();

        File file = new File("C:\\Users\\parva\\Desktop\\Level 7 - Save.txt");
        //System.out.println(file.length());
        readFromFile read = new readFromFile();
        DateTime dateAndTime = new DateTime();
        //dateAndTime.date(args,"07/06/2019");

        List existingList = read.readByJava8("C:\\Users\\parva\\Desktop\\Level 7 - Save.txt");


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
        }

        System.out.println("Hello!, I'm Duke \n" +
                "What can I do for you?");

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
                    //continue;
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
                    String formattedDate = dateAndTime.test(date[1], date[2]);
                    Task t = new Deadline(deadline[0], formattedDate);

                    myTasks.add(t);
                    System.out.println("Got it. I've added this task: \n" + t.toString() +
                            "\n" + "Now you have " + myTasks.size() + " tasks in the list.");
                } else if (arrOfStr[0].equals("event")) {
                    String[] event = arrOfStr[1].split("/", 2);
                    String[] time = event[1].split(" ", 3);
                    String formattedDate = dateAndTime.test(time[1], time[2]);
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
            trial.test(args, myTasks);
        }
    }
}
