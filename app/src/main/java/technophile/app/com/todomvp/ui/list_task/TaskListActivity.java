package technophile.app.com.todomvp.ui.list_task;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import technophile.app.com.todomvp.R;
import technophile.app.com.todomvp.listeners.OnItemClickListener;
import technophile.app.com.todomvp.ui.add_task.AddTaskActivity;
import technophile.app.com.todomvp.repository.local.AppDatabase;
import technophile.app.com.todomvp.repository.local.Task;
import technophile.app.com.todomvp.ui.detail_task.TaskDetailActivity;

public class TaskListActivity extends AppCompatActivity implements TaskListView, OnItemClickListener<Task> {

    @BindView(R.id.rv_task_list)
    RecyclerView rvTaskList;

    @BindView(R.id.tv_task_list_empty_view)
    TextView tvTaskListEmptyView;

    private TaskListPresenter taskListPresenter;
    private TaskAdapter taskAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_list);
        ButterKnife.bind(this);

        // setting up the recycler view
        taskAdapter = new TaskAdapter(this::askForDelete, this);
        rvTaskList.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rvTaskList.setAdapter(taskAdapter);
        rvTaskList.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL));

        taskListPresenter = new TaskListPresenter(this, AppDatabase.getInstance(this).taskDao());
    }

    private void askForDelete(Task task) {
        Snackbar.make(rvTaskList, "Are you sure you want to remove?", Snackbar.LENGTH_SHORT)
                .setAction("Yes", view -> taskListPresenter.deleteTask(task))
                .show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        taskListPresenter.loadData();
    }

    @Override
    public void displayTaskList(List<Task> taskList) {
        taskAdapter.setTaskList(taskList);
    }

    @Override
    public void showEmptyView() {
        tvTaskListEmptyView.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideEmptyView() {
        tvTaskListEmptyView.setVisibility(View.GONE);
    }

    @Override
    public void removeTaskFromList(Task task) {
        taskAdapter.removeTask(task);
    }

    @OnClick(R.id.fab_add_task)
    public void addTaskClick() {
        startActivity(new Intent(this, AddTaskActivity.class));
    }

    @Override
    public void onItemClick(Task data) {
        Intent intent = new Intent(this, TaskDetailActivity.class);
        intent.putExtra(TaskDetailActivity.EXTRA_TASK_ID, data.getId());
        startActivity(intent);
    }
}
