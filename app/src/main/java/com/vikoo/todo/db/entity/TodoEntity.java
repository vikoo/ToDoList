package com.vikoo.todo.db.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;

import com.vikoo.todo.base.BaseEvent;

/**
 * Created by vikoo on 16/09/17.
 */

@Entity
public class TodoEntity {

    @PrimaryKey(autoGenerate = true)
    public int todoId;
    public String todoTitle;
    public String todoDescription;
    public boolean isCompleted;

}
