package com.vikoo.todo.di.component;

import com.vikoo.todo.screens.addtodo.AddTodoActivity;
import com.vikoo.todo.screens.todolist.TodoListActivity;
import com.vikoo.todo.di.module.ActivityContextModule;
import com.vikoo.todo.di.module.PresentersModule;
import com.vikoo.todo.di.scope.ActivityScope;

import dagger.Component;

/**
 * Created by vikoo on 14/11/17.
 */

@ActivityScope
@Component (modules = {ActivityContextModule.class, PresentersModule.class}, dependencies = {ApplicationComponent.class})
public interface ActivityComponent {

    void inject(TodoListActivity calenderActivity);
    void inject(AddTodoActivity calenderActivity);
}

