package com.vikoo.todo.screens.todolist;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.vikoo.todo.R;
import com.vikoo.todo.db.entity.TodoEntity;

import java.util.List;

/**
 * Created by vikoo on 14/11/17.
 */

public class TodoListAdapter extends RecyclerView.Adapter<TodoListAdapter.TodoViewHolder> {

    private List<TodoEntity> mTodoList;

    public List<TodoEntity> getTodoList() {
        return mTodoList;
    }

    public void setTodoList(List<TodoEntity> mTodoList) {
        this.mTodoList = mTodoList;
        notifyDataSetChanged();
    }

    public TodoListAdapter(List<TodoEntity> list){
        mTodoList = list;
    }

    @Override
    public TodoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_todo, parent, false);
        return new TodoViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(TodoViewHolder holder, int position) {
        TodoEntity todoItem = mTodoList.get(position);
        holder.mTvDesc.setText(todoItem.todoDescription);
        holder.mTvTitle.setText(todoItem.todoTitle);
    }

    @Override
    public int getItemCount() {
        return mTodoList.size();
    }

    public static class TodoViewHolder extends RecyclerView.ViewHolder {
        public TextView mTvTitle;
        public TextView mTvDesc;

        public TodoViewHolder(View layout) {
            super(layout);
            mTvTitle = layout.findViewById(R.id.title);
            mTvDesc = layout.findViewById(R.id.desc);
        }
    }
}
