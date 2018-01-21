package technophile.app.com.todomvp.ui.detail_task;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import technophile.app.com.todomvp.R;
import technophile.app.com.todomvp.repository.local.AppDatabase;

public class TaskDetailActivity extends AppCompatActivity implements TaskDetailView {

    public static final java.lang.String EXTRA_TASK_ID = "extra_task_id";
    @BindView(R.id.tv_task_title)
    TextView tvTaskTitle;
    
    @BindView(R.id.tv_task_description)
    TextView tvTaskDescription;
    
    private TaskDetailPresenter taskDetailPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_detail);
        ButterKnife.bind(this);
       
        int taskId = getIntent().getExtras().getInt(EXTRA_TASK_ID);
        
        taskDetailPresenter = new TaskDetailPresenter(this, AppDatabase.getInstance(this).taskDao());
        taskDetailPresenter.displayTask(taskId);
    }

    @Override
    public void setTaskTitle(String title) {
        tvTaskTitle.setText(title);
    }

    @Override
    public void setTaskDescription(String description) {
        tvTaskDescription.setText(description);
    }
}
