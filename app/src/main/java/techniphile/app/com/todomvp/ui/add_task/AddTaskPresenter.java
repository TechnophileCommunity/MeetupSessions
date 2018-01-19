package techniphile.app.com.todomvp.ui.add_task;

import techniphile.app.com.todomvp.repository.local.Task;
import techniphile.app.com.todomvp.repository.local.TaskDao;
import techniphile.app.com.todomvp.utils.StringUtils;

/**
 * Created by moinkhan on 18-01-2018.
 */

class AddTaskPresenter {

    private AddTaskView view;
    private TaskDao taskDao;

    public AddTaskPresenter(AddTaskView view, TaskDao taskDao) {
        this.view = view;
        this.taskDao = taskDao;
    }


    public void initiateAddTask() {
        String title = view.getTaskTitle();
        String description = view.getTaskDescription();

        if (!StringUtils.isNullOrEmpty(title)) {
            view.showToast("Title cannot be empty.");
            return;
        }

        if (!StringUtils.isNullOrEmpty(description)) {
            view.showToast("Description cannot be empty.");
            return;
        }

        Task task = new Task();
        task.setTitle(title);
        task.setDescription(description);

        long rowAffected = taskDao.insertTask(task);

        if (rowAffected > 0) {
            view.showToast("Task Added.");
            view.performSuccessOperation();
        } else {
            view.showToast("Something went wrong");
        }
    }
}
