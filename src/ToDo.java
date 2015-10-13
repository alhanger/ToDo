import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by alhanger on 10/12/15.
 */
public class ToDo {
    public static void main(String[] args) {

        ArrayList<ToDoItem> todos = new ArrayList();
        Scanner scanner = new Scanner(System.in);

        while(true) {
            int todoNum = 1;
            for (ToDoItem todo : todos) {
                String checkBox = "[ ]";
                if (todo.isDone) {
                    checkBox = "[x]";
                }
                System.out.println(todoNum + ". " + todo.text + " " + checkBox);
                todoNum++;
            }

            System.out.println("Options");
            System.out.println("[1] Create ToDo");
            System.out.println("[2] Mark complete or incomplete");

            String option = scanner.nextLine();
            int optionNum = Integer.valueOf(option);

            if (optionNum == 1) {
                System.out.println("Type a todo and hit enter");
                String todo = scanner.nextLine();
                ToDoItem item = new ToDoItem(todo);
                todos.add(item);
            }
            else if (optionNum == 2) {
                System.out.println("Which item?");
                String select = scanner.nextLine();
                try {
                    int selectNum = Integer.valueOf(select);
                    ToDoItem item = todos.get(selectNum - 1);
                    item.isDone = !item.isDone;
                } catch (Exception e) {
                    System.out.println("An error occurred.");
                }
            }
            else {
                System.out.println("Invalid Number");
            }
        }
    }
}
