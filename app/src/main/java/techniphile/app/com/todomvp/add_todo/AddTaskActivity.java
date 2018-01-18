package techniphile.app.com.todomvp.add_todo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import techniphile.app.com.todomvp.R;
import techniphile.app.com.todomvp.data.AppDatabase;

public class AddTaskActivity extends AppCompatActivity implements AddTaskView {

    @BindView(R.id.et_task_title)
    private EditText etTaskTitle;

    @BindView(R.id.et_task_description)
    private EditText etTaskDescription;

    private AddTaskPresenter addTaskPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
        ButterKnife.bind(this);

        addTaskPresenter = new AddTaskPresenter(this, AppDatabase.getInstance(this).taskDao());

    }

    @OnClick(R.id.btn_add_task)
    public void onAddTaskClick() {
        addTaskPresenter.initiateAddTask();
    }

    @Override
    public String getTaskDescription() {
        return etTaskTitle.getText().toString().trim();
    }

    @Override
    public String getTaskTitle() {
        return etTaskDescription.getText().toString().trim();
    }
}
