package com.vikoo.todo.screens.todolist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.vikoo.todo.R;
import com.vikoo.todo.TodoApplication;
import com.vikoo.todo.base.BaseActivity;
import com.vikoo.todo.db.entity.TodoEntity;
import com.vikoo.todo.di.component.DaggerActivityComponent;
import com.vikoo.todo.screens.addtodo.AddTodoActivity;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by vikoo on 14/11/17.
 */

public class TodoListActivity extends BaseActivity implements TodoListContract.View{

    public static final String EXTRA_DATE = "date";

    @Inject
    TodoListContract.Presenter mPresenter;

    @BindView(R.id.todo_list_view)
    RecyclerView mTodoListView;

    private TodoListAdapter mAdapter;
    private List<TodoEntity> mTodoList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_list);
        ButterKnife.bind(this);

        setupToolBar();
        DaggerActivityComponent.builder()
                .applicationComponent(TodoApplication.get(this).getApplicationComponent())
                .build()
                .inject(this);


        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mTodoList = new ArrayList<>();
        mAdapter = new TodoListAdapter(mTodoList);
        mTodoListView.setLayoutManager(layoutManager);
        mTodoListView.setAdapter(mAdapter);
        mPresenter.attach(this, mApplicationComponent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mPresenter.fetchTodoList();
    }

    @Override
    public void showTodos(List<TodoEntity> todos) {
        mTodoList.clear();
        mTodoList = todos;
        mAdapter.setTodoList(todos);
    }

    @Override
    public List<TodoEntity> getCurrentTodoList() {
        return mTodoList;
    }

    @OnClick(R.id.btn_add_todo)
    public void onAddEventClick(View view){
        Intent i = new Intent(getApplicationContext(), AddTodoActivity.class);
        startActivity(i);
    }

}
