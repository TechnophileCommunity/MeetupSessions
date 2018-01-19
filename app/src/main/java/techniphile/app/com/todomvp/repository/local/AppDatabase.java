package techniphile.app.com.todomvp.repository.local;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

/**
 * Created by moinkhan on 18-01-2018.
 */

@Database(entities = Task.class, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase sInstance;

    public abstract TaskDao taskDao();

    public static AppDatabase getInstance(final Context context) {
        if (sInstance == null) {
            synchronized (AppDatabase.class) {
                if (sInstance == null) {
                    sInstance = Room.databaseBuilder(context, AppDatabase.class, "db_task")
                            .allowMainThreadQueries()
                            .build();
                }
            }
        }
        return sInstance;
    }


}
