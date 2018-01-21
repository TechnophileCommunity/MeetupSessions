package technophile.app.com.todomvp.ui.detail_task;

import technophile.app.com.todomvp.repository.local.Task;
import technophile.app.com.todomvp.repository.local.TaskDao;

/**
 * Created by iqor on 1/21/2018.
 */

public class TaskDetailPresenter {

    private TaskDetailView taskDetailView;
    private TaskDao taskDao;

    public TaskDetailPresenter(TaskDetailView taskDetailView, TaskDao taskDao) {
        this.taskDetailView = taskDetailView;
        this.taskDao = taskDao;
    }


    public void displayTask(int taskId) {
        Task task = taskDao.getTask(taskId);

        taskDetailView.setTaskTitle(task.getTitle());
        taskDetailView.setTaskDescription(task.getDescription());
    }
}
