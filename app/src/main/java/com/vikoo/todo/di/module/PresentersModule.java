package com.vikoo.todo.di.module;

import com.vikoo.todo.di.scope.ActivityScope;
import com.vikoo.todo.screens.addtodo.AddTodoContract;
import com.vikoo.todo.screens.addtodo.AddTodoPresenter;
import com.vikoo.todo.screens.todolist.TodoListContract;
import com.vikoo.todo.screens.todolist.TodoListPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by vikoo on 14/11/17.
 */

@Module(includes = {DbModule.class})
public class PresentersModule {

    @Provides
    @ActivityScope
    public TodoListContract.Presenter agendaPresenter(){
        return new TodoListPresenter();
    }

    @Provides
    @ActivityScope
    public AddTodoContract.Presenter addEventPresenter(){
        return new AddTodoPresenter();
    }

}
