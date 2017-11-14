package com.vikoo.todo.di.module;

import android.arch.persistence.room.Room;
import android.content.Context;

import com.vikoo.todo.db.AppDatabase;
import com.vikoo.todo.di.qualifier.AppContextQualifier;
import com.vikoo.todo.di.scope.AppScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by vikoo on 14/11/17.
 */

@Module (includes = ContextModule.class)
public class DbModule {

    @Provides
    @AppScope
    public AppDatabase db(@AppContextQualifier Context context){
        return  Room.databaseBuilder(context, AppDatabase.class, AppDatabase.DB_NAME)
                .allowMainThreadQueries()
                .build();
    }

}
