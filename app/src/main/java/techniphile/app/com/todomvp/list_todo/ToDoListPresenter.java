package techniphile.app.com.todomvp.list_todo;

import java.util.List;

import techniphile.app.com.todomvp.data.Task;
import techniphile.app.com.todomvp.data.TaskDao;

/**
 * Created by moinkhan on 17-01-2018.
 */

public class ToDoListPresenter {

    private ToDoListView view;
    private TaskDao taskDao;

    public ToDoListPresenter(ToDoListView view, TaskDao taskDao) {
        this.view = view;
        this.taskDao = taskDao;
    }

    public void loadData() {
        List<Task> taskList = taskDao.getAllTask();
        view.displayTaskList(taskList);
    }
}
