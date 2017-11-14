package com.vikoo.todo.di.module;

import android.content.Context;

import com.vikoo.todo.di.qualifier.AppContextQualifier;
import com.vikoo.todo.di.scope.AppScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by vikoo on 14/11/17.
 */

@Module
public class ContextModule {

    private final Context mAppContext;

    public ContextModule(Context context){
        mAppContext = context;
    }

    @Provides
    @AppScope
    public @AppContextQualifier Context context(){
        return mAppContext;
    }
}
