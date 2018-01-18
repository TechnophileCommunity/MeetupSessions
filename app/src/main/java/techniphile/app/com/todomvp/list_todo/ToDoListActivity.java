package techniphile.app.com.todomvp.list_todo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import techniphile.app.com.todomvp.R;
import techniphile.app.com.todomvp.data.AppDatabase;
import techniphile.app.com.todomvp.data.Task;

public class ToDoListActivity extends AppCompatActivity implements ToDoListView {

    @BindView(R.id.rv_task_list)
    RecyclerView rvTaskList;

    private ToDoListPresenter toDoListPresenter;
    private TaskAdapter taskAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_list);
        ButterKnife.bind(this);

        // setting up the recycler view
        taskAdapter = new TaskAdapter();
        rvTaskList.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rvTaskList.setAdapter(taskAdapter);

        toDoListPresenter = new ToDoListPresenter(this, AppDatabase.getInstance(this).taskDao());
        toDoListPresenter.loadData();
    }

    @Override
    public void displayTaskList(List<Task> taskList) {
        taskAdapter.setTaskList(taskList);
    }
}
