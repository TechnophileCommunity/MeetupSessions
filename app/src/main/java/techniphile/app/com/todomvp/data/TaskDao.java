package techniphile.app.com.todomvp.data;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by moinkhan on 18-01-2018.
 */

@Dao
public interface TaskDao {

    @Insert
    int insertTask(Task task);

    @Query("SELECT * FROM Task")
    List<Task> getAllTask();
}
