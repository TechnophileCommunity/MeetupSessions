package technophile.app.com.todomvp.ui.add_task;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import technophile.app.com.todomvp.R;
import technophile.app.com.todomvp.repository.local.AppDatabase;

public class AddTaskActivity extends AppCompatActivity implements AddTaskView {

    @BindView(R.id.et_task_title)
    EditText etTaskTitle;

    @BindView(R.id.et_task_description)
    EditText etTaskDescription;

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
    public String getTaskTitle() {
        return etTaskTitle.getText().toString().trim();
    }

    @Override
    public String getTaskDescription() {
        return etTaskDescription.getText().toString().trim();
    }

    @Override
    public void showMessage(int resID) {
        Toast.makeText(this, getString(resID), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void performSuccessOperation() {
        finish();
    }
}
