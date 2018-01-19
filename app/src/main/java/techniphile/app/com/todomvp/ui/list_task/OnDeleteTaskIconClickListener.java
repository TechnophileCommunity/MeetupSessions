package techniphile.app.com.todomvp.ui.list_task;

import techniphile.app.com.todomvp.repository.local.Task;

/**
 * Created by moinkhan on 19-01-2018.
 */

@FunctionalInterface
public interface OnDeleteTaskIconClickListener {
    void onDeleteIconClicked(Task task);
}
