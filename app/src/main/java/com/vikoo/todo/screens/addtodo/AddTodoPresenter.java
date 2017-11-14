package com.vikoo.todo.screens.addtodo;

import android.text.TextUtils;

import com.vikoo.todo.db.entity.TodoEntity;
import com.vikoo.todo.di.component.ApplicationComponent;

/**
 * Created by vikoo on 14/11/17.
 */

public class AddTodoPresenter implements AddTodoContract.Presenter {

    public static final int ERROR_TITLE = 1;
    public static final int ERROR_DESC = 2;

    private AddTodoContract.View mView;
    private ApplicationComponent mApplicationComponent;

    @Override
    public void attach(AddTodoContract.View view, ApplicationComponent applicationComponent) {
        mView = view;
        mApplicationComponent = applicationComponent;
    }

    @Override
    public void detach() {
        mView = null;
    }


    @Override
    public void validate(String title, String desc) {
        if(TextUtils.isEmpty(title)){
            mView.onValidationFailed(ERROR_TITLE);
            return;
        }
        if(TextUtils.isEmpty(desc)){
            mView.onValidationFailed(ERROR_DESC);
            return;
        }
        addTodo(title, desc);

    }

    private void addTodo(String title, String desc){
        TodoEntity todoEntity = new TodoEntity();
        todoEntity.todoTitle = title;
        todoEntity.todoDescription = desc;
        todoEntity.isCompleted = false;
        mApplicationComponent.getDatabase().getTodoListDao().save(todoEntity);
        mView.onTodoAdded();
    }
}
