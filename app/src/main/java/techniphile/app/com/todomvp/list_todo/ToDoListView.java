package techniphile.app.com.todomvp.list_todo;

import java.util.List;

import techniphile.app.com.todomvp.data.Task;

/**
 * Created by moinkhan on 17-01-2018.
 */

public interface ToDoListView {

    void displayTaskList(List<Task> taskList);

}
