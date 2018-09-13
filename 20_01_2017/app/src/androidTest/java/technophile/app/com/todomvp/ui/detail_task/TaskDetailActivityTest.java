package technophile.app.com.todomvp.ui.detail_task;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class TaskDetailActivityTest {

    @Rule
    public ActivityTestRule<TaskDetailActivity> activityActivityTestRule = new ActivityTestRule<>(TaskDetailActivity.class);

}