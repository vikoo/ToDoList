package com.vikoo.todo.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.vikoo.todo.db.dao.TodoListDao;
import com.vikoo.todo.db.entity.TodoEntity;

/**
 * Created by vikoo on 14/11/17.
 */

@Database(
        entities = {
                TodoEntity.class
        },
        version = 1,
        exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public static final String DB_NAME = "app_db";

    public abstract TodoListDao getTodoListDao();
}
