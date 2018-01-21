package technophile.app.com.todomvp.ui.list_task;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import technophile.app.com.todomvp.R;
import technophile.app.com.todomvp.listeners.OnItemClickListener;
import technophile.app.com.todomvp.repository.local.Task;

/**
 * Created by moinkhan on 18-01-2018.
 */

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.ViewHolder> {

    private List<Task> taskList = new ArrayList<>();
    private OnDeleteTaskIconClickListener onDeleteTaskIconClickListener;
    private OnItemClickListener<Task> clickListener;

    public TaskAdapter(OnDeleteTaskIconClickListener onDeleteTaskIconClickListener, OnItemClickListener<Task> clickListener) {
        this.onDeleteTaskIconClickListener = onDeleteTaskIconClickListener;
        this.clickListener = clickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_task_list_item, null, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Task task = taskList.get(holder.getAdapterPosition());
        holder.tvTitle.setText(task.getTitle());
        holder.tvDescription.setText(task.getDescription());

        holder.ivTaskDelete.setOnClickListener(view -> {
            if (onDeleteTaskIconClickListener != null) {
                onDeleteTaskIconClickListener.onDeleteIconClicked(task);
            }
        });

        holder.itemView.setOnClickListener(view -> {
            if (clickListener != null) {
                clickListener.onItemClick(task);
            }
        });
    }

    @Override
    public int getItemCount() {
        return taskList.size();
    }

    public void setTaskList(List<Task> taskList) {
        this.taskList = taskList;
        notifyDataSetChanged();
    }

    public void removeTask(Task task) {
        taskList.remove(task);
        notifyDataSetChanged();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.cell_tv_task_title)
        TextView tvTitle;

        @BindView(R.id.cell_tv_task_description)
        TextView tvDescription;

        @BindView(R.id.cell_iv_task_delete)
        ImageView ivTaskDelete;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
