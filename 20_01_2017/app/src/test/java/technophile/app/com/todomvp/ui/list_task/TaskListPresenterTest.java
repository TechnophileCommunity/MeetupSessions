package technophile.app.com.todomvp.ui.list_task;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import technophile.app.com.todomvp.R;
import technophile.app.com.todomvp.repository.local.Task;
import technophile.app.com.todomvp.repository.local.TaskDao;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class TaskListPresenterTest {

    TaskListPresenter taskListPresenter;

    @Mock
    TaskDao taskDao;

    @Mock
    TaskListView taskListView;

    @Before
    public void setUp() {
        taskListPresenter = new TaskListPresenter(taskListView, taskDao);
    }

    @Test
    public void shouldShowEmptyViewIfTaskListIsEmpty() {
        // step 1: Provide your inputs.
        when(taskDao.getAllTask()).thenReturn(Collections.emptyList());

        // step 2: Execute your operation.
        taskListPresenter.loadData();

        // step 3: verify your expected output.
        verify(taskListView).showEmptyView();
    }

    @Test
    public void shouldShowTaskListIfTaskListAvailable() {
        // step 1: Provide your inputs.
        List<Task> dummyTasks = Arrays.asList(
                new Task(1, "Fake", "Fake De"),
                new Task(1, "Fake", "Fake De")
        );
        when(taskDao.getAllTask()).thenReturn(dummyTasks);

        // step 2: Execute your operation.
        taskListPresenter.loadData();

        // step 3: verify your expected output.
        verify(taskListView).hideEmptyView();
        verify(taskListView).displayTaskList(dummyTasks);
    }

    @Test
    public void shouldShowErrorMessageIfTaskUnableToDelete() {
        // step 1: Provide your inputs.
        Task dummy = new Task(1, "Task Title", "Task Description");
        when(taskDao.deleteTask(dummy)).thenReturn(-1);

        // step 2: Execute your operation.
        taskListPresenter.deleteTask(dummy);

        // step 3: verify your expected output.
        verify(taskListView).showErrorMessage(R.string.err_unable_to_remove_task);
    }

    @Test
    public void shouldDeleteTaskFromListIfTaskDeletionIsSuccessful() {
        // step 1: Provide your inputs.
        Task dummy = new Task(1, "Task Title", "Task Description");
        when(taskDao.deleteTask(dummy)).thenReturn(1);

        // step 2: Execute your operation.
        taskListPresenter.deleteTask(dummy);

        // step 3: verify your expected output.
        verify(taskListView).removeTaskFromList(dummy);
    }
}