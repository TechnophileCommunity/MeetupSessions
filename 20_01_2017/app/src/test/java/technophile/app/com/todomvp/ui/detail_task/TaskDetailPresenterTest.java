package technophile.app.com.todomvp.ui.detail_task;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import technophile.app.com.todomvp.R;
import technophile.app.com.todomvp.fakeRepo.FakeTaskDao;
import technophile.app.com.todomvp.repository.local.Task;
import technophile.app.com.todomvp.repository.local.TaskDao;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TaskDetailPresenterTest {

    TaskDetailPresenter taskDetailPresenter;

    @Mock
    private TaskDetailView view;

    @Mock
    private TaskDao taskDao;

    @Before
    public void setUp() throws Exception {
        taskDetailPresenter = new TaskDetailPresenter(view, taskDao);
    }

    @Test
    public void shouldShowErrorIfTaskIsNull() {
        // step 1: Provide your input for particular Unit.
        when(taskDao.getTask(-1)).thenReturn(null);

        // step 2: Execute your operation.
        taskDetailPresenter.displayTask(-1);

        // step 3: verify your expected output.
        verify(view).showInvalidTaskID(R.string.err_invalid_task_id);
    }

    @Test
    public void showShowDetailIfTaskIsAvailable() {
        // step 1: Provide your input for particular Unit
        when(taskDao.getTask(1)).thenReturn(new Task(1, "FakeTask", "FakeDesc"));

        // step 2: Execute operation.
        taskDetailPresenter.displayTask(1);

        // step 3: verify your expected output.
        verify(view).setTaskTitle("FakeTask");
        verify(view).setTaskDescription("FakeDesc");
    }

    @After
    public void tearDown() throws Exception {
    }
}