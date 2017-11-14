package com.vikoo.todo.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.vikoo.todo.db.entity.TodoEntity;

import java.util.List;

import io.reactivex.Single;

/**
 * Created by vikoo on 14/11/17.
 */

@Dao
public interface TodoListDao {

    String TABLE_NAME = "TodoEntity";

    @Query("DELETE FROM " + TABLE_NAME)
    void deleteTable();

    @Query("SELECT * FROM " + TABLE_NAME)
    Single<List<TodoEntity>> getAll();

    @Query("SELECT * FROM " + TABLE_NAME)
    List<TodoEntity> getAllEvents();

    @Query("SELECT * FROM " + TABLE_NAME + " WHERE todoId = :todoId")
    TodoEntity getEventById(String todoId);

    @Query("DELETE FROM " + TABLE_NAME + " WHERE todoId = :todoId")
    void deleteByEventById(String todoId);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void save(TodoEntity... entities);
}
