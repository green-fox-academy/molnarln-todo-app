public class Main {

    public static void main(String[] args) {
        ListOfTasks list = new ListOfTasks();

        if (args.length == 0) {
            System.out.println("Command Line Todo application" + "\n" + "==============================" + "\n");
            System.out.println(" -l List all the tasks");
            System.out.println(" -a Add a new task");
            System.out.println(" -r Removes a task");
            System.out.println(" -c Completes a task");
            return;
        }
        if ((args[0]).equals("-l") && args.length < 2) {

            list.getTasks();
        }
        if (args[0].equals("-l")){
            list.addTask(args[1]);
        }

    }
}

