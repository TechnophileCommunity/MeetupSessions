package technophile.app.com.todomvp.ui.list_task;

import java.util.List;

import technophile.app.com.todomvp.R;
import technophile.app.com.todomvp.repository.local.Task;
import technophile.app.com.todomvp.repository.local.TaskDao;

/**
 * Created by moinkhan on 17-01-2018.
 */

public class TaskListPresenter {

    private TaskListView view;
    private TaskDao taskDao;

    public TaskListPresenter(TaskListView view, TaskDao taskDao) {
        this.view = view;
        this.taskDao = taskDao;
    }

    public void loadData() {
        List<Task> taskList = taskDao.getAllTask();

        if (taskList.size() == 0) {
            view.showEmptyView();
            return;
        }

        view.hideEmptyView();
        view.displayTaskList(taskList);
    }

    public void deleteTask(Task task) {
        int rowAffected = taskDao.deleteTask(task);
        if (rowAffected > 0) {
            view.removeTaskFromList(task);
            return;
        }

        view.showErrorMessage(R.string.err_unable_to_remove_task);
    }
}
