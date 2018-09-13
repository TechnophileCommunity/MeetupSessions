package technophile.app.com.todomvp.ui.list_task;

import java.util.List;

import technophile.app.com.todomvp.repository.local.Task;

/**
 * Created by moinkhan on 17-01-2018.
 */

public interface TaskListView {

    void displayTaskList(List<Task> taskList);

    void showEmptyView();

    void hideEmptyView();

    void removeTaskFromList(Task task);

    void showErrorMessage(int resString);
}
