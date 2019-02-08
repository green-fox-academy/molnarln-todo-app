import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ListOfTasks {

    Path filePath;
    List<Task> tasks;


    public ListOfTasks () {
        this.filePath = Paths.get("C:/Users/laszl/Documents/Programozás/greenfox/molnarln-todo-app/src/todolist.txt");
        this.tasks = new ArrayList<>();

    }

    public void listTasks() {
        try {
            ArrayList<String> stringTasks = new ArrayList<>();
            stringTasks.addAll(Files.readAllLines(filePath));

            for (int i = 0; i < stringTasks.size(); i++) {

                System.out.println(i+1 + " - "+ stringTasks.get(i));
            }

        } catch (Exception ex) {
            System.out.println("File not found.");
        }
    }
}
