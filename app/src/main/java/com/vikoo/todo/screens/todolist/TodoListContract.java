package com.vikoo.todo.screens.todolist;

import com.vikoo.todo.base.BasePresenter;
import com.vikoo.todo.base.BaseView;
import com.vikoo.todo.db.entity.TodoEntity;

import java.util.List;

/**
 * Created by vikoo on 14/11/17.
 */

public class TodoListContract {

    public interface View extends BaseView<Presenter>{

        void showTodos(List<TodoEntity> events);
        List<TodoEntity> getCurrentTodoList();

    }

    public interface Presenter extends BasePresenter<View>{

        void fetchTodoList();
    }
}
