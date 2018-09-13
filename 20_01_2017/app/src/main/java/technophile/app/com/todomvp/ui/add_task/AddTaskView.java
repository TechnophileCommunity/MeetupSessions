package technophile.app.com.todomvp.ui.add_task;

import android.support.annotation.StringRes;

/**
 * Created by moinkhan on 18-01-2018.
 */

public interface AddTaskView {
    String getTaskTitle();

    String getTaskDescription();

    void showMessage(@StringRes int resID);

    void performSuccessOperation();
}
