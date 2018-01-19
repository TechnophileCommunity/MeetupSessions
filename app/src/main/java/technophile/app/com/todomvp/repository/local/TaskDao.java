package technophile.app.com.todomvp.repository.local;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by moinkhan on 18-01-2018.
 */

@Dao
public interface TaskDao {

    @Insert
    long insertTask(Task task);

    @Query("SELECT * FROM tbl_task")
    List<Task> getAllTask();

    @Delete
    int deleteTask(Task task);
}
