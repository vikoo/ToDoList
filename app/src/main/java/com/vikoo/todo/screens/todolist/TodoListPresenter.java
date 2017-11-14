package com.vikoo.todo.screens.todolist;

import com.vikoo.todo.db.entity.TodoEntity;
import com.vikoo.todo.di.component.ApplicationComponent;

import java.util.List;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;

/**
 * Created by vikoo on 14/11/17.
 */

public class TodoListPresenter implements TodoListContract.Presenter {

    private TodoListContract.View mView;
    private ApplicationComponent mApplicationComponent;

    @Override
    public void attach(TodoListContract.View view, ApplicationComponent applicationComponent) {
        mView = view;
        mApplicationComponent = applicationComponent;
    }

    @Override
    public void detach() {
        mView = null;
    }


    @Override
    public void fetchTodoList() {
        mApplicationComponent.getDatabase().getTodoListDao().getAll().subscribe(new SingleObserver<List<TodoEntity>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onSuccess(List<TodoEntity> todoEntities) {
                processTodos(todoEntities);
            }

            @Override
            public void onError(Throwable e) {
            }
        });
    }

    private void processTodos(List<TodoEntity> todos){
        mView.showTodos(todos);
    }
}
