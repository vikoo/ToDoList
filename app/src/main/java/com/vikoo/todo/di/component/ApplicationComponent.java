package com.vikoo.todo.di.component;

import com.vikoo.todo.db.AppDatabase;
import com.vikoo.todo.di.module.ContextModule;
import com.vikoo.todo.di.module.DbModule;
import com.vikoo.todo.di.scope.AppScope;

import dagger.Component;

/**
 * Created by vikoo on 14/11/17.
 */

@AppScope
@Component (modules = {DbModule.class, ContextModule.class})
public interface ApplicationComponent {

    AppDatabase getDatabase();

}

