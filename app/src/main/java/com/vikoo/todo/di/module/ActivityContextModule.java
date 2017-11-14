package com.vikoo.todo.di.module;

import android.app.Activity;
import android.content.Context;

import com.vikoo.todo.di.qualifier.ActivityContextQualifier;
import com.vikoo.todo.di.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by vikoo on 14/11/17.
 */

@Module
public class ActivityContextModule {

    private final Activity mActivity;

    public ActivityContextModule(Activity context){
        mActivity = context;
    }

    @Provides
    @ActivityContextQualifier
    @ActivityScope
    public Context appContext(){
        return mActivity;
    }

    @Provides
    @ActivityContextQualifier
    @ActivityScope
    public Activity activity(){
        return mActivity;
    }
}
