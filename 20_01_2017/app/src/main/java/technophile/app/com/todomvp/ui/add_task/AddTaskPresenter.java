package technophile.app.com.todomvp.ui.add_task;

import technophile.app.com.todomvp.R;
import technophile.app.com.todomvp.repository.local.Task;
import technophile.app.com.todomvp.repository.local.TaskDao;

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

        if (title == null || title.trim().length() == 0) {
            view.showMessage(R.string.err_empty_task);
            return;
        }

        if (description == null || description.trim().length() == 0) {
            view.showMessage(R.string.err_empty_description);
            return;
        }

        Task task = new Task();
        task.setTitle(title);
        task.setDescription(description);

        long rowAffected = taskDao.insertTask(task);

        if (rowAffected > 0) {
            view.showMessage(R.string.msg_task_added);
            view.performSuccessOperation();
        } else {
            view.showMessage(R.string.err_something_wrong);
        }
    }
}
