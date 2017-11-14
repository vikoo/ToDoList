package com.vikoo.todo;

import android.app.Application;
import android.content.Context;

import com.vikoo.todo.di.component.ApplicationComponent;
import com.vikoo.todo.di.component.DaggerApplicationComponent;
import com.vikoo.todo.di.module.ContextModule;

/**
 * Created by vikoo on 14/11/17.
 */

public class TodoApplication extends Application {

    private ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mApplicationComponent = DaggerApplicationComponent.builder()
                .contextModule(new ContextModule(this))
                .build();
    }


    public ApplicationComponent getApplicationComponent(){
        return mApplicationComponent;
    }

    public static TodoApplication get(Context context){
        return (TodoApplication) context.getApplicationContext();
    }

}
