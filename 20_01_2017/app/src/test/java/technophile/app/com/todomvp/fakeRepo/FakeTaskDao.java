package technophile.app.com.todomvp.fakeRepo;

import java.util.ArrayList;
import java.util.List;

import technophile.app.com.todomvp.repository.local.Task;
import technophile.app.com.todomvp.repository.local.TaskDao;

public class FakeTaskDao implements TaskDao {
    @Override
    public long insertTask(Task task) {
        return 1;
    }

    @Override
    public List<Task> getAllTask() {
        return new ArrayList<>();
    }

    @Override
    public int deleteTask(Task task) {
        return 1;
    }

    @Override
    public Task getTask(int id) {
        return new Task(id, "Fake Title", "Fake Description");
    }
}
