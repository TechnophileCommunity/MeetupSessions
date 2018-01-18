package techniphile.app.com.todomvp.add_todo;

/**
 * Created by moinkhan on 18-01-2018.
 */

public interface AddTaskView {
    String getTaskTitle();

    String getTaskDescription();

    void showToast(String message);

    void performSuccessOperation();
}
