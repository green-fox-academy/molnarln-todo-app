import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ListOfTasks {

    Path filePath;
    List<Task> tasks;
    List<String> stringTasks;

    public ListOfTasks () {
        this.filePath = Paths.get("C:/Users/laszl/Documents/Programozás/greenfox/molnarln-todo-app/src/todolist.txt");
        this.tasks = new ArrayList<>();
        this.stringTasks = new ArrayList<>();

    }

    public void getTasks() {

        try {

            stringTasks.addAll(Files.readAllLines(filePath));
            //Add line of texts to ListOfTasks as Task
            for (int i = 0; i < stringTasks.size() ; i++) {
                Task task = new Task();
                task.taskDescription = stringTasks.get(i);
                tasks.add(task);
            }
            if(tasks.size() == 0){
                System.out.println("No todos for today! :)");
            }
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println(i+1 + " - " + tasks.get(i).getTask());
            }
        } catch (Exception ex) {
            System.out.println("File not found.");
        }
    }

    public void addTask (String newTaskDescription) {

        Task newTaskToAdd = new Task();
        newTaskToAdd.taskDescription = newTaskDescription;
        tasks.add(newTaskToAdd);

        try{
            stringTasks.addAll(Files.readAllLines(filePath));

            List<String> tempList = new ArrayList();
            Files.write(filePath, tempList);

        for (int i = 0; i < tasks.size() ; i++) {
            tempList.add(tasks.get(i).getTask());

        }
        stringTasks = tempList;
        }catch(Exception ex){
            System.out.println("Can't found file.");
        }
    }
}
